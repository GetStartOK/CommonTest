package test_main;

public class SolutionHouseRobberIII {
	
//    public int rob(TreeNode root) {
//    	TreeNode p = root;
//    	int cash = 0;
//    	List<TreeNode> list = new LinkedList<TreeNode>();
//    	if(root != null){
//    		list.add(root);
//    		int index = 0;
//    		while(index < list.size() && !isFinish(list)){
//    			p = list.get(index);
//    			if(p == null){
//    				TreeNode t = new TreeNode(0);
//    				list.remove(index);
//    				list.add(index, t);
//    				p = t;
//    			}
//    			list.add(p.left);
//    			list.add(p.right);
//    			index++;
//        		System.out.println(list);
//    		}
//    		cash = getCash(list);
//    	}
//		return cash;
//    }
//    
//    private int getCash(List<TreeNode> list) {
//    	int cash1 = 0;
//    	int cash0 = 0;
//    	
//    	for(int i = 0; i < list.size(); i++){
//    		int n = getN(i);
//    		if(n%2 == 0)
//    			cash0 += list.get(i).val;
//    		else
//    			cash1 += list.get(i).val;
//    	}
//    	
//    	return cash1 >= cash0 ? cash1 : cash0;
//	}
//
//	private int getN(int n) {
//		int i = 0;
//		for(; i <= n/2; i++){
//			if((Math.pow(2, i+1) - 2) >= n)
//				break;
//		}
//		return i;
//	}
//
//	private boolean isFinish(List<TreeNode> list){
//		if(list.size() > 4){
//	    	if(list.get(list.size() - 4).val != 0 || list.get(list.size() - 3).val != 0 || list.get(list.size() - 2).val != 0 || list.get(list.size() - 1).val != 0)
//	    		return false;
//	    	else
//	    		return true;
//		}
//    	return false;
//    }
//	
	public int rob(TreeNode root){
		int cash = 0;
		if(root != null){
			cash = getCurr(root);
		}
		return cash;
	}
	
	private int getPre(TreeNode node){//不偷该节点时获得的收益
		int cash = 0;
		
		if(node != null){
			cash = getCurr(node.left)+getCurr(node.right);
		}
		
		return cash;
	}
	
	private int getCurr(TreeNode node){
		int cash1 = 0;
		int cash2 = 0;
		if(node != null){
			cash1 = node.val + getPre(node.left) + getPre(node.right);//偷该节点时获得的收益
			cash2 = getPre(node);
		}
		
		return cash1 >= cash2 ? cash1 : cash2;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		System.out.println(new SolutionHouseRobberIII().rob(root));
	}
}

/**
 * Definition for a binary tree node.
*/
	class TreeNode {
		   int val;
		   TreeNode left;
		   TreeNode right;
		   TreeNode(int x) { val = x; }
	}





