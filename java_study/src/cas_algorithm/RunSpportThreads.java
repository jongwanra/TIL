package cas_algorithm;

class SleepThread extends Thread {
	long sleepTime;
	
	public SleepThread(long sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	public void run() {
		try {
			System.out.println("SleepingThread getName: " + getName());
			System.out.println("Sleeping " + getState());
			Thread.sleep(sleepTime);
			System.out.println("Finished SleepingThread getName: " + getName());
			System.out.println("Sleeping " + getState());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class RunSpportThreads {
	public static void main(String[] args) {
		RunSpportThreads sample = new RunSpportThreads();
		sample.checkThreadState1();
	}
	
	private void checkThreadState1() {
		System.out.println("START!!");
		SleepThread thread = new SleepThread(100);
		
		System.out.println("?!!");
		try {
			System.out.println("thread state= " + thread.getState()); // NEW
			thread.start();
			System.out.println("thread state(after start)= " + thread.getState()); // RUNNABLE
			
			// System.out.println("-------");
			Thread.sleep(10_000);
			System.out.println("here");
			System.out.println("before join thread state()= " + thread.getState());
			thread.join();
			System.out.println("thread state(after join-1)= " + thread.getState());
			thread.interrupt();
			System.out.println("thread state(after join-2)= " + thread.getState());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
