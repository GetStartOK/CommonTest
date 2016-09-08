package test_main;

public class StringtoInteger {
    public int myAtoi(String str) {
    	str = str.trim();
        if(!str.matches("[+,-]?[0-9]+"))
        	return 0;
        boolean positive = true;
        int i = 0;
        if(str.charAt(0) == '-'){
        	positive = false;
        	i = 1;
        }else if(str.charAt(0) == '+'){
        	i = 1;
        }
        int res = 0;
        for(int j = str.length(); i < j; i ++){
        	char ch = str.charAt(i);
        	if(res > (Integer.MAX_VALUE - ch + 48) / 10){
        		res = Integer.MAX_VALUE;
        		break;
        	}
        	res *= 10;
        	res += (ch - 48);
        }
        if(!positive){
        	if(res == Integer.MAX_VALUE)
        		res = Integer.MIN_VALUE;
        	else
        		res = -res;
        }
        return res;
    }
    
	public static void main(String[] args) {
		System.out.println(new StringtoInteger().myAtoi("    010"));
	}

}
