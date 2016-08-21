package hw2;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		char[] chs = line.toCharArray();
		quicSort(chs, 0, chs.length - 1);
		for(char ch : chs){
			System.out.print(ch);
		}
		System.out.println();
	}
	
	private static void quicSort(char[] chs, int l, int r){
		if(l < r){
			int m = l;
			int n = r;
			char cur = chs[m];
			while(m < n){
				while(m < n && chs[n] >= cur)
					n --;
				if(m < n)
					chs[m] = chs[n];
				
				while(m < n && chs[m] <= cur)
					m ++;
				if(m < n)
					chs[n] = chs[m];
			}
			chs[m] = cur;
			quicSort(chs, l, m - 1);
			quicSort(chs, m + 1, r);
		}
	}
}
