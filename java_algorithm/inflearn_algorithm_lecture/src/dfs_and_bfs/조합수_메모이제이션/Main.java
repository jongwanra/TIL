package dfs_and_bfs.조합수_메모이제이션;

import java.util.*;

public class Main {
	static int[][] dp;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int r = sc.nextInt();
		dp = new int[n + 1][n + 1];
		System.out.println(main.myDfs(n, r));
	}
	
	private int lectureDfs(int n, int r) {
		// System.out.println("n : " + n + " r: " + r);
		
		if (n == r || r == 0) {
			return 1;
		}
		
		if (dp[n][r] > 0) {
			return dp[n][r];
		}
		
		return dp[n][r] = lectureDfs(n - 1, r - 1) + lectureDfs(n - 1, r);
	}
	
	private int myDfs(final int n, final int r) {
		
		if (n == -1) {
			return 0;
		}
		if (r == 0) {
			return 1;
		}
		
		if (dp[n][r] > 0) {
			return dp[n][r];
		}
		
		dp[n][r] = myDfs(n - 1, r - 1) + myDfs(n - 1, r);
		return dp[n][r];
	}
}
