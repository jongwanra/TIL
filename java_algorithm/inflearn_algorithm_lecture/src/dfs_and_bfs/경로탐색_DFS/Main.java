package dfs_and_bfs.경로탐색_DFS;

import java.util.*;

public class Main {
	static int answer = 0;
	static boolean[] visited;
	static int[][] graph;
	static int n;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		
		graph = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			graph[a][b] = 1;
		}
		
		// for (int i = 1; i <= n; i++) {
		// 	for (int j = 1; j <= n; j++) {
		// 		System.out.print(graph[i][j] + " ");
		// 	}
		// 	System.out.println();
		// }
		
		visited[1] = true;
		main.myDfs(1);
		System.out.print(answer);
	}
	
	private void lectureDfs(int v) {
		if (v == n) {
			answer++;
		} else {
			for (int i = 1; i <= n; i++) {
				if (graph[v][i] == 1 && !visited[i]) {
					visited[i] = true;
					lectureDfs(i);
					visited[i] = false;
				}
			}
		}
		
	}
	
	private void myDfs(int start) {
		if (start == n) {
			answer++;
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			if (graph[start][i] == 0) {
				continue;
			}
			
			if (!visited[i]) {
				visited[i] = true;
				myDfs(i);
				visited[i] = false;
				
			}
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
