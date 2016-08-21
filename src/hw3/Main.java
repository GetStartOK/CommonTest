package hw3;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String[] ss = new String[n];
		if(n > 0)
			ss[0] = sc.nextLine().toLowerCase();
		for(int i = 1; i < n; i++){
			ss[i] = sc.nextLine().toLowerCase();
		}
		for(int i = 0; i < n; i++){
			int[] t = new int[26];
			String s = ss[i];
			for(int j = 0, k = s.length(); j < k; j++){
				t[(int)s.charAt(j) - 97] ++;
			}
			
			int[] t2 = new int[26];
			for(int j = 0; j < 26; j++){
				if(t[j] != 0)
					t2[t[j]] ++;
			}
			int st = 26;
			int max = 0;
			for(int j = 25; j >= 0; j--){
				while(t2[j] >= 1){
					max += st * j;
					t2[j] --;
					st --;
				}
			}
			System.out.println(max);
		}
		
	}
	
}
