package test_main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PatchingArray {
	int[] nums = null;
	Set<Integer> now = null;
	Set<Integer> tempSet = null;
	int total = 0;
	int lastPatch = 1;
	byte[] bnow = null;
	public int minPatches(int[] nums, int n) {
		total = n;
		int res = 0;
        now = new HashSet<Integer>(n);
        tempSet = new HashSet<Integer>();
        this.nums = nums;
        if(firstSearch())
        	return 0;
        int patch = 0;
        do{
    	   res ++;
    	   patch = getPatch();
        }while(!searchRest(patch));
        return res;
    }
	
	private int getPatch() {
		int n = 0;
		for(int i = lastPatch; i < total; i++){
			if(!now.contains(i)){
				lastPatch = i;
				n = i;
				break;
			}
		}
		return n;
	}

	private boolean searchRest(int n){
		tempSet.clear();
		Iterator<Integer> it = now.iterator();
		while(it.hasNext()){
			int t = it.next();
			if(t + n <= total){
				tempSet.add(t + n);
			}
		}
		tempSet.add(n);
		now.addAll(tempSet);
		if(now.size() == total){
			return true;
		}
		return false;
	}

	private boolean firstSearch() {
		for(int i = 0; i < nums.length; i++){
			tempSet.clear();
//			Set<Integer> temp = new HashSet<Integer>(now.size());
//			temp.addAll(now);
			Iterator<Integer> it = now.iterator();
			while(it.hasNext()){
				int t = it.next();
				if(nums[i] + t <= total){
					tempSet.add(nums[i] + t);
				}
			}
			tempSet.add(nums[i]);
			now.addAll(tempSet);
		}
		if(now.size() == total){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,31,33};
		System.out.println(new PatchingArray().minPatchesFromNet(nums, 2147483647));
	}
			
	public int minPatchesFromNet(int[] nums, int n) {
		int result = 0, index = 0;
		for(int currSum = 1; currSum <= n && currSum < 2147483647 ;){
			if(index < nums.length && currSum >= nums[index]){
				currSum += nums[index++];
			}else{
				if(currSum <= (2147483647 / 2))
					currSum <<= 1;
				else{
					currSum = 2147483647;
				}
				++result;
			}
		}
		return result;
    }
	
	
}
