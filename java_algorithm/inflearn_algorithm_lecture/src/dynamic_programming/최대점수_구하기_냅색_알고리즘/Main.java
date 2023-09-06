package dynamic_programming.최대점수_구하기_냅색_알고리즘;

import java.util.*;

class Problem {
	int score, time;
	
	Problem(int score, int time) {
		this.score = score;
		this.time = time;
	}
}

public class Main {
	static int n, limitedTime;
	static int[] dy;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main main = new Main();
		
		n = sc.nextInt();
		limitedTime = sc.nextInt();
		Problem[] problems = new Problem[n];
		
		for (int i = 0; i < n; i++) {
			problems[i] = new Problem(sc.nextInt(), sc.nextInt());
		}
		
		System.out.println(main.solution(problems));
		
	}
	
	private int solution(Problem[] problems) {
		dy = new int[limitedTime + 1];
		
		for (Problem p : problems) {
			for (int i = limitedTime; i >= p.time; i--) {
				dy[i] = Math.max(dy[i], dy[i - p.time] + p.score);
			}
		}
		
		// for (int x : dy) {
		// 	System.out.print(x + " ");
		// }
		// System.out.println();
		return dy[limitedTime];
	}
	
}
