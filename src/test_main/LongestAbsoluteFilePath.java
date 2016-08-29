package test_main;

import java.util.ArrayList;
import java.util.List;

public class LongestAbsoluteFilePath {

    public int lengthLongestPath(String input) {
    	int max = 0;
        List<String> list = new ArrayList<String>();
        int layer = 0;
        StringBuilder sb = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
        boolean isSpecial = false;
        for(int i = 0, j = input.length(); i < j; i++){
        	char ch = input.charAt(i);
        	switch(ch){
        	case '\t' : isSpecial = true;
    					layer ++;
        				break;
        	case '\n' : String s = sb.toString();
        				sb.setLength(0);
        				list.add(s);
			    		layer = 0;
			    		break;
        	case ' ' : if(!isSpecial)
        					sb.append(ch);
        					break;
        	default : if(isSpecial){
        					if(layer <= list.size() - 1){
        						for(int k = 0; k < list.size(); k++){
        							sb2.append(list.get(k));
        							sb2.append("/");
        						}
        						if(list.get(list.size() - 1).indexOf('.') != -1)
        							max = Math.max(max, sb2.length() - 1);
        						sb2.setLength(0);
        						for(int k = list.size() - 1; k >= layer; k --){
    			        			list.remove(k);
    			        		}
        					}
			        		isSpecial = false;
			        	}
        				sb.append(ch);
        	}
        }
        String str = sb.toString();
        if(str.indexOf('.') != -1){
        	 list.add(str);
             for(int k = 0; k < list.size(); k++){
     			sb2.append(list.get(k));
     			sb2.append("/");
     		}
     		max = Math.max(max, sb2.length() - 1);
     		sb2.setLength(0);
     		for(int k = list.size() - 1; k >= layer; k --){
     			list.remove(k);
     		}
        }
        return max;
    }	
	
	public static void main(String[] args) {
		String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		System.out.println(new LongestAbsoluteFilePath().lengthLongestPath(input));
	}

}
