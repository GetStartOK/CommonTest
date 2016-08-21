package hw;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Main2 {
	
	public static int getResult(List<String> ss){
		Set<String> set = new HashSet<String>(ss.size() * 50);
		for(String s : ss){
			String[] ss2 = s.split(" ");
			for(String s2 : ss2)
				set.add(s2);
		}
		return set.size();
	}
	
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		List<String> list = new ArrayList<String>();
//		while(sc.hasNextLine()){
//			list.add(sc.nextLine());
//		}
//		System.out.println(getResult(list));
		findNumInMatirx();
		//System.out.println(getFibonacci(7));
	}
	
	public static long getFibonacci(int n){
		int cur1 = 0;
		int cur2 = 1;
		int i = 1;
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		while(i++ < n){
			int t = cur1 + cur2;
			cur1 = cur2;
			cur2 = t;
		}
		return cur2;
	}
	public static void findNumInMatirx(){
//		int[][] matrix = {{1,2,8,9}, {2,4,9,12}, {4,7,10,13}, {6,8,11,15}};
		int[][] matrix = {{}};
		int n = 16;
		int r = matrix.length - 1, c = 0;
//		Label:
		while(r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] != n){
			int tmp = matrix[r][c];
			if(tmp > n){
				r --;
				continue;//Ìø³öÀï²ãÑ­»·
			}
			if(tmp == n){
				break;
			}
			c ++;
		}
		if(r == -1 || c == matrix[0].length)
			System.out.println(false);
		else
			System.out.println(r+", "+c);
	}
}
