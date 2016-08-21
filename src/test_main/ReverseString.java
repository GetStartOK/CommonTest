package test_main;

public class ReverseString {
	
	public String reverseString(String s) {
		char[] chs = new char[s.length()];
		int i = s.length() - 1;
		for(char c : s.toCharArray()){
			chs[i--] = c;
		}
		return new String(chs);
    }	
	
	public static void main(String[] args) {
		System.out.println(new ReverseString().reverseString("hello"));
	}
}
