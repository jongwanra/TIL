package dfs_and_bfs.수열_추측하기;

import java.util.*;

public class Main230817 {
	// Not Solved 23.08.17
	
	static int[] factorials;
	static int[] p, b;
	static int n;
	static int total;
	
	public static void main(String[] args) {
		Main230817 main = new Main230817();
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
		
		main.myDfs230817(0, 0);
	}
	
	private void myDfs230817(final int depth, final int sum) {
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
			myDfs230817(depth + 1, sum + (b[i] * p[i]));
			p[i] = 0;
			
		}
	}
}
