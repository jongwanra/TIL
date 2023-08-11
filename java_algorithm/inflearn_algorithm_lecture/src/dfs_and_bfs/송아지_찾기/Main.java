/* 못푼 문제... 230811 */

package dfs_and_bfs.송아지_찾기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		System.out.println(main.mySolution(sc.nextInt(), sc.nextInt()));
	}
	
	private int lectureSolution(int from, int to) {
		int[] dis = {1, -1, 5};
		Queue<Integer> Q = new LinkedList<>();
		int[] ch = new int[10001];
		ch[from] = 1;
		Q.offer(from);
		int L = 0;
		while (!Q.isEmpty()) {
			int len = Q.size();
			for (int i = 0; i < len; i++) {
				int x = Q.poll();
				for (int j = 0; j < 3; j++) {
					int nx = x + dis[j];
					if (nx == to) {
						return L + 1;
					}
					if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
						ch[nx] = 1;
						Q.offer(nx);
					}
				}
			}
			L++;
		}
		return 0;
	}
	
	private void printArr(int[] arr) {
		for (int x : arr) {
			System.out.print(x + " ");
		}
		System.out.println();
	}
	
	/*
	 * 첫 번째 시도 - 시간 초과..!
	 * 문제 해법 보고 난 후 - 이미 지나간 곳에 대해서 cache처리 -> 해결
	 * */
	private int mySolution(int from, int to) {
		int depth = 0;
		int[] dx = new int[] {1, -1, 5};
		HashMap<Integer, Boolean> hm = new HashMap<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(from);
		hm.put(from, true);
		
		while (!queue.isEmpty()) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				int cur = queue.poll();
				
				for (int j = 0; j < 3; j++) {
					int toGo = cur + dx[j];
					
					if (toGo == to) {
						return depth + 1;
					}
					// 방문한적이 없는 경우에 queue에 넣는 방법 추가
					if (hm.get(toGo) == null) {
						queue.offer(toGo);
						hm.put(toGo, true);
					}
				}
			}
			depth++;
		}
		return 0;
	}
}
