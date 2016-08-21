package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
    	 if(nums.length == 0)
    	       return new ArrayList<Integer>();
    	Arrays.sort(nums);
    	Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    	List<Integer> res = new ArrayList<Integer>();
    	List<Integer> tmp = new ArrayList<Integer>();
    	int r = nums[0];
        for(int i = 0, j = nums.length; i < j; i++){
        	map.put(nums[i], new ArrayList<Integer>());
        	for(int m = 0; m <= i; m++){
        		if(nums[i] % nums[m] == 0){
        			tmp.clear();
        			tmp.addAll(map.get(nums[m]));
        			tmp.add(nums[i]);
        		}
        		if(tmp.size() > res.size()){
            		res.clear();
            		res.addAll(tmp);
            	}
        	}
        	map.get(nums[i]).addAll(res);
        	if(res.size() > map.get(r).size()){
        		r = nums[i];
        	}
        	res.clear();
        }
        return map.get(r);
    } 
    
    public static void main(String[] args) {
    	int[] nums = {1,2,4,8,9,72};
		System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
	}
	
}
