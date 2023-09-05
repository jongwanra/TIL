package dynamic_programming.동전교환_냅색_알고리즘;

import java.util.*;

public class LectureMain {
	static int n, m;
	static int[] dy;
	
	public static void main(String[] args) {
		LectureMain T = new LectureMain();
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		m = sc.nextInt();
		dy = new int[m + 1];
		System.out.println(T.solution(arr));
	}
	
	private int solution(int[] coins) {
		Arrays.fill(dy, 501);
		dy[0] = 0;
		
		for (int coin : coins) {
			for (int i = coin; i <= m; i++) {
				dy[i] = Math.min(dy[i], dy[i - coin] + 1);
			}
		}
		return dy[m];
	}
}
