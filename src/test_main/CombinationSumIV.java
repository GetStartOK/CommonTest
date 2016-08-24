package test_main;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4_2(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length == 0 || nums[0] > target)
        	return 0;
        int res = 0;
        int[] tmps =  new int[nums.length];
		int t = 0;
    	for(int m = 0, n = nums.length; m < n;){
    		while(t < target){
    			tmps[m] ++;
    			t += nums[m];
    		}
    		if(t == target){
    			int r = getRange(tmps);
    			res += r;
    		}
    		tmps[m] --;
    		t -= nums[m];
    		boolean back = false;
    		while(!back){
    			while(m >= 0 && tmps[m] <= 0){
        			m --;
        		}
    			if(m >= 0){
        			tmps[m] --;
            		t -= nums[m];
            		if(m < nums.length - 1){
            			m ++;
            			back = true;
            		}
        		}else{
        			return res;
        		}
    		}
    	}
        return res;
    }
    
	private int getRange(int[] tmps) {
		int all = 0;
		int sum = 1;
		for(int i = 0; i < tmps.length; i++){
			all += tmps[i];
		}
		
		for(int i = 0; i < tmps.length; i++){
			if(tmps[i] == 0)
				continue;
			int t = tmps[i];
			if(tmps[i] > all / 2)
				t = all - tmps[i];
			long t1 = 1, t2 = 1;
			for(int j = 0; j < t; j++){
				t1 *= (all - j);
				t2 *= (j + 1);
			}
			sum *= (t1 / t2);
			all -= tmps[i];
		}
		
		return sum;
	}
	private boolean  b = false;
	private int[] dp = null;
	public int combinationSum4(int[] nums, int target) {
		if(!b){
			Arrays.sort(nums);
			dp = new int[target + 1];
			Arrays.fill(dp, -1);
			b = true;
		}
		if(dp[target] != -1)
			return dp[target];
		int num = target;
		int res = 0;
		for(int i = 0, j = nums.length; i < j; i++){
			if(num - nums[i] == 0)
				res ++;
			else if(num - nums[i] > 0){
				res += combinationSum4(nums, num - nums[i]);
			}
			else{
				dp[target] = res;
				return res;
			}
		}
		dp[target] = res;
		return res;
	}
	public static void main(String[] args) {
//		int[] nums = {10,20,30,40,50,60,70,80,90,100,110,120,130,140,150,160,170,180,190,200,210,220,230,240,250,260,270,280,290,300,310,320,330,340,350,360,370,380,390,400,410,420,430,440,450,460,470,480,490,500,510,520,530,540,550,560,570,580,590,600,610,620,630,640,650,660,670,680,690,700,710,720,730,740,750,760,770,780,790,800,810,820,830,840,850,860,870,880,890,900,910,920,930,940,950,960,970,980,990,111};
//		int target = 999;
		int[] nums = {1,2,3,4};
		int target = 4;
		long t1 = System.currentTimeMillis();
		System.out.println(new CombinationSumIV().combinationSum4(nums, target));
		System.out.println(System.currentTimeMillis() - t1);
		
	}

}
