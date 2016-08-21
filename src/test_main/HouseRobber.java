package test_main;

public class HouseRobber {
	
	public int rob(int[] nums){
		return y(nums, 0);
	}
		
	
	private int max(int[] nums, int index){
		
		int n = y(nums, index);
		int m = n(nums, index);
		
//		if(n > m){
//			System.out.println(index);
//			return n;
//		}
//		else{
//			return m;
//		}
		
//		 int sum1 = 0;int sum2 = 0;
//         for(int i =0;i<nums.length;i++){
//             int temp = sum1;
//             sum1 = Math.max(sum1, sum2);
//             sum2 = temp + nums[i];
//         }
//         System.out.println( Math.max(sum1, sum2));
		return n >= m ? n : m;
	}
	
	private int y(int[] nums, int index){
		int n = 0;
		int m = 0;
		if(index < nums.length){
			n = nums[index] + n(nums, index+1);
			m = y(nums, index+1);
		}
		return n >= m ? n : m;
	}

	private int n(int[] nums, int i) {
		int m = 0;
		if(i < nums.length){
			m = y(nums, i+1);
		}
		return m;
	}
	
	public static void main(String[] args) {
		int[] nums = {104,209,137,52,158,67,213,86,141,110,151,127,238,147,169,138,240,185,246,225,147,203,83,83,131,227,54,78,156,180,214,151,111,161,233,147,124,143};
		int s1 = 0, s2 = 0;
		for(int i = 0; i < nums.length; i ++){
			int temp = s2;
			s2 = Math.max(nums[i] + s1, s2);
			s1 = temp;
		}
		System.out.println(s2);
	}
	
}
