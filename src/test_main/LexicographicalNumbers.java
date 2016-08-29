package test_main;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
//    public List<Integer> lexicalOrder(int n) {
//        List<Integer> res = new ArrayList<Integer>(n);
//    	if(n == 0){
//    		res.add(0);
//    		return res;
//    	}
//    	int m = n;
//    	while(m > 10){
//    		m /= 10;
//    	}
//    	int i = 1;
//    	int cur = 1;
//    	while(i < 10){
//    		if(cur < n){
//    			res.add(cur);
//    			cur *= 10;
//    		}else{
//    			cur /= 10;
//    		}
//    	}
//    }
	public List<Integer> lexicalOrder(int n) {
		List<Integer> res = new ArrayList<Integer>();
		int f = 1;
		int cur = 1;
		while (f < 10) {
			if (cur <= n) {
				res.add(cur);
				cur *= 10;
			} else {
				if(cur > 10)
					cur /= 10;
				int t = cur % 10;
				int y = cur /10;
				while(y > 0 && t == 9){
					cur = y;
					t = cur % 10;
					y = cur / 10;
				}
				if(cur < 10){
					f ++;
				}
				cur ++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		//System.out.println(new LexicographicalNumbers().lexicalOrder(14959));
		for(int i = 0; i < 100; i++){
			System.out.println(i+"--"+transfer(i, 3));
		}
		System.out.println(new LexicographicalNumbers().lexicalOrder(200));
	}

	 public static int transfer(int n,int k){  
	        int ans=0;  
	        int b=1;  
	        for (int i = 0; i < k; i++) {  
	            if (n!=0) {  
	                ans+=(b*(n%10+1));  
	                b*=11;  
	                n/=10;  
	            }else{  
	                ans*=11;  
	            }  
	        }  
	        return ans;  
	    }  
}
