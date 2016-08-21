package hw;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int[] num = new int[x];
		for(int i = 0; i < x; i++){
			num[i] = sc.nextInt();
		}
		int max = 0;
		int[] left = new int[x];
		int[] right = new int[x];
		for(int i = 0, j = num.length; i < j; i++){
			getLeft(left, num, i);
		}
		for(int i = num.length - 1; i >= 0; i--){
			getRight(right, num, i);
		}
		for(int i = 0; i < x; i ++){
			max = max >= left[i] + right[i] ? max : left[i] + right[i];
		}
		System.out.println(x - max + 1);
	}

	private static void getLeft(int[] left, int[] num, int index) {
		int max = 0;
		int curr = num[index];
		for(int i = 0; i < index; i++){
			if(num[i] < curr){
				max = max >= left[i] ? max : left[i];
			}
		}
		left[index] = max + 1;
	}
	
	private static void getRight(int[] right, int[] num, int index) {
		int max = 0;
		int curr = num[index];
		for(int i = num.length - 1; i > index; i--){
			if(num[i] < curr){
				max = max >= right[i] ? max : right[i];
			}
		}
		right[index] = max + 1;
	}
}
/**
 * 运行时间：27ms


占用内存：377k
 */