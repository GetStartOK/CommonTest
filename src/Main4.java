import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] dp = new int[n][m + 1];
		System.out.println(getAll(0, m, n, dp));
	}

	private static int getAll(int i, int m, int n, int[][] dp) {
		if(m < 0)
			return 0;
		if(dp[i][m] != 0)
			return dp[i][m];
		if(i > n / 2 && n - i == m){
			dp[i][m] = 1;
			return dp[i][m];
		}
		if(i <= n / 2 && i == m){
			dp[i][m] = 1;
			return dp[i][m];
		}
		int l = 0, r = 0;
		if(i == 0){
			l = 1;
			r = n - 1;
		}else if(i == n - 1){
			l = 0;
			r = n - 2;
		}else{
			l = i + 1;
			r = i - 1;
		}
		return getAll(l, m - 1, n, dp) + getAll(r, m - 1, n, dp);
	}

}
