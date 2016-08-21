package test_main;

public class HouseRobberII {

    public int rob(int[] nums) {
        if(nums.length == 0){
			return 0;
		}
		if(nums.length == 1){
			return nums[0];
		}
		if(nums.length == 2){
			return Math.max(nums[0], nums[1]);
		}
       return Math.max(nums[nums.length - 1] + getS(nums, 1, nums.length - 2), getS(nums, 0, nums.length - 1));
    }
    
    private int getS(int[] nums, int start, int end){
		int s1 = 0, s2 = 0;
		if(start <= end){
    		for(int i = start; i < end; i ++){
    			int temp = s2;
    			s2 = Math.max(nums[i] + s1, s2);
    			s1 = temp;
    		}
		}
		return s2;
	}
	
}
