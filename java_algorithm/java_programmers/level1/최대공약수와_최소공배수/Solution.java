package level1.최대공약수와_최소공배수;

import java.sql.Array;

public class Solution {

    // 최대 공약수(유클리드 호제법)
    // a % b의 최대공약수는 b % (a % b)와 같다.
    private int gcd(int a, int b) {
        if (b > a) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        while(a % b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return b;
    }
    public int[] solution(int n, int m) {
        int gcd = gcd(n, m);
        int lcm = (n * m) / gcd;

        return new int[]{gcd, lcm};
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(1071, 1029));
    }
}
