package dynamic_programming.가장_높은_탑_쌓기;

import java.util.*;

class Brick implements Comparable<Brick> {
	int bottomSize, height, weight;
	
	Brick(int bottomSize, int height, int weight) {
		this.bottomSize = bottomSize;
		this.height = height;
		this.weight = weight;
	}
	
	boolean isPossible(Brick prevBrick) {
		if (this.bottomSize > prevBrick.bottomSize) {
			return false;
		}
		if (this.weight > prevBrick.weight) {
			return false;
		}
		return true;
	}
	
	@Override
	public int compareTo(Brick b) {
		return b.bottomSize - this.bottomSize;
	}
}

public class Main {
	static int[] dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		final int n = sc.nextInt();
		dp = new int[n];
		Brick[] arr = new Brick[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		
		System.out.println(main.mySolution(n, arr));
	}
	
	/*
	10
	114 96 290
	65 74 201
	261 19 105
	181 60 275
	90 145 254
	286 118 64
	16 24 205
	288 128 299
	96 36 74
	182 5 35
	*/
	private int mySolution(final int n, Brick[] bricks) {
		Arrays.sort(bricks);
		int answer = 0;
		dp[0] = bricks[0].height;
		
		for (int i = 1; i < n; i++) {
			int curMaxHeight = 0;
			for (int j = 0; j < i; j++) {
				if (bricks[i].isPossible(bricks[j])) {
					curMaxHeight = Math.max(dp[j], curMaxHeight);
				}
			}
			dp[i] = curMaxHeight + bricks[i].height;
			answer = Math.max(dp[i], answer);
		}
		return answer;
	}
}
