package error_and_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		ExceptionTest main = new ExceptionTest();
		// main.testException();
		
		// main.checkRunTimeException();
		// main.checkPerformanceWithTryCatch(100_000_000);
		main.checkPerformanceWithoutTryCatch(100_000_000);
		
	}
	
	private void checkPerformanceWithoutTryCatch(final int size) {
		int[] arr = new int[size];
		long start = System.nanoTime();
		for (int i = 0; i < size; i++) {
			arr[i] = i;
		}
		long end = System.nanoTime();
		
		System.out.println("없을 때: " + (end - start) / 1_000_000 + "ms");
		
	}
	
	private void checkPerformanceWithTryCatch(final int size) {
		int[] arr = new int[size];
		long start = System.nanoTime();
		
		for (int i = 0; i < size; i++) {
			try {
				arr[i] = i;
			} catch (Exception e) {
				System.out.println();
			}
		}
		
		long end = System.nanoTime();
		
		System.out.println("Try-Catch문 있을 떄: " + (end - start) / 1_000_000 + "ms");
	}
	
	private void checkRunTimeException() {
		int[] arr = new int[10];
		arr[11] = 0;
		
	}
	
	private void testException() {
		try {
			login(1L, "123456");
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void login(final long id, final String password) throws InterruptedException {
		if (!password.equals("123455")) {
			throw new InterruptedException();
		}
	}
}
