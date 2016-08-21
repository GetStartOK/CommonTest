
public class SingleTon {
	
	private SingleTon(){};
	
	private static class MyClass {
		private static SingleTon st = new SingleTon();
	}
	
	public static SingleTon getInstance(){
		return SingleTon.MyClass.st;
	}
	public static void main(String[] args) {
		SingleTon2.INSTANCE.m();
	}
}

enum SingleTon2{
	INSTANCE,IN;
	public void m(){
		
	}
}