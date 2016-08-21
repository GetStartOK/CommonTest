import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	public static void main(String[] args) {
		CyclicBarrier cb = new CyclicBarrier(3, new T2());
		for(int i = 0; i < 3; i ++){
			Thread th = new Thread(new T(cb));
			th.start();
		}
	}
	public static class T implements Runnable{
		CyclicBarrier cb;
		public T(CyclicBarrier cb){
			this.cb = cb;
		}
		@Override
		public void run() {
				try {
					cb.await();//调用await,计数器加一
					System.out.println("awake");
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
		}
	}
	
	public static class T2 implements Runnable{
//		CyclicBarrier cb;
//		public T2(CyclicBarrier cb){
//			this.cb = cb;
//		}
		@Override
		public void run() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
				System.out.println("do new task");
		}
	}
}
