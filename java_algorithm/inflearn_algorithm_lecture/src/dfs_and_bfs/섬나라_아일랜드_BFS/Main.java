package dfs_and_bfs.섬나라_아일랜드_BFS;

import java.util.*;

class Point {
	int w;
	int h;
	
	Point(int w, int h) {
		this.w = w;
		this.h = h;
	}
}

public class Main {
	static int n;
	static int[] dw = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dh = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[][] matrix = new int[n][n];
		int answer = 0;
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				matrix[row][col] = sc.nextInt();
			}
		}
		
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n; col++) {
				if (matrix[row][col] == 1) {
					answer++;
					main.myBfs(matrix, row, col);
				}
			}
		}
		
		System.out.println(answer);
	}
	
	private void myBfs(int[][] matrix, final int h, final int w) {
		Queue<Point> queue = new LinkedList<>();
		queue.offer(new Point(w, h));
		
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			
			for (int loop = 0; loop < 8; loop++) {
				final int nw = cur.w + dw[loop];
				final int nh = cur.h + dh[loop];
				
				if (nw < 0 || nw >= n || nh < 0 || nh >= n) {
					continue;
				}
				if (matrix[nh][nw] == 0) {
					continue;
				}
				
				matrix[nh][nw] = 0;
				queue.offer(new Point(nw, nh));
				
			}
		}
	}
}
