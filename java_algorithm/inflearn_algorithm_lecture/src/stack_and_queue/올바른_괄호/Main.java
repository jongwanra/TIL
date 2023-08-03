package stack_and_queue.올바른_괄호;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println(m.mySolution(sc.next()));
        System.out.println(m.lectureSolution(sc.next()));
    }

    private String lectureSolution(String str) {
        Stack<Character> stack = new Stack<>();

        for(char x: str.toCharArray()) {
            if(x == '(') {
                stack.push('(');
            }else {
                if(stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        return stack.isEmpty() ? "YES" : "NO";
    }

    private String mySolution(String s) {
        String answer = "NO";
        LinkedList<Character> stack = new LinkedList<>();

        for(char x: s.toCharArray()) {
            if(x == '(') {
                stack.push('(');
                continue;
            }
            // ')'인 경우
            if(stack.size() == 0) {
                return answer;
            }
            stack.pop();
        }

        return stack.size() > 0 ? "NO" : "YES";
    }


}
