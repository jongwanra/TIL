package dfs_and_bfs.중복순열;

import java.util.*;

public class Main {
	static int n;
	static int m;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		int[] selectedNum = new int[m];
		main.myDfs(0, selectedNum);
	}
	
	private void myDfs(int depth, int[] selectedNum) {
		if (depth == m) {
			for (int x : selectedNum) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= n; i++) {
			selectedNum[depth] = i;
			myDfs(depth + 1, selectedNum);
		}
		
	}
}
