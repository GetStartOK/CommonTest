import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {
	public static void main(String[] args) {
		CountDownLatch cd = new CountDownLatch(5);
		Thread t = new Thread(new T(cd));
		t.start();
		Thread t2 = new Thread(new T2(cd));
		t2.start();
	}
	
	public static class T implements Runnable{
		CountDownLatch cd;
		public T(CountDownLatch cd){
			this.cd = cd;
		}
		@Override
		public void run() {
			try {
				cd.await();
				System.out.println("awake");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class T2 implements Runnable{
		CountDownLatch cd;
		public T2(CountDownLatch cd){
			this.cd = cd;
		}
		@Override
		public void run() {
				while(cd.getCount() > 0){
					System.out.println(cd.getCount());
					cd.countDown();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("awake him");
		}
	}
}
