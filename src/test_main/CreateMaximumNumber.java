package test_main;

import java.util.Arrays;
import java.util.LinkedList;

public class CreateMaximumNumber {

	LinkedList<Integer> l1 = null;
	LinkedList<Integer> l2 = null;
    int[] res = null;
    int at = 0;
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       l1 = new LinkedList<Integer>();
       l2 = new LinkedList<Integer>();
       res = new int[k];
       for(int i : nums1)
    	   l1.add(i);
       for(int i : nums2)
    	   l2.add(i);
//       for(at = k; at > 0; at--){
//    	   res[k - at] = findMaxAt(l1, l2, at);
//       }
       System.out.println(f(0,0,k).list);
       return res;
    }
	private int findMaxAt(LinkedList<Integer> l1, LinkedList<Integer> l2, int n) {
		boolean isFirst = true;
		int max = -1;
		int index = -1;
		LinkedList<Integer> tl1 = new LinkedList<Integer>();
		LinkedList<Integer> tl2 = new LinkedList<Integer>();
		for(int j = 0; j < l1.size(); j++){
			int t = l1.get(j);
			if((l1.size() - j + l2.size()) < n)
				break;
			if(max < t){
				isFirst = true;
				max = t;
				index = j;
			}
		}
		for(int i = index + 1; i < l1.size(); i++){
			tl1.add(l1.get(i));
		}
		int max2 = -1;
		int index2 = -1;
		for(int j = 0; j < l2.size(); j++){
			int t = l2.get(j);
			if((l2.size() - j + l1.size()) < n)
				break;
			if(max2 < t){
				max2 = t;
				index2 = j;
			}
		}
		if(max < max2){
			isFirst = false;
			max = max2;
			index = index2;
		}else if(max == max2 && isFirst){
			int t1 = 0;
			if(n - 1 > 0)
				t1 = findMaxAt(tl1, l2, n - 1);
			int t2 = 0;
			for(int i = index2 + 1; i < l2.size(); i++){
				tl2.add(l2.get(i));
			}
			if(n - 1 > 0)
				t2 = findMaxAt(l1, tl2, n - 1);
			if(t1 < t2){
				isFirst = false;
				index = index2;
			}
		}else if(max > max2){
			isFirst = true;
		}
		
		if(at == n){
//			if(res[res.length - at] <= max){
//				res[res.length - at] = max;
//				if(isFirst){
//					this.l1 = tl1;
//				}else{
//					if(tl2.size() == 0){
//						for(int i = index + 1; i < l2.size(); i++){
//							tl2.add(l2.get(i));
//						}
//					}
//					this.l2 = tl2;
//				}
//			}
		}
		
		return max;
	}
	
	private Result f(int ls, int rs, int n){
		boolean isFirst = true;
		int max = -1;
		int index = -1;
		for(int i = ls; i < l1.size(); i++){
			int t = l1.get(i);
			if((l1.size() - i + l2.size() - rs) < n)
				break;
			if(max < t){
				isFirst = true;
				max = t;
				index = i;
			}
		}
		int max2 = -1;
		int index2 = -1;
		for(int i = rs; i < l2.size(); i++){
			int t = l2.get(i);
			if((l2.size() - i + l1.size() - ls) < n)
				break;
			if(max2 < t){
				isFirst = true;
				max2 = t;
				index2 = i;
			}
		}
		if(max < max2){
			if(n - 1 > 0){
				Result r = f(ls, index2 + 1, n - 1);
				r.list.addFirst(max2);
				return r;
			}else{
				Result r = new Result();
				r.list.add(max2);
				return r;
			}
		}else if(max > max2){
			if(n - 1 > 0){
				Result r = f(index + 1, rs, n - 1);
				r.list.addFirst(max);
				return r;
			}else{
				Result r = new Result();
				r.list.add(max);
				return r;
			}
		}else{
			if(n - 1 > 0){
				Result lr = f(index + 1, rs, n - 1);
				Result rr = f(ls, index2 + 1, n - 1);
				if(lr.bigger(rr) >= 0){
					lr.list.addFirst(max);
					return lr;
				}else{
					rr.list.addFirst(max2);
					return rr;
				}
			}else{
				Result r = new Result();
				r.list.add(max);
				return r;
			}
		}
	}
	
	class Result{
		LinkedList<Integer> list = new LinkedList<Integer>();
		int ls;
		int rs;
		int n;
		
		int bigger(Result r){
			int l = this.list.size() >= r.list.size() ? r.list.size() : this.list.size();
			for(int i = 0 ; i < l; i ++){
				int t1 = this.list.get(i);
				int t2 = r.list.get(i);
				if(t1 != t2){
					return t1 - t2;
				}
			}
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int[] nums1 = {8,0,4,4,1,7,3,6,5,9,3,6,6,0,2,5,1,7,7,7,8,7,1,4,4,5,4,8,7,6,2,2,9,4,7,5,6,2,2,8,4,6,0,4,7,8,9,1,7,0};
		int[] nums2 = {6,9,8,1,1,5,7,3,1,3,3,4,9,2,8,0,6,9,3,3,7,8,3,4,2,4,7,4,5,7,7,2,5,6,3,6,7,0,3,5,3,2,8,1,6,6,1,0,8,4};
	//	int[] nums1 = {6,7,8,6,7};
	//	int[] nums2 = {6,0,4,5,4,6};
		long t1 = System.nanoTime();
		int[] res = new CreateMaximumNumber().maxNumber(nums1, nums2, 50);
		System.out.println(System.nanoTime() - t1);
		System.out.println(Arrays.toString(res));
	}

}
