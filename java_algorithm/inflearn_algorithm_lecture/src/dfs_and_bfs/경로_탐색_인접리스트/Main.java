package dfs_and_bfs.경로_탐색_인접리스트;

import java.util.*;

public class Main {
	static int answer = 0;
	static int n;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new ArrayList<>(n + 1);
		visited = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < m; i++) {
			final int a = sc.nextInt();
			final int b = sc.nextInt();
			graph.get(a).add(b);
		}
		visited[1] = true;
		main.myDfs(1);
		System.out.println(answer);
	}
	
	private void myDfs(int start) {
		if (start == n) {
			answer++;
			return;
		}
		
		for (int x : graph.get(start)) {
			if (visited[x]) {
				continue;
			}
			
			visited[x] = true;
			myDfs(x);
			visited[x] = false;
		}
		
	}
}


/*

5 9
1 2
1 3
1 4
2 1
2 3
2 5
3 4
4 2
4 5
*/

