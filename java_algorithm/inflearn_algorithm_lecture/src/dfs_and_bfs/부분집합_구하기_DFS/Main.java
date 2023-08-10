package dfs_and_bfs.부분집합_구하기_DFS;

import java.util.*;

/*
 * 부분 집합 구하기 문제
 * */

public class Main {
	static int[] arr;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1];
		main.myDfs(1, n);
	}
	
	private void myDfs(int curNum, int n) {
		if (curNum == n + 1) {
			for (int i = 1; i <= n; i++) {
				if (arr[i] == 1) {
					System.out.print(i + " ");
				}
			}
			System.out.println();
			return;
		}
		
		// 사용한다
		arr[curNum] = 1;
		myDfs(curNum + 1, n);
		
		// 사용하지 않는다.
		arr[curNum] = 0;
		myDfs(curNum + 1, n);
	}
	
}
