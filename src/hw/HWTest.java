package hw;

import java.io.ByteArrayOutputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;

public class HWTest {
	
	public void findWay(int s, int e, ArrayList<Integer> kNode){
		
	}

	 private static void getStrings() {
	        String str = "rrwerqq84461376qqasfdasdfrrwerqq84461377qqasfdasdaa654645aafrrwerqq84461378qqasfdaa654646aaasdfrrwerqq84461379qqasfdasdfrrwerqq84461376qqasfdasdf";
	        Pattern p = Pattern.compile("qq(.*?)qq");
	        Matcher m = p.matcher(str);
	        ArrayList<String> strs = new ArrayList<String>();
	        while (m.find()) {
	            strs.add(m.group(1));            
	        } 
	        for (String s : strs){
	            System.out.println(s);
	        }        
	    }
	
	public static byte[] gZip(byte[] data) {
		  byte[] b = null;
		  try {
		   ByteArrayOutputStream bos = new ByteArrayOutputStream();
		   GZIPOutputStream gzip = new GZIPOutputStream(bos);
		   gzip.write(data);
		   gzip.finish();
		   gzip.close();
		   b = bos.toByteArray();
		   bos.close();
		  } catch (Exception ex) {
		   ex.printStackTrace();
		  }
		  return b;
	 }
	
	public static void main(String[] args) {
//		byte[] data = new byte[20000];
//		Random r = new Random(128);
//		for(int i = 0; i < data.length; i++){
//			data[i] = (byte) r.nextInt(127);
//		}
//		System.out.println(gZip(data).length);
//		int[] a = {4,2,1,0,2,2,1,9,9,7,6,0,1};
//		int[] b = {7,9,10,5,8,4,2,1,6,3,8,4,2,7,9,10,5};
//		int s = 0;
//		for(int i = 0; i < a.length; i++){
//			s += a[i] * b[i];
//		}
//		for(int i = 0; i < 2; i++){
//			for(int j = 0; j < 10; j++){
//				for(int k = 0; k < 3; k += 2){
//					for(int l = 0; l < 10; l ++){
//						int t = s + i * b[13] + j * b[14] + k * b[15] + l * b[16];
//						if(t % 11 == 2){
//							System.out.print(i+""+j+k+l);
//							System.out.println();
//						}
//					}
//				}
//			}
//		}
		long l = System.currentTimeMillis();
		System.out.println(l);
		Timestamp t = new Timestamp(l);
		t.getTime();
		System.out.println(t.getTime());
	}
}
