package java8_updated;

import java.util.Arrays;

public class ParallelSortTest {
	public static void main(String[] args) {
		int[] arr = new int[5000];
		for (int i = 5000; i > 0; i--) {
			arr[5000 - i] = i;
		}
		
		Arrays.parallelSort(arr);
	}
}
