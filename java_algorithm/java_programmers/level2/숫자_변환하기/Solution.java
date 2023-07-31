package level2.숫자_변환하기;


import java.util.Arrays;

// 접근 방법
// bottom-top 방식으로 DP를 가져가자
// 계수로 값을 최소한으로 가진 경우의수로 가면 될 것 같다.
public class Solution {
    public int solution(int x, int y, int n) {
        final int INF = 1000001;
        int[] dp = new int[10000001];
        Arrays.fill(dp, INF);

        dp[x] = 0;
        for(int i = x; i < y; i++) {
            int distance = dp[i] + 1;
            dp[i + n] = Math.min(distance, dp[i+n]);
            dp[i * 2] =  Math.min(distance, dp[i* 2]);
            dp[i * 3] =  Math.min(distance, dp[i * 3]);
        }

        if(dp[y] == INF) {
            return -1;
        }

        return dp[y];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(10, 10, 5));
    }
}
