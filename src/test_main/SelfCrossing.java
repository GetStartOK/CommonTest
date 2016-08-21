package test_main;

public class SelfCrossing {
	
	public static boolean isSelfCrossing(int[] x){
		boolean isEnter = false;
		int j = 0;
		int s = 0;
		if(x.length < 4)
			return false;
		if(x.length == 4){
			if(x[0] >= x[2] && x[1] <= x[3])
				return true;
			return false;
		}
		if(x[3] < x[1]){
			isEnter = true;
			j = 4;
			s = x[2];
		}else if(x[3] == x[1]){
			if(x[4] >= x[2] - x[0])
				return true;
			else{
				isEnter = true;
				j = 5;
				s = x[3];
			}
		}else{
			for(int i = 4; i < x.length; i ++){
				if(x[i] < (x[i - 2] - x[i - 4])){
					isEnter = true;
					j = i + 1;
					s = x[i - 1];
					break;
				}else if(x[i] >= (x[i - 2] - x[i - 4]) && x[i] <= x[i - 2]){
					isEnter = true;
					j = i + 1;
					s = x[i - 1] - x[i - 3];
					break;
				}else{
					isEnter = false;
				}
			}
		}
		
		if(isEnter == false)
			return false;
		for(int i = j; i < x.length; i ++){
			if(x[i] >= s){
				return true;
			}
			s = x[i - 1];
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] x = {1,1,2,1,1};
		System.out.println(isSelfCrossing(x));
	}
}
