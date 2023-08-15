package dfs_and_bfs.최대점수_구하기_DFS;

import java.util.*;

class Problem {
	final int score;
	final int time;
	
	Problem(final int score, final int time) {
		this.score = score;
		this.time = time;
	}
}

public class Main {
	static int answer;
	static int n;
	static int limitedTime;
	static Problem[] arr;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		limitedTime = sc.nextInt();
		
		arr = new Problem[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new Problem(sc.nextInt(), sc.nextInt());
		}
		
		main.myDfs(0, 0, 0);
		System.out.println(answer);
	}
	
	private void myDfs(final int depth, final int totalTime, final int totalScore) {
		if (totalTime > limitedTime) {
			return;
		}
		
		if (depth == n) {
			answer = Math.max(answer, totalScore);
			return;
		}
		
		myDfs(depth + 1, totalTime + arr[depth].time, totalScore + arr[depth].score);
		myDfs(depth + 1, totalTime, totalScore);
		
	}
}
