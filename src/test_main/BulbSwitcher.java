package test_main;

public class BulbSwitcher {

	public int bulbSwitch(int n) {
		int a = n / 8;
		int b = n % 8;
		byte res = (byte) ((-1 & 0xff) >>(8 - b));
		byte[] bs = null;
		bs = new byte[a];
		for(int i = 0; i < a; i++){
			bs[i] = -1;
		}
        for(int i = 2; i <= n; i ++){
        	int loc = i-1;
        	while(loc < n){
        		int offset = loc % 8;
        		int t = 0x01 << offset;
        		if(loc < 8 * a){
        			byte b2 = bs[loc / 8];
            		if(b2 != (b2 | t)){
            			bs[loc / 8] = (byte) (b2 | t);
            		}else{
            			t ^= 0xff;
            			bs[loc / 8] = (byte) (b2 & t);
            		}
        		}else{
        			if(res != (res | t)){
            			res = (byte) (res | t);
            		}else{
            			t ^= 0xff;
            			res = (byte) (res & t);
            		}
        		}
        		loc += i;
        	}
        }
        int result = 0;
        for(int i = 0; i < a; i++){
        	byte bt = bs[i];
        	for(int j = 0; j < 8; j++){
        		if(((bt >> j) & 0x01) == 1){
        			result++;
        		}
        	}
        }
        for(int i = 0; i < b; i++){
        	if(((res >> i) & 0x01) == 1)
        		result ++;
        }
        return result;
    }	
	
	public static void main(String[] args) {
		System.out.println(new BulbSwitcher().bulbSwitch(10000000));
	}

}
