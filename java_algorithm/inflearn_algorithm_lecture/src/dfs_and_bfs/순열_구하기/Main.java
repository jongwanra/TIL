package dfs_and_bfs.순열_구하기;

import java.util.*;

public class Main {
	
	static int[] selectedNums;
	static int[] arr;
	static int[] check;
	
	static int n, m;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		arr = new int[n];
		check = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		selectedNums = new int[m];
		
		main.myDfs(arr, 0);
		// main.lectureDfs(0);
	}
	
	private void myDfs(int[] arr, final int depth) {
		if (depth == m) {
			for (int x : selectedNums) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			final int target = arr[i];
			
			// 중복 으로 들어갔던 요소가 있는지 체크
			boolean isDuplicated = false;
			for (int j = 0; j < depth; j++) {
				if (selectedNums[j] == target) {
					isDuplicated = true;
					break;
				}
			}
			if (isDuplicated) {
				continue;
			}
			selectedNums[depth] = target;
			myDfs(arr, depth + 1);
		}
	}
	
	private void lectureDfs(final int depth) {
		if (depth == m) {
			for (int x : selectedNums) {
				System.out.print(x + " ");
			}
			System.out.println();
		} else {
			for (int i = 0; i < n; i++) {
				if (check[i] == 0) {
					check[i] = 1;
					selectedNums[depth] = arr[i];
					lectureDfs(depth + 1);
					check[i] = 0;
				}
			}
		}
	}
}
