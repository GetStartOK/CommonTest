package test_main;

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
    	long left = 1, right = num;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		int num = 2147483647;
		System.out.println(new ValidPerfectSquare().isPerfectSquare(num));
	}

}
