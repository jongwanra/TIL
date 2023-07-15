package level1.문자열을_정수로_바꾸기;

// 문제 접근
// s[0]이 '+' or '-'인지 체크 후 접근

public class Solution {
    public int solution(String s) {
        if ((s.charAt(0) != '+') && (s.charAt(0) != '-')) {
            return Integer.valueOf(s);
        }
        int answer = Integer.valueOf(s.substring(1));
        if (s.charAt(0) == '-') {
            answer = answer * -1;
        }
        return answer;
    }

    public int solution2(String s) {
        return Integer.valueOf(s);
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("-1234"));

    }
}
