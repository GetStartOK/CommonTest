package test_main;

public class GuessNumberHigherorLower {

	private int m = 1702766719;
	
    public int guessNumber(int n) {
    	int res = -1;
    	int l = 1, r = n;
    	int guess = 0;
        while(l <= r && res != 0){
        	guess = l + (r - l)/2;
        	res = guess(guess);
        	if(res > 0){
        		l = guess + 1;
        	}else if(res < 0)
        		r = guess - 1;
        }
        return guess;
    }
	
	private int guess(int guess) {
		return m - guess;
	}

	public static void main(String[] args) {
		System.out.println(new GuessNumberHigherorLower().guessNumber(2126753390));
	}

}
