package dynamic_programming.계단오르기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		final int n = sc.nextInt();
		
		System.out.println(main.mySolution(n));
		
	}
	
	// 전 수와 전전 수의 합이 답이다
	private int mySolution(final int n) {
		ArrayList<Integer> list = new ArrayList<>(n + 1);
		list.add(0);
		list.add(1);
		list.add(2);
		
		for (int i = 3; i <= n; i++) {
			list.add(list.get(i - 1) + list.get(i - 2));
		}
		return list.get(n);
	}
}
