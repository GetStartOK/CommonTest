package test_main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

	public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        Node head, tail;
        Node n = new Node(nums[0]);
		map.put(nums[0], n);
		head = tail = n;
        for(int i = 1; i < nums.length; i++){
        	if(map.containsKey(nums[i])){
        		Node node = map.get(nums[i]);
        		node.num ++;
        		if(node == head)
        			continue;
        		while(node.pre != null && (node.num > node.pre.num)){
        			if(node.pre == head){
        				if(node == tail){
        					head.next = node.next;
                			node.pre = null;
                			node.next = head;
                			head.pre = node;
                			tail = head;
                			head = node;
        				}else{
        					head.next = node.next;
                			node.next.pre = head;
                			node.pre = null;
                			node.next = head;
                			head.pre = node;
                			head = node;
        				}
            		}else{
            			if(node == tail){
            				Node t = node.pre;
                			t.next = node.next;
                			t.pre.next = node;
                			node.pre = t.pre;
                			node.next = t;
                			t.pre = node;
                			tail = t;
            			}else{
            				Node t = node.pre;
                			t.next = node.next;
                			node.next.pre = t;
                			t.pre.next = node;
                			node.pre = t.pre;
                			node.next = t;
                			t.pre = node;
            			}
            		}
        		}
        		
        	}else{
        		Node node = new Node(nums[i]);
        		map.put(nums[i], node);
        		tail.next = node;
        		node.pre = tail;
        		tail = node;
        	}
        }
        int t = 0;
        List<Integer> res = new ArrayList<Integer>();
        Node tmp = head;
        while(t < k){
        	res.add(tmp.value);
        	tmp = tmp.next;
        	t++;
        }
        return res;
    }
	
	class Node{
		int value;
		int num;
		Node pre, next;
		public Node(int value){
			this.value = value;
			num = 1;
		}
	}
	
	public static void main(String[] args) {
//		int[] nums = {4,1,-1,2,-1,2,3};
//		int k = 2;
//		System.out.println(new TopKFrequentElements().topKFrequent(nums, k));
		int a = (int) (Math.log(64) / Math.log(4));
		System.out.println(Math.log(-1));
	}

}
