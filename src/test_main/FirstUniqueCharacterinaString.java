package test_main;

import java.util.Arrays;

public class FirstUniqueCharacterinaString {
    public int firstUniqChar(String s) {
    	if(s.length() == 0)
    		return -1;
    	int[] nums = new int[26];
    	int[] loc = new int[26];
    	Arrays.fill(loc, -1);
        for(int i = 0, j = s.length(); i < j; i++){
        	char ch = s.charAt(i);
        	int index = ch - 97;
        	nums[index] ++;
        	if(nums[index] == 1)
        		loc[index] = i;
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == 1 && loc[i] != -1){
        		res = Math.min(res, loc[i]);
        	}
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
    public static void main(String[] args) {
    	String s = "eeddcc";
    	System.out.println(new FirstUniqueCharacterinaString().firstUniqChar(s));
	}
}
