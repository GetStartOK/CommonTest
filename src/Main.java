import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int m = sc.nextInt();
			int n = sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for(int i = m; i <= n; i++){
				int b = i / 100;
				int s = i % 100 / 10;
				int g = i % 10;
				if(b * b * b + s * s * s + g * g * g == i)
					list.add(i);
			}
			if(list.size() == 0)
				System.out.println("no");
			else{
				for(int i : list)
					System.out.print(i + " ");
				System.out.printf("\n");
			}
		}
		sc.close();
	}
	
	public static void main2(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			int n = sc.nextInt();
			int m = sc.nextInt();
			double sum = 0.00d;
			double current = n;
			while(m -- > 0){
				sum += current;
				current = Math.sqrt(current);
			}
			System.out.printf("%.2f\n", sum);
		}
		sc.close();
	}
}
