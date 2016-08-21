import java.util.concurrent.Phaser;

public class PhaserTest {
	public static void main(String args[]) {
        final int count = 3;
        final Phaser phaser = new Phaser(count); // �ܹ���3��registered parties
        for(int i = 0; i < 2; i++) {
            final Thread thread = new Thread(new Task(phaser));
            thread.start();
        }
        Thread th = new Thread(new Task2(phaser));
        th.start();
    }
     
    public static class Task implements Runnable {
        private final Phaser phaser;
 
        public Task(Phaser phaser) {
            this.phaser = phaser;
        }
         
        @Override
        public void run() {
            System.out.println(phaser.arrive()); // ÿִ�е����������һ��party arrive�����arrived parties����registered parties�������¼���ִ�У�����ȴ�
            System.out.println("---");
        }
    }
    
    public static class Task2 implements Runnable{
    	private final Phaser phaser;
    	 
        public Task2(Phaser phaser) {
            this.phaser = phaser;
        }
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(phaser.arriveAndAwaitAdvance());
			System.out.println("===");
		}
    	
    }
}
