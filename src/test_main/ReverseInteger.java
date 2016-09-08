package test_main;

public class ReverseInteger {

	 public int reverse(int x) {
        boolean positive = true;
        if(x < 0){
            positive = false;
            x = -x;
        }
        int res = 0;
        while(x > 0){
            res *= 10;
            res += x % 10;
            x /= 10;
            if(res > Integer.MAX_VALUE / 10 && x > 0)
            	return 0;
        }
        if(!positive)
            res = - res;
        return res;
    }
	
	public static void main(String[] args) {
		String s = "01";
		System.out.println(s.matches("[0-9]+"));
		System.out.println(new ReverseInteger().reverse(1534236469));
	}

}
