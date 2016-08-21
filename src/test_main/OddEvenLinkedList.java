package test_main;

public class OddEvenLinkedList {

	public ListNode oddEvenList(ListNode head) {
		if(head == null)
			return head;
		ListNode current = head.next;
		ListNode pre = head;
		int i = 1;
		ListNode lastOdd = head;
		while(current != null){
			if(i % 2 == 0){
				pre.next = current.next;
				current.next = lastOdd.next;
				lastOdd.next = current;
				lastOdd = current;
				current = pre.next;
			}else{
				pre = current;
				current = current.next;
			}
			i++;
		}
		return head;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		ListNode head = null;
		ListNode p = null;
		for(int i : nums){
			if(head == null){
				head = new ListNode(i);
				p = head;
			}else{
				p.next = new ListNode(i);
				p = p.next;
			}
		}
		System.out.println(new OddEvenLinkedList().oddEvenList(head));
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    
    @Override
	public String toString(){
    	String s = this.next == null ? null : this.next.toString();
    	return String.valueOf(val)+"->"+s;
    }
}
 
