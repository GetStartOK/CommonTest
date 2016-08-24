package test_main;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
    	if(nums.length <= 1)
    		return nums.length;
    	int i = 0;
    	while(i < nums.length - 1 && nums[i] == nums[i + 1])
    		i ++;
    	if(i == nums.length - 1)
    		return 1;
        int res = 1;
        if(nums[i] < nums[i + 1])
        	res += getMaxS(nums, i + 1);
        else if(nums[i] > nums[i + 1])
        	res += getMaxL(nums, i + 1);
        return res;
    }
	
	private int getMaxL(int[] nums, int start) {
		if(start == nums.length - 1)
			return 1;
		int res = 0;
		for(int i = start, j = nums.length - 1; i < j; i++){
			if(nums[i] > nums[i + 1]){
				res += getMaxL(nums, i + 1);
				break;
			}
			else if(nums[i] < nums[i + 1]){
				res += getMaxS(nums, i + 1) + 1;
				break;
			}
		}
		return res;
	}

	private int getMaxS(int[] nums, int start) {
		if(start == nums.length - 1)
			return 1;
		int res = 0;
		for(int i = start, j = nums.length - 1; i < j; i++){
			if(nums[i] > nums[i + 1]){
				res += getMaxL(nums, i + 1) + 1;
				break;
			}else if(nums[i] < nums[i + 1]){
				res += getMaxS(nums, i + 1);
				break;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = {1,17,5,10,13,15,10,5,16,8};
		System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
	}

}
