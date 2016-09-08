package test_main;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int r = height.length - 1;
        int max = 0;
        int last = 0;
        for(int i = 0; i < r; i ++){
        	if(height[i] <= last)
        		continue;
        	else
        		last = height[i];
        	int lm = 0;
        	for(int j = r; j > i; j --){
        		if(height[i] > height[j]){
        			lm = Math.max(lm, (j - i) * height[j]);
        		}else{
        			lm = Math.max(lm, (j - i) * height[i]);
        			break;
        		}
        			
        	}
        	max = Math.max(max, lm);
        }
        return max;
    }
    
	public static void main(String[] args) {
		int[] height = {};
		System.out.println(new ContainerWithMostWater().maxArea(height));
	}

}
