package level1.나머지가_1이_되는_수_찾기;


import java.util.OptionalInt;
import java.util.stream.IntStream;

// 문제 접근
// 반복문을 2부터 돌면서, 나머지가 1인 수를 반환하자.
public class Solution {
    public int solution(int n) {
        for(int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1;
    }


    // 문제 접근: stream
    public int solutionByStream(int n ){
        return IntStream.range(2, n)
                .filter(v -> n % v == 1)
                .findFirst()
                .orElse(1);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solutionByStream(12));
    }
}
