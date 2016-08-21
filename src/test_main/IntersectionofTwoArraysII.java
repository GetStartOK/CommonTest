package test_main;

import java.util.Arrays;

public class IntersectionofTwoArraysII {

    public int[] intersection(int[] nums1, int[] nums2) {
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       int tmp[] = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
       int m = 0;
       for(int i = 0, j = 0, k = nums1.length, l = nums2.length; i < k && j <l;){
    	   if(nums1[i] > nums2[j])
    		   j++;
    	   else if(nums1[i] < nums2[j])
    		   i++;
    	   else{
    		   tmp[m++] = nums1[i];
    		   i++;j++;
    	   }
       }
       int res[] = new int[m];
       res = Arrays.copyOfRange(tmp, 0, m);
       return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {1,2,2,2};
		System.out.println(Arrays.toString(new IntersectionofTwoArraysII().intersection(nums1, nums2)));
	}

}
