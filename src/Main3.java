import java.util.Scanner;

public class Main3 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			if(n == 1){
				System.out.println(n);
				continue;
			}
			n --;
			int zc = 1;
			int now = 1;
			boolean cr = true;
			while(n > 0){
				if(cr){
					if(n >= zc){
						now += zc;
						n -= zc;
						zc ++;
						cr = false;
					}else{
						now += n;
						n = 0;
					}
				}else{
					now --;
					n --;
					cr = true;
				}
			}
			System.out.println(now);
		}
	}
}
