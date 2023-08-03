package stack_and_queue.후위식_연산;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main m = new Main();

//        System.out.println(m.mySolution(sc.next()));
        System.out.println(m.lectureSolution(sc.next()));
    }

    private int lectureSolution(String str) {
        Stack<Integer> stack = new Stack<>();
        for(char x: str.toCharArray()) {
            if(Character.isDigit(x))  {
                stack.push(x - 48); // x - '0'도 가능;
            }else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(x == '+') stack.push(lt + rt);
                else if(x == '-') stack.push(lt - rt);
                else if(x == '*') stack.push(lt * rt);
                else if(x == '/') stack.push(lt / rt);
            }
        }

        return stack.pop();
    }

    private String mySolution(String str) {
        LinkedList<String> stack = new LinkedList<>();

        for (char x : str.toCharArray()) {
            if (Character.isDigit(x)) {
                stack.push(String.valueOf(x));
                continue;
            }

            int numA = Integer.parseInt(stack.pop());
            int numB = Integer.parseInt(stack.pop());

//            System.out.println("numA:" + numA + " numB:" + numB);
            switch (x) {
                case '+':
                    stack.push(String.valueOf(numA + numB));
                    break;
                case '-':
                    stack.push(String.valueOf(numB - numA));
                    break;
                case '*':
                    stack.push(String.valueOf(numB * numA));
                    break;
                case '/':
                    stack.push(String.valueOf(numB / numA));
                    break;

            }


        }

        return stack.pop();
    }
}
