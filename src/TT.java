
/**
 * @author rgsc_zh
 *
 */
public class TT {
	private int i = 2;
	
	public void set(int i){
		this.i = i;
	}
	
	public int get(){
		return i;
	}
	
	public static void main(String[] args) {
		TT t1 = new T2();
		T2 t2 = (T2) t1;
		t1.set(3);
		
		System.out.println(t1.get());
		System.out.println(t2.get());
	}
}

class T2 extends TT{
	public void set(int i){
		super.set(i);
	}
	
	public int get(){
		return super.get();
	}
}
