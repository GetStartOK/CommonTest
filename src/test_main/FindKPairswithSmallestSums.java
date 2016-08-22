package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new ArrayList<int[]>();
    	if(nums1.length == 0 || nums2.length == 0 || k == 0)
    		return res;
    	
    	int[] ns1 = new int[nums1.length];
    	int[] ns2 = new int[nums2.length];
    	
    	for(int i = 0; i < ns1.length; i++){
    		if(i + 1 < nums2.length)
    			ns1[i] = i + 1;
    		else
    			ns1[i] = -1;
    	}
    	
    	for(int i = 0; i < ns2.length; i++){
    		if(i + 1 < nums1.length)
    			ns2[i] = i + 1;
    		else
    			ns2[i] = -1;
    	}
    	
    	int i = 0;
    	for(; i < nums1.length && i < nums2.length && res.size() < k;){
    		int shu = nums1[i] + nums2[i];
    		int tmps = Integer.MAX_VALUE, ts = 0, tx = 0;
    		for(int j = 0; j < i; j++){
    			if(ns1[j] != -1 && tmps > nums1[j] + nums2[ns1[j]]){
    				tmps = nums1[j] + nums2[ns1[j]];
    				ts = j;
    				tx = ns1[j];
    			}
    			if(ns2[j] != -1 && tmps > nums1[ns2[j]] + nums2[j]){
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
    			if(ts > tx){
    				if(ts < nums1.length - 1)
    					ns2[tx] ++;
    				else
    					ns2[tx] = -1;
    			}else if(ts < tx){
    				if(tx < nums2.length - 1)
    					ns1[ts] ++;
    				else
    					ns1[ts] = -1;
    			}
    		}
    	}
    	if(res.size() < k){
    		if(i < nums1.length){
    			for(; i < nums1.length && res.size() < k;){
					int tmps = Integer.MAX_VALUE, ts = 0, tx = 0;
    				for(int j = 0; j < nums2.length; j++){
    	    			if(ns2[j] != -1 && tmps > nums1[ns2[j]] + nums2[j]){
    	    				tmps = nums1[ns2[j]] + nums2[j];
    	    				ts = ns2[j];
    	    				tx = j;
    	    			}
    	    		}
    				if(tmps > nums1[i] + nums2[nums2.length - 1]){
	    				int[] tt  = {nums1[i], nums2[nums2.length - 1]};
	        			res.add(tt);
	        			i++;
    				}else{
    	    			int[] tt  = {nums1[ts], nums2[tx]};
    	    			res.add(tt);
    	    			if(ts == i && tx == nums2.length - 1)
    	    				i++;
    	    			if(ts > tx){
    	    				if(ts < nums1.length - 1)
    	    					ns2[tx] ++;
    	    				else
    	    					ns2[tx] = -1;
    	    			}
    	    		}
    			}
    		}else if(i < nums2.length){
    			for(; i < nums2.length && res.size() < k;){
    		    	int tmps = Integer.MAX_VALUE, ts = 0, tx = 0;
    				for(int j = 0; j < nums1.length; j++){
    					if(ns1[j] != -1 && tmps > nums1[j] + nums2[ns1[j]]){
    						tmps = nums1[j] + nums2[ns1[j]];
    						ts = j;
    						tx = ns1[j];
    					}
    				}
    				if(tmps > nums1[nums1.length - 1] + nums2[i]){
    					int[] tt  = {nums1[nums1.length - 1], nums2[i]};
    					res.add(tt);
    					i++;
    				}else{
    					int[] tt  = {nums1[ts], nums2[tx]};
    					res.add(tt);
    					if(tx == i && ts == nums1.length - 1)
    	    				i++;
    					if(tx < nums2.length - 1)
    						ns1[ts] ++;
    					else
    						ns1[ts] = -1;
    				}
    			}
    		}
    	}
    	return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,4,5,6};
		int[] nums2 = {3,5,7,9};
		int k = 21;
		List<int[]> res = new FindKPairswithSmallestSums().kSmallestPairs(nums1, nums2, k);
		for(int[] r : res){
			System.out.println(Arrays.toString(r));
		}
	}

}
