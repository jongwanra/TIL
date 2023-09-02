package greedy.원더랜드_PQ;

import java.util.*;

class Edge implements Comparable<Edge> {
	int v, cost;
	
	Edge(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		final int m = sc.nextInt();
		ArrayList<ArrayList<Edge>> list = new ArrayList<>(n + 1);
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < m; i++) {
			final int v1 = sc.nextInt();
			final int v2 = sc.nextInt();
			final int cost = sc.nextInt();
			
			// System.out.println(v1 + " " + v2 + " " + cost);
			list.get(v1).add(new Edge(v2, cost));
			list.get(v2).add(new Edge(v1, cost));
		}
		
		System.out.println(main.mySolution(n, list));
	}
	
	private int mySolution(final int n, ArrayList<ArrayList<Edge>> list) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		boolean[] visited = new boolean[n + 1];
		int answer = 0;
		pQ.offer(new Edge(1, 0));
		
		while (!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			if (visited[cur.v]) {
				continue;
			}
			visited[cur.v] = true;
			answer += cur.cost;
			for (Edge x : list.get(cur.v)) {
				if (visited[x.v]) {
					continue;
				}
				
				pQ.offer(x);
			}
		}
		return answer;
	}
}
