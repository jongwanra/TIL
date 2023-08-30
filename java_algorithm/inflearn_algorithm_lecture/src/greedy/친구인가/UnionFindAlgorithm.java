package greedy.친구인가;

import java.util.*;

public class UnionFindAlgorithm {
	
	static int[] arr;
	
	private static int find(int v) {
		if (arr[v] == v) {
			return arr[v];
		}
		return arr[v] = find(arr[v]);
	}
	
	private static void union(int a, int b) {
		int fa = find(a);
		int fb = find(b);
		if (fa != fb) {
			arr[fa] = fb;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		final int n = sc.nextInt();
		final int m = sc.nextInt();
		arr = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}
		
		for (int i = 0; i < m; i++) {
			union(sc.nextInt(), sc.nextInt());
		}
		
		if (find(sc.nextInt()) == find(sc.nextInt())) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
		// for (int x : arr) {
		// 	System.out.print(x + " ");
		// }
		//
		// System.out.println();
	}
}
