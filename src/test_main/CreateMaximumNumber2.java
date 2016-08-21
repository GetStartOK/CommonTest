package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateMaximumNumber2 {

	int[] l1 = null;
	int[] l2 = null;
	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
       l1 = nums1;
       l2 = nums2;
       int res[] = new int[k];
       int ls = 0, rs = 0,s = 0, n = k;
       for(; n > 0;){
    	   Result re = f2(ls, rs, n);
    	   for(int j = s; j < re.list.size() + s; j++){
    		   res[j] = re.list.get(j - s);
    	   }
    	   s += re.list.size();
    	   ls = re.ls;
    	   rs = re.rs;
    	   n = re.n; 
       }
       return res;
    }
	
//	private Result f(int ls, int rs, int n){
//		int max = -1;
//		int index = -1;
//		for(int i = ls; i < l1.length; i++){
//			int t = l1[i];
//			if((l1.length - i + l2.length - rs) < n)
//				break;
//			if(max < t){
//				max = t;
//				index = i;
//			}
//		}
//		int max2 = -1;
//		int index2 = -1;
//		for(int i = rs; i < l2.length; i++){
//			int t = l2[i];
//			if((l2.length - i + l1.length - ls) < n)
//				break;
//			if(max2 < t){
//				max2 = t;
//				index2 = i;
//			}
//		}
//		if(max < max2){
//			if(n - 1 > 0){
//				Result r = f(ls, index2 + 1, n - 1);
//				r.list.addFirst(max2);
//				return r;
//			}else{
//				Result r = new Result();
//				r.list.add(max2);
//				return r;
//			}
//		}else if(max > max2){
//			if(n - 1 > 0){
//				Result r = f(index + 1, rs, n - 1);
//				r.list.addFirst(max);
//				return r;
//			}else{
//				Result r = new Result();
//				r.list.add(max);
//				return r;
//			}
//		}else{
//			if(n - 1 > 0){
//				Result lr = f(index + 1, rs, n - 1);
//				Result rr = f(ls, index2 + 1, n - 1);
//				if(lr.bigger(rr) >= 0){
//					lr.list.addFirst(max);
//					return lr;
//				}else{
//					rr.list.addFirst(max2);
//					return rr;
//				}
//			}else{
//				Result r = new Result();
//				r.list.add(max);
//				return r;
//			}
//		}
//	}
	
	private Result f2(int ls, int rs, int n){
		int max = -1;
		int index = -1;
		for(int i = ls; i < l1.length; i++){
			int t = l1[i];
			if((l1.length - i + l2.length - rs) < n)
				break;
			if(max < t){
				max = t;
				index = i;
			}
		}
		int max2 = -1;
		int index2 = -1;
		for(int i = rs; i < l2.length; i++){
			int t = l2[i];
			if((l2.length - i + l1.length - ls) < n)
				break;
			if(max2 < t){
				max2 = t;
				index2 = i;
			}
		}
		if(max < max2){
			List<Integer> list = new ArrayList<Integer>();
			list.add(max2);
			Result r = new Result(list, ls, index2 + 1, n - 1);
			return r;
		}else if(max > max2){
			List<Integer> list = new ArrayList<Integer>();
			list.add(max);
			Result r = new Result(list, index + 1, rs, n - 1);
			return r;
		}else{
			while(n > 0){
				int l;
				int r;
			}
			
			
			if(n - 1 > 0){
				Result lr = f2(index + 1, rs, n - 1);
				Result rr = f2(ls, index2 + 1, n - 1);
				if(lr.bigger(rr) >= 0){
					lr.list.add(max);
					return lr;
				}else{
					rr.list.add(max2);
					return rr;
				}
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(max);
				Result r = new Result(list, index + 1, rs, n - 1);
				return r;
			}
		}
	}
	
	class Result{
		List<Integer> list;
		int ls;
		int rs;
		int n;
		
		public Result(List<Integer> list, int ls, int rs, int n){
			this.list = list;
			this.ls = ls;
			this.rs = rs;
			this.n = n;
		}
		
		int bigger(Result r){
			for(int i = this.list.size() - 1; i >= 0; i --){
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
	//	int[] nums1 = {8,9,7,3,5,9,1,0,8,5,3,0,9,2,7,4,8,9,8,1,0,2,0,2,7,2,3,5,4,7,4,1,4,0,1,4,2,1,3,1,5,3,9,3,9,0,1,7,0,6,1,8,5,6,6,5,0,4,7,2,9,2,2,7,6,2,9,2,3,5,7,4,7,0,1,8,3,6,6,3,0,8,5,3,0,3,7,3,0,9,8,5,1,9,5,0,7,9,6,8,5,1,9,6,5,8,2,3,7,1,0,1,4,3,4,4,2,4,0,8,4,6,5,5,7,6,9,0,8,4,6,1,6,7,2,0,1,1,8,2,6,4,0,5,5,2,6,1,6,4,7,1,7,2,2,9,8,9,1,0,5,5,9,7,7,8,8,3,3,8,9,3,7,5,3,6,1,0,1,0,9,3,7,8,4,0,3,5,8,1,0,5,7,2,8,4,9,5,6,8,1,1,8,7,3,2,3,4,8,7,9,9,7,8,5,2,2,7,1,9,1,5,5,1,3,5,9,0,5,2,9,4,2,8,7,3,9,4,7,4,8,7,5,0,9,9,7,9,3,8,0,9,5,3,0,0,3,0,4,9,0,9,1,6,0,2,0,5,2,2,6,0,0,9,6,3,4,1,2,0,8,3,6,6,9,0,2,1,6,9,2,4,9,0,8,3,9,0,5,4,5,4,6,1,2,5,2,2,1,7,3,8,1,1,6,8,8,1,8,5,6,1,3,0,1,3,5,6,5,0,6,4,2,8,6,0,3,7,9,5,5,9,8,0,4,8,6,0,8,6,6,1,6,2,7,1,0,2,2,4,0,0,0,4,6,5,5,4,0,1,5,8,3,2,0,9,7,6,2,6,9,9,9,7,1,4,6,2,8,2,5,3,4,5,2,4,4,4,7,2,2,5,3,2,8,2,2,4,9,8,0,9,8,7,6,2,6,7,5,4,7,5,1,0,5,7,8,7,7,8,9,7,0,3,7,7,4,7,2,0,4,1,1,9,1,7,5,0,5,6,6,1,0,6,9,4,2,8,0,5,1,9,8,4,0,3,1,2,4,2,1,8,9,5,9,6,5,3,1,8,9,0,9,8,3,0,9,4,1,1,6,0,5,9,0,8,3,7,8,5};
	//	int[] nums2 = {7,8,4,1,9,4,2,6,5,2,1,2,8,9,3,9,9,5,4,4,2,9,2,0,5,9,4,2,1,7,2,5,1,2,0,0,5,3,1,1,7,2,3,3,2,8,2,0,1,4,5,1,0,0,7,7,9,6,3,8,0,1,5,8,3,2,3,6,4,2,6,3,6,7,6,6,9,5,4,3,2,7,6,3,1,8,7,5,7,8,1,6,0,7,3,0,4,4,4,9,6,3,1,0,3,7,3,6,1,0,0,2,5,7,2,9,6,6,2,6,8,1,9,7,8,8,9,5,1,1,4,2,0,1,3,6,7,8,7,0,5,6,0,1,7,9,6,4,8,6,7,0,2,3,2,7,6,0,5,0,9,0,3,3,8,5,0,9,3,8,0,1,3,1,8,1,8,1,1,7,5,7,4,1,0,0,0,8,9,5,7,8,9,2,8,3,0,3,4,9,8,1,7,2,3,8,3,5,3,1,4,7,7,5,4,9,2,6,2,6,4,0,0,2,8,3,3,0,9,1,6,8,3,1,7,0,7,1,5,8,3,2,5,1,1,0,3,1,4,6,3,6,2,8,6,7,2,9,5,9,1,6,0,5,4,8,6,6,9,4,0,5,8,7,0,8,9,7,3,9,0,1,0,6,2,7,3,3,2,3,3,6,3,0,8,0,0,5,2,1,0,7,5,0,3,2,6,0,5,4,9,6,7,1,0,4,0,9,6,8,3,1,2,5,0,1,0,6,8,6,6,8,8,2,4,5,0,0,8,0,5,6,2,2,5,6,3,7,7,8,4,8,4,8,9,1,6,8,9,9,0,4,0,5,5,4,9,6,7,7,9,0,5,0,9,2,5,2,9,8,9,7,6,8,6,9,2,9,1,6,0,2,7,4,4,5,3,4,5,5,5,0,8,1,3,8,3,0,8,5,7,6,8,7,8,9,7,0,8,4,0,7,0,9,5,8,2,0,8,7,0,3,1,8,1,7,1,6,9,7,9,7,2,6,3,0,5,3,6,0,5,9,3,9,1,1,0,0,8,1,4,3,0,4,3,7,7,7,4,6,4,0,0,5,7,3,2,8,5,1,4,5,8,5,6,7,5,7,3,3,9,6,8,1,5,1,1,1,0,3};
		long t1 = System.nanoTime();
		int[] res = new CreateMaximumNumber2().maxNumber(nums1, nums2, 50);
		System.out.println(System.nanoTime() - t1);
		System.out.println(Arrays.toString(res));
	}

}
