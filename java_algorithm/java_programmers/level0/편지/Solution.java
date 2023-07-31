package level0.편지;

public class Solution {
    public int solution(String message) {
        return message.length() * 2;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("happy birthday!");

    }
}
