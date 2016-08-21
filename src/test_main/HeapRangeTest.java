package test_main;

import java.util.Arrays;

public class HeapRangeTest {

	public void heapRange(int[] nums){
		for(int start = nums.length - 1; start >= 0; start --){
			getMinNum(nums, start);
			exchange(nums, 0, start);
		}
	}
	
	private void getMinNum(int[] nums, int start) {
		int max = start;
		while(start >= 0){
			swapThree(nums, start, max);
			start --;
		}
	}

	private void swapThree(int[] nums, int start, int max) {
		if(2*start + 1 > max){
			return;
		}
		if(2*start + 1 <= max && 2*start + 2 > max){
			if(nums[start] > nums[2*start + 1])
				exchange(nums, start, 2*start + 1);
			return;
		}
		boolean lc = false;
		boolean rc = false;
		if(nums[start] > nums[2*start + 1]){
			lc = true;
			exchange(nums, start, 2*start + 1);
		}
		if(nums[start] > nums[2*start + 2]){
			rc = true;
			exchange(nums, start, 2*start + 2);
		}
		if(lc)
			swapThree(nums, 2*start + 1, max);
		if(rc)
			swapThree(nums, 2*start + 2, max);
	}

	public void exchange(int[] nums, int i1, int i2){
		if(nums[i1] == nums[i2])
			return;
		nums[i1] ^= nums[i2];
		nums[i2] ^= nums[i1];
		nums[i1] ^= nums[i2];
	}
	
	public static void main(String[] args) {
		int[] nums = {1,4,3,7,54,34,76,88,34,54,66,99};
		new HeapRangeTest().heapRange(nums);
		System.out.println(Arrays.toString(nums));
	}

}
