package hw3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		while(sc.hasNextInt()){
			int num = sc.nextInt();
			while(num > 0){
				list.add(num % 10);
				num /= 10;
			}
			for(int i = 0; i < list.size(); i ++){
				System.out.print(list.get(i));
			}
			System.out.println();
			list.clear();
		}
	}

}
