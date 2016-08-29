package test_main;

public class FindtheDifference {
    public char findTheDifference(String s, String t) {
        int[] ns1 = new int[26];
        int[] ns2 = new int[26];
        for(int i = 0, j = s.length(); i < j; i++){
        	ns1[s.charAt(i) - 97] ++;
        	ns2[t.charAt(i) - 97] ++;
        }
        ns2[t.charAt(t.length() - 1) - 97] ++;
        
        for(int i = 0; i < 26; i++){
        	if(ns1[i] != ns2[i])
        		return (char)(i + 97);
        }
        return ' ';
    }
    
	public static void main(String[] args) {
		String s = "abcde";
		String t = "abccde";
		System.out.println(new FindtheDifference().findTheDifference(s, t));
	}
}
