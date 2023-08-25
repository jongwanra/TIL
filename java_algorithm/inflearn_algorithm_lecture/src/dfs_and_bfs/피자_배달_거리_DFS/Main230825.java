// package dfs_and_bfs.피자_배달_거리_DFS;
//
// import java.util.*;
//
// // 못 품..(23.08.25)
// // 못푼 이유: 문제에 대한 이해를 잘못했다.
// /*
//  * 문제 접근
//  * BFS 를 활용해서 최소 거리를 구할 예정
//  * 1 => 집들을 먼저 다 Queue에 넣자
//  * 그 이후에 피자 배달 거리를 누적해서 총 M개를 넣을 때까지 반복
//  * */
//
// class Point {
// 	int row;
// 	int col;
//
// 	int originRow;
// 	int originCol;
//
// 	Point(final int originRow, final int originCol) {
// 		this.row = originRow;
// 		this.col = originCol;
// 		this.originRow = originRow;
// 		this.originCol = originCol;
// 	}
//
// 	Point(final int row, final int col, final int originRow, final int originCol) {
// 		this.row = row;
// 		this.col = col;
// 		this.originRow = originRow;
// 		this.originCol = originCol;
// 	}
//
// 	int getDistance() {
// 		return Math.abs(originRow - row) + Math.abs(originCol - col);
// 	}
//
// 	@Override
// 	public String toString() {
// 		return "originRow: " + originRow + " originCol: " + originCol + " row: " + row + " col: " + col + " distance: "
// 			+ this.getDistance();
// 	}
// }
//
// public class Main230825 {
// 	static int n, m;
// 	static int answer = 0;
//
// 	// static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
// 	// static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
// 	static int[] dr = {-1, 0, 1, 0};
// 	static int[] dc = {0, 1, 0, -1};
//
// 	public static void main(String[] args) {
// 		Main main = new Main();
// 		Scanner sc = new Scanner(System.in);
//
// 		n = sc.nextInt();
// 		m = sc.nextInt();
// 		int[][] matrix = new int[n + 1][n + 1];
// 		Queue<Point> queue = new LinkedList<>();
// 		for (int row = 1; row <= n; row++) {
// 			for (int col = 1; col <= n; col++) {
// 				matrix[row][col] = sc.nextInt();
// 				// 초기 집의 위치 queue에 삽입
// 				if (matrix[row][col] == 1) {
// 					queue.offer(new Point(row, col));
// 				}
// 			}
// 		}
//
// 		main.myBfs(matrix, queue);
// 		System.out.println(answer);
// 	}
//
// 	private void myBfs(int[][] matrix, Queue<Point> queue) {
// 		int count = 0;
// 		while (!queue.isEmpty()) {
// 			final int curSize = queue.size();
//
// 			for (int loop = 0; loop < curSize; loop++) {
// 				Point curPoint = queue.poll();
//
// 				// 이미 최소 거리를 찾은 집인 경우
// 				if (matrix[curPoint.originRow][curPoint.originCol] == -1) {
// 					continue;
// 				}
//
// 				for (int i = 0; i < 4; i++) {
// 					final int nr = curPoint.row + dr[i];
// 					final int nc = curPoint.col + dc[i];
//
// 					if (nr <= 0 || nc <= 0 || nr > n || nc > n) {
// 						continue;
// 					}
//
// 					Point nextPoint = new Point(nr, nc, curPoint.originRow, curPoint.originCol);
// 					// 피자집 찾은 경우
// 					if (matrix[nr][nc] == 2) {
// 						System.out.println(nextPoint);
// 						if (matrix[nextPoint.originRow][nextPoint.originCol] == -1) {
// 							continue;
// 						}
// 						answer += nextPoint.getDistance();
//
// 						matrix[nextPoint.originRow][nextPoint.originCol] = -1;
// 						++count;
// 						if (count >= m) {
// 							return;
// 						}
// 						break;
// 					} else {
// 						// 피자 집을 찾지 못한 경우에만 queue에 추가
// 						queue.offer(nextPoint);
// 					}
//
// 				}
// 			}
// 		}
// 	}
//
// }
