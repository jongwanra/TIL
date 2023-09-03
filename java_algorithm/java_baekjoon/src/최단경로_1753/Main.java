package 최단경로_1753;

import java.io.*;
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
	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int n, m, startV;
	static int[] dis;
	static List<Edge>[] graph;
	public static void main(String[] args) throws IOException {
		Main main = new Main();
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 정점의 갯수
		m = Integer.parseInt(st.nextToken()); // 간선의 갯수
		startV =Integer.parseInt(br.readLine()); // 시작 정점
		
		dis = new int[n + 1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		graph = new ArrayList[n + 1];
		
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Edge(end, weight));
		}
		
		main.solution();
		
		br.close();
	}
	
	private void solution() {
		PriorityQueue<Edge> pQ = new PriorityQueue<>();
		
		dis[startV] = 0;
		pQ.offer(new Edge(startV, 0));
		
		while (!pQ.isEmpty()) {
			Edge cur = pQ.poll();
			
			int now = cur.v;
			int nowCost = cur.cost;
			
			if (dis[now] < nowCost) {
				continue;
			}
			
			for (Edge x : graph[now]) {
				final int next = x.v;
				final int nextCost = nowCost + x.cost;
				
				if (dis[next] < nextCost) {
					continue;
				}
				
				dis[next] = nextCost;
				pQ.offer(x);
			}
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (dis[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dis[i]).append("\n");
			}
			
		}
		try {
			bw.write(sb.toString());
			bw.close();
			
		} catch (Exception e) {
			throw new RuntimeException();
		}
		
		
		
	}
}
