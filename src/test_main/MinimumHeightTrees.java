package test_main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	List<Integer> leaves = new ArrayList<Integer>();
    	if(edges.length == 0){
    	    leaves.add(0);
    	    return leaves;
    	}
    	List<Set<Integer>> lset = new ArrayList<Set<Integer>>(n);
    	for(int i = 0, j = n; i < j; i++){
    		lset.add(new HashSet<Integer>());
    	}
    	for(int i = 0, j = edges.length; i < j; i++){
    		int l = edges[i][0];
    		int r = edges[i][1];
    		lset.get(l).add(r);
    		lset.get(r).add(l);
    	}
    	for(int i = 0, j = n; i < j; i++){
    		if(lset.get(i).size() == 1){
    			leaves.add(i);
    		}
    	}
    	while(n > 2){
    		n -= leaves.size();
    		List<Integer> newLeaves = new ArrayList<Integer>();
	    	for(int i = 0, j = leaves.size(); i < j; i++){
	    		int l = lset.get(leaves.get(i)).iterator().next();
	    		lset.get(l).remove(leaves.get(i));
	    		if(lset.get(l).size() == 1)
	    			newLeaves.add(l);
	    	}
	    	leaves = newLeaves;
    	}
        return leaves;
    }
	
	public static void main(String[] args) {
		int[][] edges = {{1,0},{1,2},{1,3}};
		int n = 4;
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(n, edges));
	}

}

