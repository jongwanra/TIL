package Stack_Queue.괄호문자제거;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

        System.out.println(m.mySolution(sc.next()));
        System.out.println(m.lectureSolution(sc.next()));
    }

    private String lectureSolution(String str) {
        Stack<Character> stack = new Stack<>();
        String answer = "";
        for(char x: str.toCharArray()) {
            if(x == ')') {
                while(stack.pop() != '(');
            }else {
                stack.push(x);
            }
        }

        for(int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return null;
    }


    /*
     * 문제 접근
     * 순회를 한다
     * 괄호가 열려있을 경우 에는 전부 버림.
     * 닫힐 경우 전부 추가
     * 소괄호 열림에 관한 Stack을 만들자
     *
     * */
    private String mySolution(String str) {
        LinkedList<Character> stack = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : str.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    stack.pop();
                    break;
                default:
                    if (stack.isEmpty()) {
                        sb.append(ch);
                    }
            }


        }
        return sb.toString();
    }
}
