package test_main;

import java.util.LinkedList;

public class CountofRangeSum {

	public int countRangeSum(int[] nums, int lower, int upper) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		int count = 0;
		if(nums.length == 0)
			return count;
		int max = nums[0];
		int t = 0;
		list.add(nums[0]);
		if(nums[0] <= upper && nums[0] >= lower)
			count++;
		for(int i = 1; i < nums.length; i++){
			int j = 0;
			max += nums[i];
			int l1,r1;
			l1 = 0;
			r1 = list.size();
			do{
				j = (l1 + r1) / 2;
				t = list.get(j);
				if(t > max){
					if(j == 0){
						list.addFirst(max);
						break;
					}else if(list.get(j - 1) < max){
						list.add(j, max);
						break;
					}else{
						r1 = j;
					}
				}else if(t < max){
					if(j == list.size() - 1){
						list.addLast(max);
						j++;
						break;
					}else if(list.get(j + 1) > max){
						list.add(j + 1, max);
						j++;
						break;
					}else{
						l1 = j;
					}
				}else{
					list.add(j, max);
					break;
				}
			}while(true);
			
			int left = max - upper;
			int right = max - lower;
			int l = 0, r = 0;
			int l2,r2;
			l2 = 0;
			r2 = list.size();
			do{
				
				l = (l2 + r2) / 2;
				t = list.get(l);
				if(t > left){
					if(l == 0){
						break;
					}else if(list.get(l - 1) < left){
						break;
					}else{
						r2 = l;
					}
				}else if(t < left){
					if(l == list.size() - 1){
						l++;
						break;
					}else if(list.get(l + 1) > left){
						l++;
						break;
					}else{
						l2 = l;
					}
				}else{
					break;
				}
			}while(true);

			if(l >= list.size())
				continue;
			int l3,r3;
			l3 = l;
			r3 = list.size();
			do{
				r = (l3 + r3) / 2;
				t = list.get(r);
				if(t > right){
					if(r == l){
						r--;
						break;
					}else if(list.get(r - 1) < right){
						r--;
						break;
					}else{
						r3 = r;
					}
				}else if(t < right){
					if(r == list.size() - 1){
						break;
					}else if(list.get(r + 1) > right){
						break;
					}else{
						l3 = r;
					}
				}else{
					break;
				}
			}while(true);
			if(l <= r){
				count += r - l + 1;
			}
			if(lower <= 0 && upper >= 0)
				count --;
			if(max >= lower && max <= upper)
				count ++;
		}
		return count;
    }
	
	
	
	public static void main(String[] args) {
		int[] nums = {-3,1,2,-2,2,-1};
	//	int[] nums = {28,26,22,7,12,-26,25,11,-14,0,0,6,20,4,17,-7,4,-14,-19};
		System.out.println(new CountofRangeSum().countRangeSum(nums, -3, -1));
	}

}
