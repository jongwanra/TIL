package stream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamTest {
	public static void main(String[] args) {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("commonPool.getParallelism() = " + commonPool.getParallelism());
		
		Arrays.asList("a", "b", "c", "d", "e")
			.parallelStream()
			.filter(s -> {
				System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}
}
