package test_main;

public class RangeSumQuery_Immutable {

	int[] psum = null;
    public RangeSumQuery_Immutable(int[] nums) {
    	if(nums.length == 0)
    		return;
        psum = new int[nums.length];
        psum[0] = nums[0];
        for(int i = 1, j = nums.length; i < j; i++){
        	for(int k = i - lowerbit(i) + 1; k <= i; k ++)
        		psum[i] += nums[k];
        }
    }

    private int lowerbit(int num){
    	return num & -num;
    }
    
    private int sum(int i){
    	int sum = 0;
    	while(i > 0){
    		sum += psum[i];
    		i -= lowerbit(i);
    	}
    	sum += psum[i];
    	return sum;
    }
    
    public int sumRange(int i, int j) {
    	if(i == 0)
    		return sum(j);
        return sum(j) - sum(i - 1);
    }
	
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		RangeSumQuery_Immutable rs = new RangeSumQuery_Immutable(nums);
		System.out.println(rs.sumRange(0, 5));
	}

}
