package test_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RemoveDuplicateLetters {
	
	Map<Character, List<Integer>> indexMap = null;
	public String removeDuplicateLetters(String s) {
		indexMap = new HashMap<Character, List<Integer>>();
		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(indexMap.containsKey(ch)){
				indexMap.get(ch).add(i);
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				indexMap.put(ch, list);
			}
		}
		int[] loc = new int[26];
		char[] strChar = s.toCharArray();
		List<Integer> tmpL = null;
		Set<Integer> reLoc = new HashSet<Integer>();
		for(char c = 'z'; c >= 'a'; c --){
			tmpL = indexMap.get(c);
			if(tmpL != null){
			}
		}
    }
}
