package cas_algorithm;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	
	private static int count;
	
	public static void main(String[] args) throws InterruptedException {
		AtomicTest test = new AtomicTest();
		test.checkAtomicIntegerMethod(3);
		// test.checkAtomicBooleanMethod(100);
		// test.checkJustVisibility(10);
		
	}
	
	private void checkJustVisibility(final int size) throws InterruptedException {
		AtomicInteger atomicCount = new AtomicInteger(0);
		
		for (int loop = 0; loop < size; loop++) {
			new Thread(() -> {
				for (int i = 0; i < 1000; i++) {
					atomicCount.set(atomicCount.get() + 1);
				}
			}).start();
		}
		
		Thread.sleep(5000);
		System.out.println("atomic 결과 : " + atomicCount.get());
	}
	
	private void checkAtomicBooleanMethod(int size) {
		AtomicBoolean atomicBoolean = new AtomicBoolean();
	}
	
	private void checkAtomicIntegerMethod(int size) throws InterruptedException {
		
		AtomicInteger atomicCount = new AtomicInteger(0);
		
		for (int loop = 0; loop < size; loop++) {
			new Thread(() -> {
				for (int i = 0; i < 5; i++) {
					atomicCount.incrementAndGet();
				}
			}).start();
		}
		
		Thread.sleep(5000);
		System.out.println("atomic 결과 : " + atomicCount.get());
	}
}
