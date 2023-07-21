package string.문자_찾기;

import java.util.Scanner;

// 문제 접근
// 전체를 대문자로 변경
// target역시 대문자로 변경
// 비교 후 출력
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner in = new Scanner(System.in);
        String input1 = in.next();
        String input2 = in.next();
        System.out.println(main.mySolution(input1, input2));
        System.out.println(main.lectureSolution(input1, input2.charAt(0)));
    }

    private int lectureSolution(String str, char t) {
        int answer = 0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);

        /*
            for(int i = 0; i < str.length(); i++){
                if(str.charAt(i) == t) {
                    answer++;
                }
            }
        */

        for (char x : str.toCharArray()) {
            if (x == t) {
                answer++;
            }
        }
        return answer;
    }

    private int mySolution(String string, String target) {
        String upperString = string.toUpperCase();
        char upperTarget = target.toUpperCase().charAt(0);
        int count = 0;
        for (int idx = 0; idx < upperString.length(); idx++) {
            if (upperString.charAt(idx) == upperTarget) {
                count++;
            }
        }

        return count;
    }
}

