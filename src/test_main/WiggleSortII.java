package test_main;

import java.util.Arrays;

public class WiggleSortII {

	public void wiggleSort(int[] nums) {
		for(int i = 0; i < nums.length - 1;){
			if(i % 2 == 0){
				if(nums[i] < nums[i + 1]){
					i++;
					continue;
				}
				else if(nums[i] > nums[i + 1]){
					int t = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = t;
					i++;
					continue;
				}
			}else{
				if(nums[i] > nums[i + 1]){
					i++;
					continue;
				}else if(nums[i] < nums[i + 1]){
					int t = nums[i];
					nums[i] = nums[i + 1];
					nums[i + 1] = t;
					i++;
					continue;
				}
			}
			int j = i + 1;
			while(j < nums.length - 1 && nums[j] == nums[j + 1])
				j ++;
			if(j < nums.length - 1){
				int t = nums[i + 1];
				nums[i + 1] = nums[j + 1];
				nums[j + 1] = t;
			}else{
				j = i - 2;
				while(true){
					if(j % 2 == 0){
						if(j == 0){
							int t = nums[i + 1];
							nums[i + 1] = nums[j];
							nums[j] = t;
							break;
						}else{
							if(nums[i + 1] < nums[j + 1] && nums[i + 1] < nums[j - 1] && nums[i + 1] != nums[j]){
								int t = nums[i + 1];
								nums[i + 1] = nums[j];
								nums[j] = t;
								break;
							}else{
								j --;
							}
						}
					}else{
						if(nums[i + 1] > nums[j + 1] && nums[i + 1] > nums[j - 1] && nums[i + 1] != nums[j]){
							int t = nums[i + 1];
							nums[i + 1] = nums[j];
							nums[j] = t;
							break;
						}else{
							j --;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		int[] nums = {4,5,5,6};
		new WiggleSortII().wiggleSort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
