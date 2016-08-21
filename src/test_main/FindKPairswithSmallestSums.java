package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindKPairswithSmallestSums {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> res = new ArrayList<int[]>();
    	if(nums1.length == 0 || nums2.length == 0 || k == 0)
    		return res;
        for(int i = 1, j = 1, m = nums1.length, n = nums2.length; i < m && j < n && res.size() < k;){
        	int[] ii = {nums1[i - 1], nums2[j - 1]};
        	res.add(ii);
        	if(nums1[i - 1] + nums2[j] > nums1[i] + nums2[j - 1]){
        		int[] is = {nums1[i], nums2[j - 1]};
        		i ++;
        		res.add(is);
        	}else{
        		int[] is = {nums1[i - 1], nums2[j]};
        		j ++;
        		res.add(is);
        	}
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
