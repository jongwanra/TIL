package dfs_and_bfs.미로탐색_DFS;

import java.util.*;

public class Main {
	
	static final int N = 7;
	static int[][] matrix;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		main.myDfs(0, 0);
		System.out.println(answer);
	}
	
	private void myDfs(final int w, final int h) {
		if (w == N - 1 && h == N - 1) {
			answer++;
			return;
		}
		
		// 벗어난 경우
		if (h < 0 || h >= N || w < 0 || w >= N) {
			return;
		}
		// 이미 간 경로인 경우
		if (matrix[h][w] == 1) {
			return;
		}
		
		// System.out.println("h : " + h + " w: " + w);
		
		matrix[h][w] = 1;
		myDfs(w + 1, h);
		myDfs(w - 1, h);
		myDfs(w, h + 1);
		myDfs(w, h - 1);
		matrix[h][w] = 0;
		
	}
	
	private void printMatrix() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
