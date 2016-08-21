package test_main;

import java.io.File;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.fileupload.FileItem;
import org.springframework.stereotype.Service;

import com.rgsc.annotation.CacheKey;
import com.rgsc.annotation.CacheList;
import com.rgsc.annotation.CacheModify;
import com.rgsc.annotation.ModifyKey;
import com.rgsc.annotation.ModifyKey.IdField;
import com.rgsc.dao.IHealthDao;
import com.rgsc.entity.BloodPressure;
import com.rgsc.entity.FromType;
import com.rgsc.entity.HealthRecord;
import com.rgsc.entity.Heartbeat;
import com.rgsc.entity.Temperature;
import com.rgsc.service.IHealthService;
import com.rgsc.utils.Flag;
import com.rgsc.utils.JsonTools;
import com.rgsc.utils.RStrings;

@Service(value="healthService")
public class HealthServiceImpl implements IHealthService {

	@Resource(name="healthDao")
	private IHealthDao healthDao;
	
	@Override
	@CacheModify(ObjType="HealthRecord")
	public Map<String, String> uploadHealthRecord(List<FileItem> items) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		int uid = 0;
		long rid = 0;
		long timestamp = System.currentTimeMillis();
		Timestamp real_time = new Timestamp(timestamp);
		File tar_dir = null;
		for(FileItem item:items){  
            if(!item.isFormField()){    //如果是上传的文件  
            	if(uid != 0){
	            	if(tar_dir == null){
		        		String cur_path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		        		cur_path = cur_path.replace(RStrings.SWAP_URL, "");
		        		tar_dir = new File(cur_path+RStrings.RESOURCES_PATH+RStrings.HEALTH_RECORD_PATH+uid);
		        		if(!tar_dir.exists()){
		        			if(!tar_dir.mkdirs()){
		        				throw new RuntimeException("创建文件夹异常！");
		        			}
		        		}
	            	}
	            	if(!this.uploadHealthImg(tar_dir, item, timestamp, rid, uid)){
	            		map.put("msg", "upload health record fail");
	            		return map;
	            	}
            	}else{
            		map.put("msg", "didn't get uid");
            		return map;
            	}
            }else{
            	String recStr = "";
            	switch(item.getFieldName()){
            	case "healthRecordStr" : recStr = item.getString("utf-8"); break;
            	}
            	HealthRecord hr = JsonTools.fromJson(recStr, HealthRecord.class);
            	uid = hr.getUid();
            	if(uid == 0){
            		map.put("msg", "upload health record fail");
            		return map;
            	}
            	hr.setReal_time(real_time);
            	hr.setImagePaths(null);//避免APP路径被存入数据库
        		rid = healthDao.insertHealthRecord(hr);
        		if(rid != 0)
        			map.put("msg", "upload health record success");
        		
            	Map<String, String> rc_signs = hr.getRc_signs();
            	if(rc_signs != null && rc_signs.size() > 0){
            		if(!uploadRc_signs(rc_signs, real_time, rid, uid)){
            			map.put("msg", "upload rc_signs fail");
            		}
            	}
            }
        }  
		return map;
	}

	private boolean uploadRc_signs(Map<String, String> rc_signs, Timestamp rc_time, long rid, int uid) {
		boolean b = false;
		try {
			String heartbeat = rc_signs.get(RStrings.SIGNS_HEARTBEAT);
			String temperature = rc_signs.get(RStrings.SIGNS_TEMPERATURE);
			String systolic_pressure= rc_signs.get(RStrings.SIGNS_SYSTOLIC_PRESSURE);
			String diastolic_pressure = rc_signs.get(RStrings.SIGNS_DIASTOLIC_PRESSURE);
			if(heartbeat != null){
				b = healthDao.addHeartBeat(uid, rid, Float.parseFloat(heartbeat), rc_time);
			}
			if(temperature != null){
				b = healthDao.addBodyTemperature(uid, rid, Float.parseFloat(temperature), rc_time);
			}
			if(systolic_pressure != null && diastolic_pressure != null){
				b = healthDao.addBloodPressure(uid, rid, Float.parseFloat(systolic_pressure), Float.parseFloat(diastolic_pressure), rc_time);
			}
		} catch (Exception e) {
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	private boolean uploadHealthImg(File tar_dir, FileItem item, long timestamp, long rid, int uid){
		boolean b = true;
		String fileName = item.getName().substring(item.getName().lastIndexOf('\\')+1);
		String filePath = tar_dir.getAbsolutePath()+File.separator+String.valueOf(timestamp)+"-"+fileName;
        System.out.println(filePath);  
        File f = new File(filePath);
        try {
			item.write(f);
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		}  
        String imgPath = RStrings.HEALTH_RECORD_PATH+uid+File.separator+String.valueOf(timestamp)+"-"+fileName;
        if(!healthDao.insertHealthImgPath(rid, imgPath))
        	b = false;
		return b;
	}

	@Override
	@CacheList(key="HealthRecord:list")
	public List<HealthRecord> getHealthRecordsById(@CacheKey int uid,@CacheKey int start_num, @CacheKey FromType fromType) {
		return healthDao.findHealthRecordsById(uid, start_num, fromType);
	}

	@Override
	@CacheModify(ObjType="HealthRecord")
	public Map<String, Object> delHealthRecordById(@ModifyKey(idField=IdField.SELF) long rid) {
		int uid = healthDao.getUidByRid(rid);
		Flag f = Flag.SUCCESS;
		List<String> imgPaths = healthDao.delHealthRecordById(rid);
		if(imgPaths.size() == 1 && imgPaths.contains("del fail")){
			f = Flag.FAIL;
		}else{
			for(String path : imgPaths){
				String cur_path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
				cur_path = cur_path.replace(RStrings.SWAP_URL, "");
				String tar_dir = cur_path+RStrings.RESOURCES_PATH+path;
				File file = new File(tar_dir);
				if(file.exists())
					file.delete();
			}
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("flag", f);
		if(f.equals(Flag.SUCCESS)){
			map.put("msg", "del health record success");
			map.put("uid", uid);
		}else
			map.put("msg", "del health record fail");
		return map;
	}

	@Override
	public Flag setDoctorCanAccess(long rid, boolean doctor_access) {
		return healthDao.setDoctorCanAccess(rid, doctor_access);
	}

	@Override
	public List<HealthRecord> getHealthRecordsByIdFromDoctor(int uid, int start_num, FromType fromType) {
		return healthDao.findHealthRecordsByIdFromDoctor(uid, start_num, fromType);
	}

	@Override
	public List<Heartbeat> getHeartbeat(int uid, Timestamp start_time, Timestamp end_time) {
		return healthDao.getHeartbeat(uid, start_time, end_time);
	}

	@Override
	public List<Temperature> getTemperature(int uid, Timestamp start_time, Timestamp end_time) {
		return healthDao.getTemperature(uid, start_time, end_time);
	}

	@Override
	public List<BloodPressure> getBloodPressure(int uid, Timestamp start_time, Timestamp end_time) {
		return healthDao.getBloodPressure(uid, start_time, end_time);
	}
}
