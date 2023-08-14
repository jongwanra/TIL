package dfs_and_bfs.바둑이_승차;

import java.util.*;

public class Main {
	static int answer = 0;
	static int c;
	static int n;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		c = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		main.myDfs(0, 0);
		System.out.println(answer);
		
	}
	
	private void myDfs(int sum, int depth) {
		// c킬로그램 넘게 태웠을 경우
		if (sum > c) {
			return;
		}
		if (n == depth) {
			answer = Math.max(answer, sum);
			return;
		}
		
		myDfs(sum + arr[depth], depth + 1);
		myDfs(sum, depth + 1);
	}
}
