package hw;

public class ThreadTest {
	
	public static void main(String[] args) {
//		ThreadTest lock = new ThreadTest();
//		T1 t1 = new T1(lock);
//		t1.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		T2 t2 = new T2(lock);
//		t2.setPriority(Thread.NORM_PRIORITY+1);
//		t2.start();
////		T3 t3 = new T3();
////		t3.setPriority(Thread.NORM_PRIORITY+2);
////		t3.start();
////		T4 t4 = new T4();
////		t4.setPriority(Thread.NORM_PRIORITY+3);
////		t4.start();
//		try {
//			t1.join();
//			System.out.println("T1结束");
//			t2.join();
//			System.out.println("T2结束");
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("主线程结束");
		int[] n1 = {3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1};
		int[] n2 = {3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1,3,2,1,3,2,1,3,2,1,3,2,13,2,1};
		T1 t1 = new T1(n1, n2);
		T2 t2 = new T2(n1, n2);
		t2.setPriority(10);
		t1.start();
		t2.start();
	}

	public static int sumArrays(int[] a1, int[] a2){
		int value = 0;
		int size = a1.length;
		if(size == a2.length){
			synchronized (a1) {
				Thread.yield();
				synchronized (a2) {
					for(int i = 0; i < size; i++){
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						value += a1[i] + a2[i];
					}
				}
			}
		}
		return value;
	}
	
	public static int sumArrays2(int[] a1, int[] a2){
		int value = 0;
		int size = a1.length;
		if(size == a2.length){
			synchronized (a2) {
				Thread.yield();
				synchronized (a1) {
					for(int i = 0; i < size; i++){
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						value += a1[i] + a2[i];
					}
				}
			}
		}
		return value;
	}
}

class T1 extends Thread{
	public ThreadTest lock = null;
	int[] n1,n2;
	public T1(int[] a1, int[] a2){
		n1 = a1;
		n2 = a2;
	}
	public void run(){
		System.out.println("1----"+ThreadTest.sumArrays(n1, n2));
//		int n = 0;
//		while(n++ < 5){
//			synchronized (lock) {
////				System.out.println("开始T1");
//				System.out.println("T1等待");
//				try {
//					if(n == 1)
//					lock.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
////				System.out.println("T1被唤醒");
////				System.out.println("T1睡眠。。。。");
////				try {
////					Thread.sleep(1000);
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
//				System.out.println("T1自己醒来");
//			}
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
	}
}

class T2 extends Thread{
	int[] n1,n2;
	public T2(int[] a1, int[] a2){
		n1 = a1;
		n2 = a2;
	}
	public void run(){
		System.out.println("2----"+ThreadTest.sumArrays2(n1, n2));
//		synchronized (lock) {
//			int n = 0;
//			ThreadTest lock2 = null;
//		while(n++ < 5){
////				System.out.println("开始T2");
////				System.out.println("T2等待");	
//			if(n==1)
//				lock2 = lock;
//			lock = new ThreadTest();
//			System.out.println(lock == lock2);
//			lock2.notify();
////				try {
////					ThreadTest.class.wait();
////				} catch (InterruptedException e) {
////					e.printStackTrace();
////				}
//				System.out.println("T2被唤醒");
//				Thread.yield();
//				System.out.println("T2睡眠。。。。");
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("T2自己醒来");
//			}
//		}
	}
}

class T3 extends Thread{
	public void run(){
		while(true){
			synchronized (T3.class) {
//				System.out.println("开始T3");
//				System.out.println("T3等待");	
//				T2.class.notify();
//				try {
//					ThreadTest.class.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("T3被唤醒");
//				System.out.println("T3睡眠。。。。");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T3自己醒来");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
class T4 extends Thread{
	public void run(){
		while(true){
			synchronized (T4.class) {
//				System.out.println("开始T3");
//				System.out.println("T3等待");	
//				T2.class.notify();
//				try {
//					ThreadTest.class.wait();
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				System.out.println("T3被唤醒");
//				System.out.println("T3睡眠。。。。");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("T4自己醒来");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}