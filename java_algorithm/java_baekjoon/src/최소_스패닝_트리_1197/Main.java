package 최소_스패닝_트리_1197;
import java.util.*;

class Edge implements Comparable<Edge> {
	int v1, v2, cost;
	
	Edge(int v1, int v2, int cost) {
		this.v1 = v1;
		this.v2 = v2;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.cost - e.cost;
	}
}
public class Main {
	static int[] arr;
	static int answer = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		final int v = sc.nextInt();
		final int e = sc.nextInt();
		
		arr = new int[v + 1];
		for(int i = 1; i <= v; i++) {
			arr[i] = i;
		}
		
		ArrayList<Edge> list = new ArrayList<>(e);
		for(int i = 0; i < e; i++) {
			list.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(list);
		
		for(Edge x: list) {
			main.union(x);
		}
		
		System.out.println(answer);
		
	}
	
	private int find(final int v) {
		if(arr[v] == v) {
			return arr[v];
		}
		return arr[v] = find(arr[v]);
	}
	
	private void union(Edge e) {
		final int fv1 = find(e.v1);
		final int fv2 = find(e.v2);
		
		if(fv1 == fv2) {
			return;
		}
		
		answer += e.cost;
		arr[fv1] = fv2;
	}
	
}
