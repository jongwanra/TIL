package immutable_object;

import java.util.ArrayList;
import java.util.List;

final class Counter {
	private final int count;
	
	public Counter(int count) {
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	
	public Counter increaseCount() {
		return new Counter(this.count + 1);
	}
}

public class ThreadSafeTest {
	public static void main(String[] args) throws InterruptedException {
		final int THREAD_COUNT = 10;
		final int ITERATIONS_PER_THREAD = 100;
		
		final Counter[] counter = {new Counter(0)};
		
		List<Thread> threads = new ArrayList<>();
		for (int i = 0; i < THREAD_COUNT; i++) {
			Thread thread = new Thread(() -> {
				for (int j = 0; j < ITERATIONS_PER_THREAD; j++) {
					// 불변 객체인 counter의 getCount() 호출
					counter[0] = counter[0].increaseCount();
				}
			});
			threads.add(thread);
			thread.start();
		}
		
		// 모든 스레드가 종료될 때까지 대기
		for (Thread thread : threads) {
			thread.join();
		}
		
		System.out.println("Final count: " + counter[0].getCount());
	}
}
