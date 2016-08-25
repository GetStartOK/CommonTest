package test_main;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<Integer>(n);
    	if(n == 0){
    		res.add(0);
    		return res;
    	}
    	List<String> ss = new ArrayList<String>(n);
        for(int i = 1; i < n + 1; i++){
        	ss.add(String.valueOf(i));
        }
        quickSort(ss, 0, n - 1);
        for(int i = 0, j = ss.size(); i < j; i++){
        	res.add(Integer.parseInt(ss.get(i)));
        }
        return res;
    }
    
    private void quickSort(List<String> ss, int l, int r) {
    	if(l >= r)
    		return;
    	int start = l;
    	int end = r;
    	//String t = ss.get(l);
    	String tmp = ss.get(l + (r - l) / 2);
    	//ss.set(l, tmp);
    	//ss.set(l + (r - l) / 2, t);
        while(l < r){
        	for(; r > l; r--){
        		if(aBigB(tmp, ss.get(r))){
        			ss.set(l, ss.get(r));
        			break;
        		}
        	}
        	for(; l < r; l++){
        		if(aBigB(ss.get(l), tmp)){
        			ss.set(r, ss.get(l));
        			break;
        		}
        	}
        }
        ss.set(l, tmp);
        quickSort(ss, start, l - 1);
        quickSort(ss, r + 1, end);
	}

	private boolean aBigB(String a, String b){
    	int i = 0;
    	for(; i < a.length() && i < b.length(); i++){
    		if(a.charAt(i) > b.charAt(i))
    			return true;
    		else if(a.charAt(i) < b.charAt(i))
    			return false;
    	}
    	return i < a.length();
    }
    
	public static void main(String[] args) {
		System.out.println(new LexicographicalNumbers().lexicalOrder(14959));
	}

}
