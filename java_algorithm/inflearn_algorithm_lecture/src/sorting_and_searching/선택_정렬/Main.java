package sorting_and_searching.선택_정렬;

import java.util.Scanner;

/*
 * 선택 정렬(오름차순)
 * 앞에서부터 하나를 지정한다.
 * 지정한 원소 다음 index부터 순차적으로 보면서 최소값을 찾고 swap한다.
 * */
public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] sorted = main.mySolution(n, arr);
		for (int x : sorted) {
			System.out.print(x + " ");
		}
		System.out.println();
		
	}
	
	private int[] lectureSolution(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			int idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[idx])
					idx = j;
			}
			int tmp = arr[i];
			arr[i] = arr[idx];
			arr[idx] = tmp;
		}
		
		return arr;
	}
	
	private int[] mySolution(int n, int[] arr) {
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIdx] > arr[j]) {
					minIdx = j;
				}
			}
			if (minIdx != i) {
				int tmp = arr[i];
				arr[i] = arr[minIdx];
				arr[minIdx] = tmp;
			}
		}
		return arr;
	}
}
