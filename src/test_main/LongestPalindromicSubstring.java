package test_main;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	int len = s.length();
        char[] chs = new char[2 * len + 1];
        for(int i = 0, j = chs.length; i < j; i++){
        	if(i % 2 == 0)
        		chs[i] = '#';
        	else
        		chs[i] = s.charAt((i - 1) / 2);
        }
        int ml = 0, mr = 0;
        int l = 0;
        int r = 0;
        for(int i = 0, j = chs.length; i < j; i ++){
        	l = i - 1;
        	r = i + 1;
        	while(l >= 0 && r < j){
        		char c1 = chs[l];
        		char c2 = chs[r];
        		if(c1 != c2){
        			break;
        		}
        		l --;
        		r ++;
        	}
        	if(mr - ml < r - l - 2){
            	ml = l + 1;
            	mr = r - 1;
        	}
        }
        StringBuilder sb = new StringBuilder();
        for(int i = ml, j = mr; i <= j; i ++){
        	if(i % 2 == 1)
        		sb.append(chs[i]);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("abc  cbadd"));
	}

}
