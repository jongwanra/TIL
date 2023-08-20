package dfs_and_bfs.수열_추측하기;

import java.util.*;

public class Main {
	static boolean[] visited;
	static int[] combinationCases;
	static int[] answers;
	static boolean isCompleted = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		final int target = sc.nextInt();
		visited = new boolean[n + 1];
		answers = new int[n];
		combinationCases = new int[n];
		
		for (int i = 0; i < n; i++) {
			combinationCases[i] = main.factorial(n - 1) / (main.factorial(n - 1 - i) * main.factorial(i));
		}
		
		main.myDfs230820(n, target, 0, 0);
	}
	
	private int factorial(int n) {
		int sum = 1;
		for (int i = 2; i <= n; i++) {
			sum *= i;
		}
		return sum;
	}
	
	private void myDfs230820(final int n, final int target, final int sum, final int depth) {
		if (isCompleted) {
			return;
		}
		
		if (depth == n) {
			if (target == sum) {
				isCompleted = true;
				for (int x : answers) {
					System.out.print(x + " ");
				}
			}
			return;
		}
		
		if (target < sum) {
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			// 해당 숫자를 이미 사용했는지 여부 -> visited
			if (visited[i]) {
				continue;
			}
			visited[i] = true;
			answers[depth] = i;
			myDfs230820(n, target, sum + (combinationCases[depth] * i), depth + 1);
			visited[i] = false;
			
		}
		
	}
	
}
