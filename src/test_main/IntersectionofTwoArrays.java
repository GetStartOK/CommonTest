package test_main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionofTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for(int num : nums1){
        	set.add(num);
        }
        Set<Integer> res = new HashSet<Integer>();
        for(int num : nums2){
        	if(set.contains(num))
        		res.add(num);
        }
        int[] r = new int[res.size()];
        Iterator<Integer> it = res.iterator();
        int i = 0;
        while(it.hasNext()){
        	r[i++] = it.next();
        }
        return r;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		System.out.println(Arrays.toString(new IntersectionofTwoArrays().intersection(nums1, nums2)));
	}

}
