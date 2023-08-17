package dfs_and_bfs.수열_추측하기;

import java.util.*;

// Not Solved 23.08.17
public class Main {
	static int[] factorials;
	static int[] p, b;
	static int n;
	static int total;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		total = sc.nextInt();
		
		b = new int[n];
		p = new int[n];
		factorials = new int[n + 1];
		factorials[0] = 1;
		factorials[1] = 1;
		for (int i = 2; i <= n; i++) {
			factorials[i] = i * factorials[i - 1];
		}
		
		for (int r = 0; r < n; r++) {
			b[r] = factorials[n - 1] / (factorials[n - 1 - r] * factorials[r]);
		}
		
		main.myDfs(0, 0);
	}
	
	private void myDfs(final int depth, final int sum) {
		System.out.println("sum: " + sum + " depth: " + depth);
		if (depth == n) {
			if (sum == total) {
				for (int x : p) {
					System.out.print(x + " ");
				}
				System.out.println();
			}
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (p[i] > 0) {
				continue;
			}
			p[i] = i + 1;
			System.out.println("-----");
			for (int x : p) {
				System.out.print(x + " ");
			}
			System.out.println("-----");
			myDfs(depth + 1, sum + (b[i] * p[i]));
			p[i] = 0;
			
		}
	}
	
}
