import java.util.List;
import java.util.Random;
import java.util.Stack;

public class MiniParser {

    public NestedInteger deserialize(String s) {
    	 if("".equals(s))
             return new NestedInteger();
        if(!s.startsWith("["))
        	return new NestedInteger(Integer.parseInt(s));
        NestedInteger ni = new NestedInteger();
        Stack<Character> st = new Stack<Character>();
        st.push('[');
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while(i < s.length()){
        	char ch = s.charAt(i);
        	if(ch == '['){
        		st.push(ch);
        		sb.append(ch);
        	}else if(ch == ']'){
        		st.pop();
        		if(st.size() == 1){
            		sb.append(ch);
        			ni.add(deserialize(sb.toString()));
        			sb.setLength(0);
        		}else if(st.size() == 0){
        			if(sb.length() > 0)
        				ni.add(new NestedInteger(Integer.parseInt(sb.toString())));
        		}else{
            		sb.append(ch);
        		}
        	}else if(ch == ','){
        		if(st.size() == 1){
        			if(sb.length() > 0){
	        			ni.add(deserialize(sb.toString()));
	        			sb.setLength(0);
        			}
        		}else{
        			sb.append(ch);
        		}
        	}else{
        		sb.append(ch);
        	}
        	i ++;
        }
        return ni;
    }
	
	public static void main(String[] args) {
		System.out.println(new Random().nextInt(100));
		System.out.println(new MiniParser().deserialize("[1,[1,[1,[1]]]]"));
	}

}
class NestedInteger {
	      // Constructor initializes an empty nested list.
	     public NestedInteger() {
		}
	 	private List<NestedInteger> list;
	      // Constructor initializes a single integer.
	     public NestedInteger(int value) {
		}
	 
	     // @return true if this NestedInteger holds a single integer, rather than a nested list.
	    public boolean isInteger() {
			return false;
		}
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger() {
			return null;
		}
	 
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value) {
		}
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	     public void add(NestedInteger ni) {
		}
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList() {
			return null;
		}
	 }