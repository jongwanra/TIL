package dynamic_programming.최대_부분_증가수열;

import java.util.*;

public class Main {
	static int[] arr;
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		final int n = sc.nextInt();
		
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		dp = new int[n];
		Main main = new Main();
		
		System.out.println(main.solution(n));
	}
	
	private int solution(final int n) {
		int answer = Integer.MIN_VALUE;
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			int curMaxLen = 0;
			for (int j = 0; j < i; j++) {
				// 나보다 값이 작은 지 먼저 체크
				if (arr[i] > arr[j]) {
					curMaxLen = Math.max(dp[j], curMaxLen);
				}
			}
			dp[i] = curMaxLen + 1;
			answer = Math.max(answer, curMaxLen + 1);
		}
		return answer;
	}
}
