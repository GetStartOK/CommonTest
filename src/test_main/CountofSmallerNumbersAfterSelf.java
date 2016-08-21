package test_main;

import java.util.ArrayList;
import java.util.List;

public class CountofSmallerNumbersAfterSelf {
	
	public List<Integer> countSmaller(int[] nums) {
		int[] res = new int[nums.length];
		
        for(int i = nums.length - 1; i >= 0; i--){
        	findPreSmall(res, nums, i);
        }
        List<Integer> rList = new ArrayList<Integer>();
        for(int r : res){
        	rList.add(r);
        }
        return rList;
    }

	private void findPreSmall(int[] res, int[] nums, int i) {
		int j = i + 1;
		while(j < nums.length && nums[i] <= nums[j])
			j ++;
		if(j < nums.length)
			res[i] = res[j] + 1;
	}
	
	public static void main(String[] args) {
		int[] nums = {9,8,7,54,65,21,32,45,98,45};
		binarySort(nums);
		System.out.println(new CountofSmallerNumbersAfterSelf().countSmaller(nums));
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
