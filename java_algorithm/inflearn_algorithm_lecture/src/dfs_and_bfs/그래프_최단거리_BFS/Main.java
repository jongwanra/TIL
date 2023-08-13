package dfs_and_bfs.그래프_최단거리_BFS;

import java.util.*;

public class Main {
	static int n, m;
	static int[] ch, dis;
	static ArrayList<ArrayList<Integer>> graph;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		graph = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			graph.set(i, new ArrayList<Integer>());
		}
		ch = new int[n + 1];
		dis = new int[n + 1];
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			graph.get(a).add(b);
		}
		
		main.lectureBfs(1);
		
	}
	
	private void lectureBfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ch[v] = 1;
		dis[v] = 0;
		queue.offer(v);
		
		while (!queue.isEmpty()) {
			int cv = queue.poll();
			
			for (int nv : graph.get(cv)) {
				if (ch[v] == 0) {
					ch[nv] = 1;
					queue.offer(nv);
					dis[nv] = dis[cv] + 1;
				}
			}
		}
	}
}
