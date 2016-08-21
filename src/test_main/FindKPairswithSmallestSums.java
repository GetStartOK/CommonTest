package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new ArrayList<int[]>();
    	int[] ns1 = new int[nums1.length];
    	int[] ns2 = new int[nums2.length];
    	
    	for(int i = 0; i < nums1.length && i < nums2.length && res.size() < k;){
    		int shu = nums1[i] + nums2[i];
    		if(ns1[i] == 0 && ns2[i] == 0){
	    		ns1[i] = i + 1;
	    		ns2[i] = i + 1;
    		}
    		int tmps = Integer.MAX_VALUE, ts = 0, tx = 0;
    		for(int j = 0; j < i; j++){
    			if(tmps > nums1[j] + nums2[ns1[j]]){
    				tmps = nums1[j] + nums2[ns1[j]];
    				ts = j;
    				tx = ns1[j];
    			}
    			if(tmps > nums1[ns2[j]] + nums2[j]){
    				tmps = nums1[ns2[j]] + nums2[j];
    				ts = ns2[j];
    				tx = j;
    			}
    		}
    		if(shu < tmps){
    			int[] tt  = {nums1[i], nums2[i]};
    			res.add(tt);
    			i++;
    		}else{
    			int[] tt  = {nums1[ts], nums2[tx]};
    			res.add(tt);
    			if(ts > tx && ts < nums1.length)
    				ns2[tx] ++;
    			else if(ts < tx && tx < nums2.length)
    				ns1[ts] ++;
    		}
    	}
    	if(res.size() < k){
    		
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3};
		int k = 3;
		List<int[]> res = new FindKPairswithSmallestSums().kSmallestPairs(nums1, nums2, k);
		for(int[] r : res){
			System.out.println(Arrays.toString(r));
		}
	}

}
