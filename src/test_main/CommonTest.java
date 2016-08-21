package test_main;

public class CommonTest {
	
	public static void main(String[] args) {
//		for(int i = 0; i < 100; i++)
//		System.out.println(String.valueOf(System.currentTimeMillis() / 2 + System.nanoTime() / 2));
		int a = -1234567;
		for(int i = 31; i >= 0; i--){
			System.out.print((a >>> i) & 1);
		}
		System.out.println();
		for(int j = 0; j < 4; j++){
			byte b = (byte)(a >>> (j * 8));
			for(int i = 31; i >= 0; i--){
				System.out.print((b >>> i) & 1);
			}
			System.out.println();
		}
	}
	
}
