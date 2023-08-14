package cas_algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class Counter {
	private final AtomicInteger count;
	
	public Counter(int initialValue) {
		this.count = new AtomicInteger(initialValue);
	}
	
	public int getCount() {
		return count.get();
	}
	
	public Counter increment() {
		return new Counter(count.incrementAndGet());
	}
}

public class ImmutableObjectTest {
	public static void main(String[] args) throws InterruptedException {
		final int THREAD_COUNT = 10;
		final int ITERATIONS_PER_THREAD = 1000;
		
		AtomicReference<Counter> counter = new AtomicReference<>(new Counter(0));
		
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			final Counter currentCounter = counter.get();
			Thread thread = new Thread(() -> {
				for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
					counter.set(currentCounter.increment());
				}
			});
			threads.add(thread);
			thread.start();
		}
		
		// 모든 스레드가 종료될 때까지 대기
		for (Thread thread : threads) {
			thread.join();
		}
		
		System.out.println("Final count: " + counter.get().getCount());
	}
}



