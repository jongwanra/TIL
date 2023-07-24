package string.암호;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println( main.mySolution(sc.nextInt(), sc.next()));
    }

    private String lectureSolution(int n, String s) {
        String answer = "";

        for (int i = 0; i < n; i++) {
            String tmp = s.substring(0, 7)
                    .replace("#", "1")
                    .replace("#", "0");
            int num = Integer.parseInt(tmp, 2);
            answer += (char) num;
            s =s.substring(7);
        }
        return answer;
    }

    private String mySolution(int n, String s) {
        StringBuilder answerSB = new StringBuilder();
        for(int i = 0; i < s.length(); i+=7) {
            String target = s.substring(i, i + 7);
            StringBuilder sb = new StringBuilder();
            for(char t: target.toCharArray()){
                if(t == '#'){
                    sb.append('1');
                }else {
                    sb.append('0');
                }
            }
            String decodedBinary = sb.toString();
            // 2진수인 decodedBinary를 10진수로 변환
            int parsed = Integer.parseInt(decodedBinary, 2);
            answerSB.append((char) parsed);
        }
        return answerSB.toString();
    }
}
