package dfs_and_bfs.토마토_BFS;

import java.util.*;

class Point {
	int row;
	int col;
	
	Point(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return "row: " + row + "col: " + col;
	}
}

public class Main {
	static int[] dw = {0, 1, 0, -1};
	static int[] dh = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		final int w = sc.nextInt();
		final int h = sc.nextInt();
		
		int[][] matrix = new int[h][w];
		
		boolean isZeroExist = false;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				matrix[i][j] = sc.nextInt();
				if (matrix[i][j] == 0) {
					isZeroExist = true;
				}
			}
		}
		
		if (!isZeroExist) {
			System.out.println(0);
			return;
		}
		System.out.println(main.myBfs(matrix, h, w));
		
	}
	
	private int myBfs(int[][] matrix, final int h, final int w) {
		int answer = 0;
		Queue<Point> queue = new LinkedList<>();
		// 초기 익은 토마토 위치 넣기
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (matrix[i][j] == 1) {
					queue.offer(new Point(i, j));
				}
			}
		}
		
		while (!queue.isEmpty()) {
			final int curSize = queue.size();
			for (int i = 0; i < curSize; i++) {
				Point cur = queue.poll();
				// System.out.println("cur: " + cur);
				
				for (int loop = 0; loop < 4; loop++) {
					final int nh = cur.row + dh[loop];
					final int nw = cur.col + dw[loop];
					
					// 범위를 벗어난 경우
					if (nh < 0 || nh >= h || nw < 0 || nw >= w) {
						continue;
					}
					
					// 토마토가 없는 경우, 이미 익은 경우
					if (matrix[nh][nw] == -1 || matrix[nh][nw] == 1) {
						continue;
					}
					matrix[nh][nw] = 1;
					queue.offer(new Point(nh, nw));
				}
			}
			answer++;
		}
		
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (matrix[i][j] == 0) {
					return -1;
				}
			}
		}
		return answer - 1;
	}
	
	private void printMatrix(int[][] matrix, final int h, final int w) {
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
