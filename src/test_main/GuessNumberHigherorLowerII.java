package test_main;

public class GuessNumberHigherorLowerII {

	public int getMoneyAmount(int n) {
		int[][] dp = new int[n+1][n+1];
		int res = getMoney(1, n, dp);
		return res;
    }
	
	private int getMoney(int l, int r, int[][] dp) {
		if(l >= r)
			return 0;
		
		if(dp[l][r] != 0)
			return dp[l][r];
		
		int min = Integer.MAX_VALUE;
		for(int i = l; i < r; i++){
			min = Math.min(min, i + Math.max(getMoney(l, i - 1, dp), getMoney(i + 1, r, dp)));
		}
		
		dp[l][r] = min;
		return min;
	}

	public static void main(String[] args) {
		System.out.println(new GuessNumberHigherorLowerII().getMoneyAmount(10));
	}

}
