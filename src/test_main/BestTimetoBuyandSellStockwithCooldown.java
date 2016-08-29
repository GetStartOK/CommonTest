package test_main;

import java.util.Arrays;

public class BestTimetoBuyandSellStockwithCooldown {
	
	public int maxProfit(int[] prices){
		 int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
		    for (int price : prices) {
		        prev_buy = buy;
		        buy = Math.max(prev_sell - price, prev_buy);
		        prev_sell = sell;
		        sell = Math.max(prev_buy + price, prev_sell);
		    }
		    return sell;
	}
	
	public int maxProfit_dp(int[] prices){
		int l = prices.length;
		int[] dp = new int[l];
		if(l == 0 || l == 1)
			return 0;
		if(l == 2){
			return Math.max(0, prices[1] - prices[0]);
		}
		dp[l - 1] = 0;
		dp[l - 2] = Math.max(0, prices[l - 1] - prices[l - 2]);
		for(int i = l - 3; i >= 0; i --)
			for(int j = i + 1; j < l; j ++){
				if(j < l - 2)
					dp[i] = Math.max(dp[i], Math.max(dp[i + 1], prices[j] - prices[i] + dp[j + 2]));
				else
					dp[i] = Math.max(dp[i], Math.max(dp[i + 1], prices[j] - prices[i]));
			}
		return dp[0];
	}
	
    public int maxProfit_recursive(int[] prices) {
    	int dp[] = new int[prices.length];
    	Arrays.fill(dp, Integer.MIN_VALUE);
        return getMax(prices, 0, dp);
    }
    
	private int getMax(int[] prices, int n, int[] dp) {
		if(n >= prices.length)
			return 0;
		if(dp[n] != Integer.MIN_VALUE)
			return dp[n];
		int res = getMax(prices, n + 1, dp);
		for(int i = n + 1; i < prices.length; i++){
			res = Math.max(res , Math.max(res, prices[i] - prices[n] + getMax(prices, i + 2, dp)));
		}
		dp[n] = res;
		return res;
	}

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(new BestTimetoBuyandSellStockwithCooldown().maxProfit(prices));
	}

}
