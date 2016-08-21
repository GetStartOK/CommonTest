package test_main;

public class CountingBits {

	public static int[] countBits(int num){
		int[] temp = new int[num+1];
		int[] is = new int[num+1];
		is[0] = 0;
		if(num >= 1){
			is[1] = 1;
			temp[0] = 0;
			temp[1] = 1;
			for(int i = 2; i <= num; i++){
				if(i == 2*temp[i - 1]){
					is[i] = 1;
					temp[i] = i;
				}else{
					temp[i] = temp[i-1];
					is[i] = m(i, temp);
				}
			}
		}
		return is;
	}
	
	
	private static int m(int num, int[] temp){
		int n = 0;
		if(num == temp[num])
			return 1;
		n = 1;
		n += m(num - temp[num], temp);
		return n;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int[] n = countBits(10000000);
		System.out.println(System.currentTimeMillis() - start);
		//System.out.println(Arrays.toString(n));
	}
}
