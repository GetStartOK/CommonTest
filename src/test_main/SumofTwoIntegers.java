package test_main;

public class SumofTwoIntegers {

	public int getSum2(int a, int b){ // 异或可以得结果，与可以得到进位，再将进位与结果相加，直到进位为0
		while(b != 0){
			System.out.println("a : "+Integer.toBinaryString(a));
			System.out.println("b : "+Integer.toBinaryString(b));
			int carry = a & b;
			System.out.println("a & b : "+Integer.toBinaryString(carry));
			a = a ^ b;
			System.out.println("a ^ b : "+Integer.toBinaryString(a));
			b = carry << 1;
			System.out.println("----------------------");
		}
		return a;
	}
	
	public int getSum(int a, int b) {
		String x = Integer.toBinaryString(a);
		String y = Integer.toBinaryString(b);
		boolean isXBigger = false;
		int l,m;
		if(x.length() > y.length()){
			isXBigger = true;
			l = y.length();
			m = x.length();
		}else{
			l = x.length();
			m = y.length();
		}
		char[] chs = new char[m + 1];
		boolean add = false;
		for(int i = l - 1; i >= 0; i--){
			char cx,cy;
			if(isXBigger){
				cx = x.charAt(m - l + i);
				cy = y.charAt(i);
			}else{
				cx = x.charAt(i);
				cy = y.charAt(m - l + i);
			}
			if((cx == '0' && cy == '1') || (cx == '1' && cy == '0')){
				if(add){
					add = true;
					chs[m - l + 1 + i] = '0';
				}else{
					add = false;
					chs[m - l + 1 + i] = '1';
				}
			}else if(cx == '0' && cy == '0'){
				if(add){
					chs[m - l + 1 + i] = '1';
				}else
					chs[m - l + 1 + i] = '0';
				add = false;
			}else{
				if(add){
					chs[m - l + 1 + i] = '1';
				}else
					chs[m - l + 1 + i] = '0';
				add = true;
			}
		}
        while(l <= m - 1){
        	char cx = '0';
        	if(isXBigger){
        		cx = x.charAt(m - l - 1);
        	}else{
        		cx = y.charAt(m - l - 1);
        	}
        	if(add){
        		if(cx == '0'){
        			add = false;
        			chs[m - l] = '1';
        		}else{
        			add = true;
        			chs[m - l] = '0';
        		}
        	}else{
        		if(cx == '0'){
        			chs[m - l] = '0';
        		}else
        			chs[m - l] = '1';
        		add = false;
        	}
        	l++;
        }
        if(add){
        	chs[0] = '1';
        }else{
        	chs[0] = '0';
        }
        String s = new String(chs);
        return Integer.parseInt(s, 2);
    }
	
	public static void main(String[] args) {
		int a = 7, b = 9;
		System.out.println(new SumofTwoIntegers().getSum2(a, b));
	}

}
