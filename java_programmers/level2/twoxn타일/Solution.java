package level2.twoxn타일;

import java.sql.Array;
import java.util.ArrayList;

public class Solution {
    public int solution(int n) {
        int[] dp = new int[60003];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 5;

        for(int loop = 5; loop <= n; loop++) {
            dp[loop] = (dp[loop - 1] + dp[loop -2]) % 1000000007;
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(5));
    }
}
