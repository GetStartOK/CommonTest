package test_main;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	public int lengthOfLIS(int[] nums) {
		if(nums.length == 0)
    		return 0;
    	int[] order = new int[nums.length + 1];
    	order[1] = nums[0]; 
    	int index = 1;
        for(int i = 0, j = nums.length; i < j; i++){
        	for(int k = index; k >= 1; k --){
        		if(nums[i] > order[k]){
        			order[++ k] = nums[i];
                	if(k > index)
                		index ++;
                	break;
        		}
        		if(k == 1)
        			order[1] = nums[i];
        	}
        }
        return index;
	}
	
    public int lengthOfLIS2(int[] nums) {
    	if(nums.length == 0)
    		return 0;
    	int max = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for(int i = 0, j = nums.length; i < j; i++){
        	for(int k = 0; k < i; k ++)
        		if(nums[i] > nums[k])
        			dp[i] = Math.max(dp[i], dp[k] + 1);
        	max = Math.max(max, dp[i]);
        }
        return max;
    }
	
	public static void main(String[] args) {
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
	}

}
