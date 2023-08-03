package N_10757;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.solutionNotUseClass(sc.next(), sc.next()));
    }


    /*
    * numA, numB => Stack 자료구조로 만듬
    * pop()을 사용하면서 더해가기
    * */
    private String solutionNotUseClass(String numA, String numB) {
        LinkedList<Character> stackA = new LinkedList<>();
        LinkedList<Character> stackB = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(char x: numA.toCharArray()) stackA.push(x);
        for(char x: numB.toCharArray()) stackB.push(x);

        int carry = 0;
        while(!stackA.isEmpty() && !stackB.isEmpty()) {
            int tmpA = stackA.pop() - '0';
            int tmpB = stackB.pop() - '0';
            int sum = tmpA + tmpB + carry;
            carry = sum / 10;
            sb.append(sum % 10);

        }

        while(!stackA.isEmpty()) {
            int tmpA = stackA.pop() - '0';
            int sum = tmpA + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        while(!stackB.isEmpty()) {
            int tmpB = stackB.pop() - '0';
            int sum = tmpB + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        if(carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }

    private String solution(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        return numA.add(numB).toString();
    }
}
