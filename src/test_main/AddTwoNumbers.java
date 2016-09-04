package test_main;

public class AddTwoNumbers {
	
    public ListNode2 addTwoNumbers(ListNode2 l1, ListNode2 l2) {
        boolean addOne = false;
        ListNode2 root = new ListNode2(0);
        ListNode2 cur = root;
        ListNode2 p = null;
        while(l1 != null && l2 != null){
        	int v = l1.val + l2.val;
        	if(addOne)
        		v ++;
        	addOne = v / 10 == 1 ? true : false;
        	v %= 10;
        	p = new ListNode2(v);
        	cur.next = p;
        	cur = cur.next;
        	l1 = l1.next;
        	l2 = l2.next;
        }
        while(l1 != null){
        	int v = l1.val;
        	if(addOne){
        		v ++;
        		addOne = false;
        	}
        	addOne = v / 10 == 1 ? true : false;
        	v %= 10;
        	p = new ListNode2(v);
        	cur.next = p;
        	cur = cur.next;
        	l1 = l1.next;
        }
        while(l2 != null){
        	int v = l2.val;
        	if(addOne){
        		v ++;
        		addOne = false;
        	}
        	addOne = v / 10 == 1 ? true : false;
        	v %= 10;
        	p = new ListNode2(v);
        	cur.next = p;
        	cur = cur.next;
        	l2 = l2.next;
        }
        if(addOne){
        	p = new ListNode2(1);
        	cur.next = p;
        }
        return root.next;
    }
	
	public static void main(String[] args) {
		ListNode2 l1 = new ListNode2(2);
		l1.next = new ListNode2(4);
		l1.next.next = new ListNode2(3);
		ListNode2 l2 = new ListNode2(5);
		l2.next = new ListNode2(6);
		l2.next.next = new ListNode2(4);
		l2.next.next.next = new ListNode2(6);
		new AddTwoNumbers().addTwoNumbers(l1, l2);
	}

}

class ListNode2{
	int val;
	ListNode2 next;
	ListNode2 (int x){
		val = x;
	}
}