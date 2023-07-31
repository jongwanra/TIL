package level1.약수의_개수와_덧셈;


import java.util.stream.IntStream;

// 문제 접근
// 약수의 갯수를 체크하지만 우선 이 갯수가 짝수인지 홀수 인지가 중요
// 제곱근 까지 돌았을 때 해당 갯수도 파악이 가능할까?!




// 이 문제를 통해 안 부분.
// 제곱수인 경우 약수의 갯수가 홀수
// 제곱수가 아닌 경우 약수의 갯수가 짝수
public class Solution {

    private boolean divisorNumIsEven(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count % 2 == 0;
    }
    public int solution(int left, int right) {
        return IntStream.range(left, right + 1)
                .map(v -> this.divisorNumIsEven(v) ? v : -v)
                .sum();
    }


    public int solution2(int left, int right) {
        return IntStream.range(left, right + 1)
                .map(v -> v % Math.sqrt(v) == 0  ? -v : v)
                .sum();
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(24, 27));
    }
}
