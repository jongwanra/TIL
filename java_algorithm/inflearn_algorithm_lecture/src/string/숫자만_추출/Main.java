package string.숫자만_추출;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(main.mySolution(sc.next()));
    }

    private int lectureSolution2(String s) {
        String answer = "";
        for(char x: s.toCharArray()) {
            if (Character.isDigit(x)) {
                answer += x;
            }
        }
        return Integer.parseInt(answer);
    }

    private int lectureSolution(String s) {
        int answer = 0;
        for(char x: s.toCharArray()) {
            if( x>= 48 && x <= 57) {
                answer = answer * 10 + (x - 48);
            }
        }
        return answer;
    }
    /*
    * 문제 접근
    * replaceAll로 통해서 숫자만 추출
    * Integer로 변경 후 다시 String으로 변경
    * */
    private String mySolution(String str) {
        str = str.replaceAll("[^0-9]", "");
        return String.valueOf(Integer.valueOf(str));
    }
}
