package dfs_and_bfs.섬나라_아일랜드_DFS;

import java.util.*;

public class Main {
	static int[] dw = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dh = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		final int n = sc.nextInt();
		
		int[][] matrix = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 1) {
					answer++;
					main.myDfs(matrix, n, j, i);
					// main.printArr(matrix, n);
				}
			}
		}
		
		System.out.println(answer);
		
	}
	
	private void printArr(int[][] matrix, final int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("------");
	}
	
	private void myDfs(int[][] matrix, final int n, final int w, final int h) {
		matrix[h][w] = 0;
		
		for (int i = 0; i < 8; i++) {
			final int nw = w + dw[i];
			final int nh = h + dh[i];
			
			if (nw < 0 || nw >= n || nh < 0 || nh >= n) {
				continue;
			}
			if (matrix[nh][nw] == 0) {
				continue;
			}
			
			myDfs(matrix, n, nw, nh);
		}
	}
}
