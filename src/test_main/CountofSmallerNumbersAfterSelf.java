package test_main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
	public List<Integer> countSmaller(int[] nums) {
		Integer[] ans = new Integer[nums.length];
		List<Integer> extra = new ArrayList<Integer>(nums.length);
        for(int i = nums.length - 1; i >= 0; i--){
        	int index = findIndex(extra, nums[i]);
        	ans[i] = index;
        	extra.add(index, nums[i]);
        }
        return Arrays.asList(ans);
    }

	
	public static void main(String[] args) {
		int[] nums = {5183,2271,3067,539,8939,2999,9264,737,3974,5846,-210,9278,5800,2675,6608,1133,-1,6018,9672,5179,9842,7424,-209,2988,2757,5984,1107,2644,-499,7234,7539,6525,347,5718,-742,1797,5292,976,8752,8297,1312,3385,5924,2882,6091,-282,2595,96,1906,8014,7667,5895,7283,7974,-167,7068,3946,6223,189,1589,2058,9277};
		System.out.println(new CountofSmallerNumbersAfterSelf().countSmaller(nums));
	}
	
	public int findIndex(List<Integer> sorted, int target){
		if(sorted.size() == 0) return 0;
		int start = 0;
		int end = sorted.size() - 1;
		if(target > sorted.get(end)) return end + 1;
		if(target < sorted.get(start)) return 0;
		
		while(start < end){
			int mid = start + (end - start)/2;
			if(target > sorted.get(mid)){
				start = mid + 1;
			}else{
				end = mid;
			}
		}
		return end;
	}
	
	 //二分查找  
    public static int binarySearch(int array[],int low,int high,int temp)  
    {  
        int mid=0;  
        while(low<=high)  
        {  
            mid=(low+high)/2;  
            if(array[mid]<temp&&temp<=array[mid+1])  
                return (mid+1);  
            else if(array[mid]<temp)  
                low = mid + 1;  
            else  
                high = mid -1;  
        }  
        return high;  
    }  
      
    //二分排序  
    public static void binarySort(int array[])  
    {  
        int i,j,k,temp;  
        for(i=1;i<array.length;i++)  
        {  
            temp=array[i];  
            if(array[i]<array[0])  
                k=0;  
            else  
                k = binarySearch(array,0,i,temp);  
              
            for(j=i;j>k;j--)  
            {  
                array[j]=array[j-1];  
            }  
            array[k]=temp;  
        }  
    }  
}
class Node implements Comparable<Node>{

	int value;
	int num;
	
	public Node(int value, int num){
		this.value = value;
		this.num = num;
	}

	@Override
	public int compareTo(Node o) {
		return o.num - this.num;
	}
}