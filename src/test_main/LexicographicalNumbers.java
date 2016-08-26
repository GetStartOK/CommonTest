package test_main;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
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
		System.out.println(new LexicographicalNumbers().lexicalOrder(2));
	}

}
