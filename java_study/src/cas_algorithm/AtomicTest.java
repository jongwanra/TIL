package cas_algorithm;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	private static int count;
	
	public static void main(String[] args) throws InterruptedException {
		AtomicTest test = new AtomicTest();
		test.checkAtomicIntegerMethod(100);
		test.checkAtomicBooleanMethod(100);
		
	}
	
	private void checkAtomicBooleanMethod(int size) {
		AtomicBoolean atomicBoolean = new AtomicBoolean();
	}
	
	private void checkAtomicIntegerMethod(int size) throws InterruptedException {
		
		AtomicInteger atomicCount = new AtomicInteger(0);
		
		for (int loop = 0; loop < size; loop++) {
			new Thread(() -> {
				for (int i = 0; i < 100000; i++) {
					count++;
					atomicCount.incrementAndGet();
				}
			}).start();
		}
		
		Thread.sleep(5000);
		System.out.println("atomic 결과 : " + atomicCount.get());
		System.out.println("int 결과 : " + count);
	}
}
