package stack_and_queue.쇠막대기;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(m.mySolution(sc.next()));
    }

    private int lectureSolution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) == '(') {
                stack.push('(');
            }else {

                stack.pop();
                // 레이저인 경우
                if(str.charAt(i - 1) == '(') {
                    answer += stack.size();
                }else {
                // 막대기인 경우
                    answer++;
                }
            }

        }
        return answer;
    }

    /*
     * count를 사용해서 현재 포함된 막대의 갯수를 기억
     * '(', ')' 기호가 연속으로 나오면 자르기
     * '(' 기호만 나오면 나오면 ++
     * ')' 기호가 나오면 '(' 한개  --
     * 마지막 레이저 했을 시점을 기억해두기
     * */
    private int mySolution(String str) {
        int answer = 0;
        int cnt = 0;
        int len = str.length();
        for(int i = 0; i < len; i++ ) {
            /* 레이저 인 경우*/
            if(i + 1 < len && str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
                answer += cnt;
                i++;
                continue;
            }

            if(str.charAt(i) == '(') {
                cnt++;
            }else{
                answer++;
                cnt--;
            }
        }
        return answer;
    }
}
