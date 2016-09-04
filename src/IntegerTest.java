
public class IntegerTest {
	
	public static void main(String[] args) {
		Integer i1 = 3, i2 = 3, i3 = 4, i4 = 4;
		Integer i5 = new Integer(3);
		System.out.println(i1 == i2);
		System.out.println(i1.equals(i2));
		System.out.println(i3 == i4);
		System.out.println(i3.equals(i4));
		System.out.println(i1.equals(i5));
		System.out.println(i1 == i5);
		
		IntegerTest it = new IntegerTest();
		
		T t1 = new T();
		T t2 = new T();
		System.out.println(t1 == t2);
	}
	
}
class T {
	
	@Override
	public int hashCode() {
		return 1;
	}
	}