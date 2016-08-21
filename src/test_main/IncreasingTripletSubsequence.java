package test_main;

public class IncreasingTripletSubsequence {
	
	public static boolean increasingTriplet(int[] nums) {
		if(nums.length < 3)
			return false;
		int i1 = 0;
		int i2 = 0;
		int m1 = 0;
		while(i2 < nums.length - 1 && nums[i2] >= nums[++i2]);
		if(i2 == nums.length - 1)
			return false;
		i1 = i2-1;
        for(int i = i2 + 1; i < nums.length; i++){
        	if(nums[i2] < nums[i]){
        		return true;
        	}else{
        		if(i1 >= m1){
        			if(nums[i1] < nums[i]){
                		i2 = i;
                	}else{
                		m1 = i;
                	}
        		}else{
        			if(nums[m1] < nums[i]){
        				i2 = i;
        				i1 = m1;
        			}else{
        				m1 = i;
        			}
        		}
        	} 
        }
        return false;
    }
	
	public static void main(String[] args) {
		int[] nums = {1, 5, 2,1, 7};
		System.out.println(increasingTriplet(nums));
	}
	
}
