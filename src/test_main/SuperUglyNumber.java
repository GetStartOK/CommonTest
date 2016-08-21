package test_main;

public class SuperUglyNumber {

	int[] primes, tmp;
	int max = 0,index;
	public int nthSuperUglyNumber(int n, int[] primes) {
		 int[] superUglyNumbers = new int[n];
	        superUglyNumbers[0] = 1;
	        int[] idxPrimes = new int[primes.length];
	        for (int i = 0; i < idxPrimes.length; i++) {
	            idxPrimes[i] = 0;
	        }
	        
	        int counter = 1;
	        while (counter < n) {
	            
	            int min = Integer.MAX_VALUE;
	            for (int i = 0; i < primes.length; i++) {
	                int temp = superUglyNumbers[idxPrimes[i]] * primes[i];
	                min = min < temp ? min : temp;
	            }

	            for (int i = 0; i < primes.length; i++) {
	                if (min == superUglyNumbers[idxPrimes[i]] * primes[i]) {
	                    idxPrimes[i]++;
	                }
	            }
	            
	            superUglyNumbers[counter] = min;
	            counter++;
	        }
	        
	        return superUglyNumbers[n - 1];
    }
	
	private boolean isUglyNum(int num){
		if(num == 1)
			return true;
//		if(num <= max && inList(num))
//			return true;
	  	for(int j = 0, m = primes.length; j < m; j ++){
    		int t = primes[j];
    		if(num < t)
    			return false;
    		if(num % t != 0)
    			continue;
//    		if(isUglyNum(num / t))
//    			return true;
    		if(inList(num / t, 0, index))
    			return true;
    	}
	  	return false;
	}
	
	private boolean inList(int num, int start, int end) {
//		for(int i : primes){
//			if(i == num)
//				return true;
//			if(i > num)
//				return false;
//		}
//		
	//	for(int i = start; i < end; i ++){
			int i = (start + end) / 2;
			if(start >= end)
				return false;
			int t = tmp[i];
			if(t == num)
				return true;
			if(t > num)
				return inList(num, start, i);
			return inList(num, i + 1, end);
	//	}
	}

	public static void main(String[] args) {
		int[] nums = {7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,27,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,25133,239,241,251};
		int n = 1000000;
		long t1 = System.currentTimeMillis();
		int res = new SuperUglyNumber().nthSuperUglyNumber(n, nums);
		System.out.println(System.currentTimeMillis() - t1 + "\r\n" + res);
	}

}
