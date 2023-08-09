package sorting_and_searching.Least_Recently_Used;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		int size = sc.nextInt();
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		//        LinkedList<Integer> made = main.mySolution(size, n, arr);
		int[] made = main.mySolutionByArray(size, n, arr);
		for (int x : made) {
			System.out.print(x + " ");
		}
	}
	
	private LinkedList<Integer> mySolution(int size, int n, int[] arr) {
		LinkedList<Integer> cache = new LinkedList<>();
		
		for (int x : arr) {
			int targetIdx = cache.indexOf(x);
			if (targetIdx >= 0) {
				cache.remove(targetIdx);
				cache.addFirst(x);
			} else {
				cache.addFirst(x);
				if (cache.size() > size) {
					cache.removeLast();
				}
			}
		}
		return cache;
	}
	
	private int indexOf(int[] arr, int target) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				return i;
			}
		}
		return -1;
	}
	
	private void addFirst(int[] arr, int target) {
		for (int i = arr.length - 2; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = target;
	}
	
	private void set(int[] arr, int target, int targetIdx) {
		for (int i = targetIdx - 1; i >= 0; i--) {
			arr[i + 1] = arr[i];
		}
		arr[0] = target;
	}
	
	private int[] mySolutionByArray(int size, int n, int[] arr) {
		
		int[] cache = new int[size];
		
		for (int x : arr) {
			int isExistIdx = indexOf(cache, x);
			
			/* 존재하지 않는 경우 */
			if (isExistIdx == -1) {
				addFirst(cache, x);
			} else {
				set(cache, x, isExistIdx);
			}
		}
		
		return cache;
	}
	
	private int[] lectureSolution(int size, int n, int[] arr) {
		int[] cache = new int[size];
		for (int x : arr) {
			int pos = -1;
			for (int i = 0; i < size; i++) {
				if (cache[i] == x) {
					pos = i;
					break;
				}
			}
			
			if (pos == -1) {
				for (int i = size - 1; i >= 1; i--)
					cache[i] = cache[i - 1];
			} else {
				for (int i = pos; i >= 1; i--)
					cache[i] = cache[i - 1];
			}
			cache[0] = x;
		}
		return cache;
	}
}
