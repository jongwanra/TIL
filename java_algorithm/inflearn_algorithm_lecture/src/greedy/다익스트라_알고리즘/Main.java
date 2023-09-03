package greedy.다익스트라_알고리즘;

import java.util.*;

class Edge implements Comparable<Edge> {
	public int vex;
	public int cost;
	
	Edge(int vex, int cost) {
		this.vex = vex;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge ob) {
		return this.cost - ob.cost;
	}
}

public class Main {
	static int n, m;
	static ArrayList<ArrayList<Edge>> graph;
	static int[] dis;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new ArrayList<ArrayList<Edge>>();
		
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<Edge>());
		}
		
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			graph.get(a).add(new Edge(b, c));
		}
		
		main.solution(1);
	}
	
	public void solution(final int v) {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		pQ.offer(new Edge(v, 0));
		dis[v] = 0;
		
		while (!pQ.isEmpty()) {
			Edge tmp = pQ.poll();
			int now = tmp.vex;
			int nowCost = tmp.cost;
			
			// 최소 비용을 구해야 하기 때문에 현재 비용이 더 큰 경우에는 패스
			if (nowCost > dis[now]) {
				continue;
			}
			
			for (Edge ob : graph.get(now)) {
				// 더 작은 비용인 경우
				if (dis[ob.vex] > nowCost + ob.cost) {
					dis[ob.vex] = nowCost + ob.cost;
					pQ.offer(new Edge(ob.vex, nowCost + ob.cost));
				}
			}
			
		}
	}
}
