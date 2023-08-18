package cas_algorithm;

import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedVsCASPerformance {
	
	private static final int NUM_THREADS = 50;
	private static final int NUM_ITERATIONS = 1_000_000;
	
	private static int synchronizedCounter = 0;
	private static AtomicInteger casCounter = new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] synchronizedThreads = new Thread[NUM_THREADS];
		Thread[] casThreads = new Thread[NUM_THREADS];
		
		// Synchronized Test
		long beforeTestWithSynchronized = System.nanoTime();
		for (int i = 0; i < NUM_THREADS; i++) {
			synchronizedThreads[i] = new Thread(() -> {
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					synchronized (SynchronizedVsCASPerformance.class) {
						synchronizedCounter++;
					}
				}
			});
			synchronizedThreads[i].start();
		}
		
		for (Thread thread : synchronizedThreads) {
			thread.join();
		}
		
		// System.out.println("Synchronized Counter: " + synchronizedCounter);
		long afterTestWithSynchronized = System.nanoTime();
		long performanceTimeWithSynchronized = afterTestWithSynchronized - beforeTestWithSynchronized;
		
		// CAS Test
		
		long beforeTestWithCAS = System.nanoTime();
		for (int i = 0; i < NUM_THREADS; i++) {
			casThreads[i] = new Thread(() -> {
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					casCounter.getAndIncrement();
				}
			});
			casThreads[i].start();
		}
		
		for (Thread thread : casThreads) {
			thread.join();
		}
		
		// System.out.println("CAS Counter: " + casCounter.get());
		long afterTestWithCAS = System.nanoTime();
		long performanceTimeWithCAS = afterTestWithCAS - beforeTestWithCAS;
		
		System.out.println("synchronized performance : " + performanceTimeWithSynchronized);
		System.out.println("CAS performance : " + performanceTimeWithCAS);
		System.out.print("Who is Faster : ");
		if (performanceTimeWithCAS < performanceTimeWithSynchronized) {
			System.out.println("CAS");
		} else if (performanceTimeWithCAS > performanceTimeWithSynchronized) {
			System.out.println("synchronized");
		} else {
			System.out.println("Same");
		}
	}
}

