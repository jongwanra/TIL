package string.회문문자열;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(main.mySolution(sc.next()));
        System.out.println(main.lectureSolution(sc.next()));
    }

    private String lectureSolution2(String str) {
        String answer = "NO";
        String tmp = new StringBuilder(str).reverse().toString();

        if( str.equalsIgnoreCase(tmp)) {
            answer = "YES";
        }
        return answer;
    }

    private String lectureSolution(String str) {
        String answer = "YES";
        str = str.toUpperCase();
        int len = str.length();
        for(int i =0; i< len/2; i++) {
            if(str.charAt(i) != str.charAt(len - 1 - i)) {
                return "NO";
            }
        }
        return answer;
    }

    /*
    * str 문자를 뒤집어서 생성 후
    * equals method로 체크
    * */
    private String mySolution(String str) {
        String upperStr = str.toUpperCase();
        String reversedUpperStr = new StringBuilder(str).reverse().toString().toUpperCase();

        return upperStr.equals(reversedUpperStr) ? "YES": "NO";
    }
}
