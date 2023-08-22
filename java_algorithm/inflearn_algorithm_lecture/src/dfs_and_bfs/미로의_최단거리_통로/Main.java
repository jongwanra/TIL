package dfs_and_bfs.미로의_최단거리_통로;

import java.util.*;

class Chart {
	int w;
	int h;
	
	public Chart(int w, int h) {
		this.w = w;
		this.h = h;
	}
}

public class Main {
	final static int N = 7;
	static int[] dw = {0, 0, -1, 1};
	static int[] dh = {1, -1, 0, 0};
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		int[][] matrix = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		System.out.println(main.myBfs(matrix));
	}
	
	private int myBfs(int[][] matrix) {
		Queue<Chart> queue = new LinkedList<>();
		
		queue.offer(new Chart(0, 0));
		
		while (!queue.isEmpty()) {
			Chart cur = queue.poll();
			if (cur.w == N - 1 && cur.h == N - 1) {
				return matrix[cur.h][cur.w];
			}
			
			for (int i = 0; i < 4; i++) {
				int nw = cur.w + dw[i];
				int nh = cur.h + dh[i];
				
				// 범위에 벗어나는 이동인 경우
				if (nw < 0 || nw >= N || nh < 0 || nh >= N) {
					continue;
				}
				
				// 벽 이거나 이미 갔던 경로인 경우
				if (matrix[nh][nw] > 0) {
					continue;
				}
				matrix[nh][nw] = matrix[cur.h][cur.w] + 1;
				queue.offer(new Chart(nw, nh));
			}
		}
		return -1;
	}
}
