package synchronized_keyword;

public class SynchronizedLockTest {
	
	private static final int NUM_THREADS = 100;
	private static final int NUM_ITERATIONS = 1;
	
	private static int synchronizedCounter = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] synchronizedThreads = new Thread[NUM_THREADS];
		
		for (int i = 0; i < NUM_THREADS; i++) {
			synchronizedThreads[i] = new Thread(() -> {
				long beforeTestWithSynchronized = System.nanoTime();
				
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					synchronized (SynchronizedLockTest.class) {
						String currentThreadName = Thread.currentThread().getName();
						System.out.println(currentThreadName + ": Lock acquired");
						synchronizedCounter++;
						System.out.println(currentThreadName + ": Lock released");
					}
				}
				
				long afterTestWithSynchronized = System.nanoTime();
				long performanceTimeWithSynchronized = afterTestWithSynchronized - beforeTestWithSynchronized;
				String currentThreadName = Thread.currentThread().getName();
				System.out.println(currentThreadName + ": Context Switching Time: " +
					(performanceTimeWithSynchronized / 1_000_000) + "ms");
			});
		}
		
		for (Thread thread : synchronizedThreads) {
			thread.start();
		}
		
		for (Thread thread : synchronizedThreads) {
			thread.join();
		}
	}
}
