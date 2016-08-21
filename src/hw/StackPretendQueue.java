package hw;

import java.util.Stack;

public class StackPretendQueue {

	private int size = 0;
	private Stack<Integer> s1 = new Stack<Integer>();
	private Stack<Integer> s2 = new Stack<Integer>();
	
	public static void main(String[] args){
		
		StackPretendQueue sq = new StackPretendQueue();
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		
		sq.push(4);
		sq.push(5);
		sq.push(6);
		sq.push(7);

		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
	}
	
	public void push(int n){
		s1.push(n);
		size ++;
	}
	
	public int pop(){
		if(!s2.isEmpty()){
			size --;
			return s2.pop();
		}
		while(s1.size() > 1){
			s2.push(s1.pop());
		}
		if(s1.size() == 1){
			size --;
			return s1.pop();
		}
		return -1;
	}
	
	public int getSize(){
		return size;
	}
}
