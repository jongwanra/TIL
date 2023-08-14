// 해결 못함(23.08.14) -> 강의 해설 보고 이해된 상태

package dfs_and_bfs.합이_같은_부분집합;

import java.util.*;

public class Main {
	static int n;
	static int[] arr;
	static String answer = "NO";
	static int total;
	private boolean flag = false;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
		}
		
		main.myDfs230814(0, 0);
		System.out.println(answer);
	}
	
	private void myDfs230814(final int sum, final int depth) {
		if (depth == n) {
			if (total - sum == sum) {
				answer = "YES";
				return;
			}
			return;
		}
		
		if (answer.equals("YES")) {
			return;
		}
		
		myDfs230814(sum, depth + 1);
		myDfs230814(sum + arr[depth], depth + 1);
	}
	
	private void lectureDfs(int L, int sum, int[] arr) {
		if (flag) {
			return;
		}
		if (sum > total / 2) {
			return;
		}
		if (L == n) {
			if ((total - sum) == sum) {
				answer = "YES";
				flag = true;
			}
		} else {
			lectureDfs(L + 1, sum + arr[L], arr);
			lectureDfs(L + 1, sum, arr);
		}
	}
}
