package dynamic_programming.돌다리_건너기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		System.out.println(main.mySolution(sc.nextInt()));
	}
	
	private int mySolution(final int n) {
		int[] dy = new int[n + 1];
		dy[1] = 2;
		dy[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			dy[i] = dy[i - 1] + dy[i - 2];
		}
		return dy[n];
	}
}
