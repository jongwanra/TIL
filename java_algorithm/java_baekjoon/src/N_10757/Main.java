package N_10757;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.solution(sc.next(), sc.next()));
    }

    private String solution(String num1, String num2) {
        BigInteger numA = new BigInteger(num1);
        BigInteger numB = new BigInteger(num2);
        return numA.add(numB).toString();
    }
}
