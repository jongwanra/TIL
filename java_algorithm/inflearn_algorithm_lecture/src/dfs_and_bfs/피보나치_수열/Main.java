package dfs_and_bfs.피보나치_수열;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		// main.mySolution(n, dp);
		main.lectureSolution(n, dp);
		
		for (int i = 1; i <= n; i++) {
			System.out.print(dp[i] + " ");
		}
	}
	
	private int lectureSolution(int n, int[] dp) {
		if (dp[n] > 0) {
			return dp[n];
		}
		if (n == 1 || n == 2) {
			return dp[n] = 1;
		}
		return dp[n] = lectureSolution(n - 1, dp) + lectureSolution(n - 2, dp);
	}
	
	private int mySolution(int n, int[] dp) {
		if (dp[n] > 0) {
			return dp[n];
		}
		if (n == 1 || n == 2) {
			dp[n] = 1;
			return 1;
		}
		dp[n] = mySolution(n - 1, dp) + mySolution(n - 2, dp);
		return dp[n];
	}
}
