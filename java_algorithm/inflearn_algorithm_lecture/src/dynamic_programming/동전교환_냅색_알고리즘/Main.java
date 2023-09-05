package dynamic_programming.동전교환_냅색_알고리즘;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		final int totalFee = sc.nextInt();
		
		System.out.println(main.mySolution(arr, n, totalFee));
		
	}
	
	private int mySolution(int[] coinTypes, final int n, final int totalFee) {
		int[] dp = new int[totalFee + 1];
		
		for (int coinType : coinTypes) {
			dp[coinType] = 1;
		}
		
		for (int i = 1; i < totalFee; i++) {
			if (dp[i] == 0) {
				continue;
			}
			for (int coinType : coinTypes) {
				if (i + coinType > totalFee) {
					continue;
				}
				if (dp[i + coinType] == 0 || dp[i + coinType] > dp[i] + 1) {
					dp[i + coinType] = dp[i] + 1;
				}
			}
		}
		
		// for (int x : dp) {
		// 	System.out.print(x + " ");
		// }
		// System.out.println();
		return dp[totalFee];
	}
}
