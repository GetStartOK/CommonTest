package test_main;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProductofWordLength {

	public int maxProduct(String[] words) {
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});
		
		int[] nums = new int[words.length];
		for(int i = 0; i < words.length; i++){
			nums[i] = 0;
			for(char ch : words[i].toCharArray()){
				int t = 1;
				t <<= ch - 'a';
				nums[i] |= t;
			}
		}
		int res = 0;
		for(int i = 0; i < nums.length; i++){
			if(words[i].length() * words[i].length() <= res)
				break;
			for(int j = i+1; j < nums.length; j++){
				if(words[i].length() * words[j].length() <= res)
					break;
				if((nums[j] & nums[i]) == 0)
					res = words[i].length() * words[j].length();
			}
		}
		return res;
    }
	
	public static void main(String[] args) {
//		String[] words = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
//		long t1 = System.nanoTime();
//		int res = new MaximumProductofWordLength().maxProduct(words);
//		System.out.println(System.nanoTime() - t1);
//		System.out.println(res);
//		final ThreadLocal<String> tl = new ThreadLocal<String>();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				ThreadLocal<String> t1 = new ThreadLocal<String>();
//				t1.set("bbb");
//				ThreadLocal<String> t2 = new ThreadLocal<String>();
//				t2.set("ccc");
//				System.out.println(tl.get());
//			}
//		}).start();
		System.out.println('z' - 'a');
	}

}
