package greedy.원더랜드_크루스칼;

import java.util.*;

class Edge implements Comparable<Edge> {
	int e1, e2, cost;
	
	Edge(int e1, int e2, int cost) {
		this.e1 = e1;
		this.e2 = e2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}

public class Main {
	static int[] vertexes;
	static int v, e;
	static int answer = 0;
	
	static int find(final int v) {
		if (vertexes[v] == v) {
			return vertexes[v];
		}
		
		return vertexes[v] = find(vertexes[v]);
	}
	
	static void union(Edge e) {
		final int fe1 = find(e.e1);
		final int fe2 = find(e.e2);
		
		if (fe1 == fe2) {
			return;
		}
		
		answer += e.cost;
		vertexes[fe1] = fe2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		v = sc.nextInt();
		e = sc.nextInt();
		
		vertexes = new int[v + 1];
		for (int i = 1; i <= v; i++) {
			vertexes[i] = i;
		}
		ArrayList<Edge> list = new ArrayList<>(v);
		for (int i = 0; i < e; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(list);
		
		for (Edge x : list) {
			union(x);
		}
		
		// for (int x : vertexes) {
		// 	System.out.print(x + " ");
		// }
		System.out.println(answer);
		
	}
}
