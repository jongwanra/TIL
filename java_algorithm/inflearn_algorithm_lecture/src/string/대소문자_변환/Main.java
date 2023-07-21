package string.대소문자_변환;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Main main = new Main();
        Scanner in=new Scanner(System.in);
        String input = in.next();
        System.out.println(main.mySolution(input));
        System.out.println(main.lectureSolution(input));
    }

    // 접근 방법
    // 아스키 코드로 비교해서 높여주는 방법

    private String mySolution(String str) {
        char[] newChars = new char[str.length()];

        for(int idx = 0; idx < str.length(); idx++) {
            char target = str.charAt(idx);
            if (target >= 'A' && target <= 'Z') {
                newChars[idx] = Character.toLowerCase(target);
                continue;
            }
            newChars[idx] = Character.toUpperCase(target);
        }
        return String.valueOf(newChars);
    }

    private String lectureSolution(String str) {
        String answer = "";
        for(char x: str.toCharArray()) {
            if(Character.isLowerCase(x)) {
                answer += Character.toUpperCase(x);
            }else {
                answer += Character.toLowerCase(x);
            }
        }
        return answer;
    }


    // ASCII
    private String lectureSolution2(String str) {
        String answer = "";
        for(char x: str.toCharArray()) {
            if(x >= 65 && x <= 90) {
                answer += (char)(x - 32);
            }else {
                answer += (char)(x + 32);
            }
        }
        return answer;
    }

}
