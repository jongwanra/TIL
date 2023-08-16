package dfs_and_bfs.동전교환;

import java.util.*;

public class Main {
	static int n;
	static int m;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		final int n = sc.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		final int maxAcc = sc.nextInt();
		
		System.out.println(main.myBfs(maxAcc, coins));
		
	}
	
	private int myBfs(final int maxAcc, int[] coins) {
		final int maxDepth = maxAcc / Arrays.stream(coins).min().getAsInt();
		Queue<Integer> queue = new LinkedList<>();
		for (int x : coins) {
			queue.offer(x);
		}
		int depth = 0;
		
		while (!queue.isEmpty()) {
			depth++;
			final int curSize = queue.size();
			for (int i = 0; i < curSize; i++) {
				final int cur = queue.poll();
				
				if (cur == maxAcc || depth == maxDepth) {
					return depth;
				}
				
				for (int x : coins) {
					queue.offer(cur + x);
				}
			}
			
		}
		
		return 0;
	}
	
	private void lectureDfs(int L, int sum, Integer[] arr) {
		if (sum > m) {
			return;
		}
		if (L >= answer) {
			return;
		}
		
		Arrays.sort(arr, Collections.reverseOrder());
		
		if (sum == m) {
			answer = Math.min(answer, L);
		} else {
			for (int i = 0; i < n; i++) {
				lectureDfs(L + 1, sum + arr[i], arr);
			}
		}
		
	}
}
