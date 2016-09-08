import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int[] num = null;
		int t = sc.nextInt();
		num = new int[t];
		int j = 0, max = 0;
		while(t -- > 0){
			num[j] = sc.nextInt();
			max = Math.max(max, num[j]);
			j ++;
		}
		int[] nums = Arrays.copyOf(num, num.length);
		Arrays.sort(num);
		int[] res = new int[max + 1];
		for(int k = 0; k < num.length; k ++){
			int s = 0;
			for(int i = num[k]; i >= 1; i --){
				if(res[i] != 0){
					s += res[i];
					break;
				}
				if(getRS(i, 2) == getRS(i, 10))
					s ++;
			}
			res[num[k]] = s;
		}
		for(int i = 0; i < nums.length; i ++){
			System.out.println(res[nums[i]]);
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
