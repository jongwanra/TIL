package dfs_and_bfs.재귀함수를_이용한_이진수_출력;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		System.out.println(main.mySolution(sc.nextInt()));
	}
	
	private void lectureDfs(int n) {
		if (n == 0) {
			return;
		}
		lectureDfs(n / 2);
		System.out.print(n % 2);
	}
	
	private StringBuilder myDfs(int n, StringBuilder sb) {
		if (n == 1) {
			sb.append(1);
			return sb;
		}
		int mod = n % 2;
		sb.append(mod);
		return myDfs(n / 2, sb);
	}
	
	private String mySolution(int n) {
		StringBuilder sb = new StringBuilder();
		return myDfs(n, sb).reverse().toString();
	}
}
