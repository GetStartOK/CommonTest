package test_main;

import java.util.Arrays;
import java.util.LinkedList;

public class CoinChange {

	int[] coins = null;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        long t1 = System.nanoTime();
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i : coins){
        	list.add(i);
        }
        fastRange(0, list.size(), list);
        for(int i = 0; i < list.size(); i++){
        	coins[i] = list.get(i);
        }
        long t2 = System.nanoTime();
        int res = can(coins.length - 1, amount, Integer.MAX_VALUE);
        long t3 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
        return res;
    }
    
    private void fastRange(int start, int end,LinkedList<Integer> list){
    	if(start > end - 1)
    		return;
    	int t = list.get(start);
    	int t2 = 0;
    	int n = start;
    	for(int i = start + 1; i < end; i++){
			t2 = list.get(i);
    		if(t > t2){
    			list.remove(i);
    			list.add(start, t2);
    			n++;
    		}
    	}
		fastRange(start, n, list);
		fastRange(n + 1, end, list);
    }
    
    private int can(int index, int extra, int min){
    	int res = Integer.MAX_VALUE;
    	int n = extra / coins[index];
    	if(n > min)
    		return -1;
    	extra = extra % coins[index];
    	if(extra == 0){
    		return n;
    	}else{
    		if(index == 0)
    			return -1;
			int nt = n;
			while(nt >= 0){
				int nIndex = index - 1;
				while(nIndex >= 0 && coins[nIndex] > extra){
					nIndex --;
	    		}
				if(nIndex < 0){
					extra += coins[index];
					nt --;
					continue;
				}
				int m = can(nIndex, extra, res - nt);
				if(m != -1){
					res = res <= (m+nt) ? res : (m+nt);
//					if(index == coins.length - 1){
//						mRes = mRes <= res ? mRes : res;
//					}
				}
				nt --;
				extra += coins[index];
			}
    	}
    	if(res == Integer.MAX_VALUE)
    		return -1;
    	return res;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
    public int coinChange2(int[] coins, int amount) {
        long t1 = System.nanoTime();
//        LinkedList<Integer> list = new LinkedList<Integer>();
//        for(int i : coins){
//        	list.add(i);
//        }
//        fastRange(0, list.size(), list);
//        for(int i = 0; i < list.size(); i++){
//        	coins[i] = list.get(i);
//        }
        Arrays.sort(coins);
        long t2 = System.nanoTime();
    	int[] dp = new int[amount+1];
    	for(int i = 1; i <= amount; i ++){
    		int min = Integer.MAX_VALUE;
    		for(int j = 0; j < coins.length; j++){
    			if(i >= coins[j] && dp[i - coins[j]] != -1)
    				min = Math.min(min, dp[i - coins[j]] + 1);
    		}
    		dp[i] = min == Integer.MAX_VALUE ? -1 : min;
    	}
    	
        long t3 = System.nanoTime();
        System.out.println(t2 - t1);
        System.out.println(t3 - t2);
    	return dp[amount];
    }
    
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
	public static void main(String[] args) {
	//	int[] coins = {1,10,18,23};
		int[] coins = {243,291,335,209,177,345,114,91,313,331};
	//	System.out.println(new CoinChange().coinChange(coins, 7367));
		System.out.println(new CoinChange().coinChange2(coins, 7367));
	}

}
