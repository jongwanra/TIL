package level0.특정_문자_제거하기;

public class Solution {

    public String solution(String my_string, String letter) {
        return my_string.replaceAll(letter, "");
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("BCBdbe", "B"));
    }
}
