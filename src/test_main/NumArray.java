package test_main;

public class NumArray {

	private int[] ns;
	private int[] nums;
	public NumArray(int[] nums) {
		if(nums == null || nums.length <= 0)
			return;
		this.nums = nums;
		ns = new int[nums.length];
		ns[0] = nums[0];
		for(int i = 1, j = nums.length; i < j; ++i){
			int low = lowbit(i);
			for(int k = i - low + 1; k <= i; k ++){
				ns[i] += nums[k];
			}
		}
    }

    void update(int i, int val) {
        int ori = nums[i];
        this.nums[i] = val;
        if(i == 0){
        	ns[0] = val;
        	return;
        }
        ns[i] = ns[i] - ori + val;
    	i += lowbit(i);
    	int j = nums.length;
        while(i < j){
        	ns[i] = ns[i] - ori + val;
        	i += lowbit(i);
        }
    }

    public int sumRange(int i, int j) {
    	if(i <= 0){
    		return sum(j);
    	}
    	return sum(j) - sum(i - 1);
    }
	
    private int sum(int j){
    	int ret = 0;
    	while(j > 0){
    		ret += ns[j];
    		j -= lowbit(j);
    	}
    	ret += ns[j];
    	return ret;
    }
    
	private int lowbit(int j) {
		return j & (-j);
	}

	
	
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		NumArray na = new NumArray(nums);
		System.out.println(na.sumRange(2, 6));
		na.update(6, 6);
		System.out.println(na.sumRange(2, 6));
	}

}
