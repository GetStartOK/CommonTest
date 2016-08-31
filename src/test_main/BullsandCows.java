package test_main;

public class BullsandCows {

    public String getHint(String secret, String guess) {
        int[] bull = new int[10];
        int[] se = new int[10];
        int[] gu = new int[10];
        for(int i = 0, j = secret.length(); i < j; i++){
        	char c1 = secret.charAt(i);
        	char c2 = guess.charAt(i);
        	if(c1 == c2){
        		bull[c1 - 48] ++;
        	}
        	se[c1 - 48] ++;
        	gu[c2 - 48] ++;
        }
        int a = 0;
        int b = 0;
        for(int i = 0; i < 10; i++){
        	a += bull[i];
        	b += (Math.min(se[i], gu[i]) - bull[i]);
        }
        return a+"A"+b+"B";
    }
	
	public static void main(String[] args) {
		String secret = "1123";
		String guess = "0111";
		System.out.println(new BullsandCows().getHint(secret, guess));
	}

}
