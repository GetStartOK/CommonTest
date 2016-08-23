package test_main;

import java.util.Arrays;

public class CombinationSumIV {

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        for(int i = 0, j = nums.length; i < j; i++){
        	for(int m = 0, n = nums.length; m < n; m ++){
        		
        	}
        }
    }
    
	public static void main(String[] args) {
		int[] nums = {};
		int target = 0;
		System.out.println(new CombinationSumIV().combinationSum4(nums, target));
	}

}
