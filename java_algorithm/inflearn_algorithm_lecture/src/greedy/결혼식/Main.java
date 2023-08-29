package greedy.결혼식;

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		int[] arrivedTimes = new int[n];
		int[] goOutTimes = new int[n];
		
		for (int i = 0; i < n; i++) {
			arrivedTimes[i] = sc.nextInt();
			goOutTimes[i] = sc.nextInt();
		}
		System.out.println(main.mySolution(arrivedTimes, goOutTimes, n));
	}
	
	private int mySolution(int[] arrivedTimes, int[] goOutTimes, final int n) {
		int[] times = new int[73];
		int answer = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			for (int t = arrivedTimes[i]; t < goOutTimes[i]; t++) {
				times[t]++;
				if (times[t] > answer) {
					answer = times[t];
				}
			}
		}
		
		// printArr(times);
		return answer;
	}
	
	private void printArr(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
}
