package test_main;

public class ReverseVowelsofaString {
	
    public String reverseVowels(String s) {
        int before = 0, after = s.length() - 1;
        boolean b = true;
        char[] chs = s.toCharArray();
        while(before < after){
        	if(b){
	        	if(chs[before] == 'a' ||chs[before] == 'e' ||chs[before] == 'i' ||chs[before] == 'o' ||chs[before] == 'u' || chs[before] == 'A' ||chs[before] == 'E' ||chs[before] == 'I' ||chs[before] == 'O' ||chs[before] == 'U'){
	        		b = false;
	        	}else{
	        		before ++;
	        	}
        		continue;
        	}else{
        		if(chs[after] == 'a' ||chs[after] == 'e' ||chs[after] == 'i' ||chs[after] == 'o' ||chs[after] == 'u' || chs[after] == 'A' ||chs[after] == 'E' ||chs[after] == 'I' ||chs[after] == 'O' ||chs[after] == 'U'){
	        		b = true;
	        		char t = chs[before];
	        		chs[before] = chs[after];
	        		chs[after] = t;
	        		before ++;
	        	}
        		after --;
        		continue;
        	}
        }
        return new String(chs);
    }
    
    public static void main(String[] args) {
		System.out.println(new ReverseVowelsofaString().reverseVowels("hello"));
	}
}
