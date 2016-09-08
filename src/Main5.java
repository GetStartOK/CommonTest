import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			if(n == 1 || n == 2){
				System.out.println(n + "/" + 1);
				continue;
			}
			int t = 0;
			for(int i = 2; i < n; i ++)
				t += getRS(n, i);
			int m = n - 2;
			for(int i = 2; i <= m;){
				if(m % i == 0 && t % i == 0){
					m /= i;
					t /= i;
				}else
					i ++;
			}
			System.out.println(t + "/" + m);
		}
	}

	private static int getRS(int n, int i) {
		int s = 0;
		while(n / i > 0){
			s += n % i;
			n /= i;
		}
		s += n;
		return s;
	}

}
