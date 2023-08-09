package dfs_and_bfs.팩토리얼;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		System.out.println(main.mySolution(sc.nextInt()));
	}
	
	private int mySolution(int n) {
		if (n == 1) {
			return 1;
		}
		return n * mySolution(n - 1);
	}
}
