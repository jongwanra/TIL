package synchronized_keyword;

class EndlessThread extends Thread {
	public EndlessThread(String name) {
		super(name);
	}
	
	public EndlessThread() {
		super();
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println(System.currentTimeMillis());
				Thread.sleep(1000);
				System.out.println("in Run : " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class RunEndlessThread {
	public static void main(String[] args) {
		RunEndlessThread runEndlessThread = new RunEndlessThread();
		System.out.println("1 : " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
		EndlessThread thread = new EndlessThread();
		System.out.println("2 : " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
		thread.start();
		System.out.println("3 : " + Thread.currentThread().getName() + " " + Thread.currentThread().getState());
	}
}
