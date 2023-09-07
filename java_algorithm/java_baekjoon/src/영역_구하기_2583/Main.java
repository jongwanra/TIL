package 영역_구하기_2583;
import java.util.*;



/*
*
* 문제 접근
* DFS로 풀자
* 0인 곳을 차례대로 공략하면서 풀면 될 듯
* */
public class Main {
	static int[] dh = {-1, 0, 1, 0 };
	static int[] dw = { 0, 1, 0, -1};
	static int h,w; // 100이하의 자연수
	static int curCount = 0;
	static int[][] board;
	public static void main(String[] args) {
		Main main = new Main();
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		board = new int[h + 1][w + 1];
		final int k = sc.nextInt();
		for(int loop = 0; loop < k; loop++) {
			final int lbx = sc.nextInt();
			final int lby = sc.nextInt();
			final int rtx = sc.nextInt();
			final int rty = sc.nextInt();
			
			for(int row = rty; row > lby; row--){
				for(int col = lbx + 1; col <= rtx; col++) {
					board[row][col] = 1;
				}
			}
		}
		
		
		// for(int row = 1; row <= h; row++) {
		// 	for(int col = 1; col <= w; col++) {
		// 		System.out.print(board[row][col] + " ");
		// 	}
		// 	System.out.println();
		// }
		
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int row = 1; row <= h; row++) {
			for(int col = 1; col <= w; col++) {
				if(board[row][col] == 0) {
					curCount = 0;
					answer++;
					main.dfs(row, col);
					list.add(curCount);
				}
			}
		}
		
		System.out.println(answer);
		Collections.sort(list);
		for(int x: list){
			System.out.print(x + " ");
		}
	}
	
	private void dfs(final int curH, final int curW) {
		board[curH][curW] = 1;
		curCount++;
		
		for(int loop = 0; loop < 4; loop++) {
			final int nh = curH + dh[loop];
			final int nw = curW + dw[loop];
			if(nh <= 0 || nh > h || nw <= 0 || nw > w) {
				continue;
			}
			if(board[nh][nw] == 1){
				continue;
			}
			
			dfs(nh, nw);
		}
	}
}
