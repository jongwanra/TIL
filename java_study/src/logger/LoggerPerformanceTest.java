package logger;

public class LoggerPerformanceTest {
	private static final int DEFAULT_SIZE = 1_000;
	
	public static void main(String[] args) {
		LoggerPerformanceTest test = new LoggerPerformanceTest();
		int[] arr = new int[DEFAULT_SIZE];
		
		long includeSystemOutPrint = test.testArrayIncludeSystemOutPrint(arr);
		long notInclude = test.testArrayNotInclude(arr);
		System.out.println("include System.out.print: " + includeSystemOutPrint);
		System.out.println("not include System.out.print: " + notInclude);
		System.out.print("몇 배이상 차이가 날까?: " + (includeSystemOutPrint / notInclude));
		
	}
	
	private long testArrayNotInclude(int[] arr) {
		
		long start = System.nanoTime();
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			arr[i] = 1;
		}
		long end = System.nanoTime();
		
		return end - start;
	}
	
	private long testArrayIncludeSystemOutPrint(int[] arr) {
		
		long start = System.nanoTime();
		for (int i = 0; i < DEFAULT_SIZE; i++) {
			arr[i] = 1;
			System.out.println(10);
		}
		long end = System.nanoTime();
		
		return end - start;
	}
}
