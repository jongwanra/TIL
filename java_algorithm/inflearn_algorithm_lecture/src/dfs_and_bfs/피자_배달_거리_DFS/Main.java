package dfs_and_bfs.피자_배달_거리_DFS;

import java.util.*;

// 조합은 무조건 외우자...!
class Point {
	int row;
	int col;
	
	Point(final int row, final int col) {
		this.row = row;
		this.col = col;
	}
	
	@Override
	public String toString() {
		return "row :"
			+ row
			+ " col: "
			+ col;
	}
}

public class Main {
	static int n;
	static int m;
	static int answer = Integer.MAX_VALUE;
	static int[] combi;
	static ArrayList<Point> houses;
	static ArrayList<Point> pizzaHouses;
	
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		houses = new ArrayList<>();
		pizzaHouses = new ArrayList<>();
		combi = new int[n];
		
		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= n; col++) {
				int target = sc.nextInt();
				if (target == 1) {
					houses.add(new Point(row, col));
				} else if (target == 2) {
					pizzaHouses.add(new Point(row, col));
				}
			}
		}
		//
		
		main.myDfs(0, 0);
		System.out.println(answer);
		
	}
	
	private void myDfs(final int depth, final int startIdx) {
		if (depth == m) {
			int total = 0;
			for (Point house : houses) {
				int dis = Integer.MAX_VALUE;
				for (int x : combi) {
					Point target = pizzaHouses.get(x);
					dis = Math.min(dis, getDistance(house.row, house.col, target.row, target.col));
				}
				total += dis;
			}
			answer = Math.min(answer, total);
			
			for (int x : combi) {
				System.out.print(x + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = startIdx; i < pizzaHouses.size(); i++) {
			combi[depth] = i;
			myDfs(depth + 1, i + 1);
		}
		
	}
	
	private int getDistance(final int r1, final int c1, final int r2, final int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}
