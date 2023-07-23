package string.문자열_압축;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println(main.mySolution(sc.next()));

    }

    private String lectureSolution(String s) {
        String answer = "";
        s = s + " ";
        int cnt = 1;
        for(int i = 0; i < s.length() - 1; i++){
            if(s.charAt(i) == s.charAt(i + 1)) cnt++;
            else {
                answer += s.charAt(i);
                if( cnt > 1) {
                    answer += String.valueOf(cnt);
                }
                cnt = 1;
            }
        }
        return answer;
    }


    /*
    * 1번 순회
    * target 지정 이후 뒤에 카운트 만큼 세기
    * KKHSSSSSSSE
    * */

    private String mySolution(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int idx = 0;
        while (idx < len) {
            char target =str.charAt(idx);
            sb.append(target);
            int count = 1;
            while(idx + 1 < len && target == str.charAt(idx + 1)) {
                idx++;
                count++;
            }
            if (count > 1) {
                sb.append(count);
            }
            idx++;
        }
        return sb.toString();
    }
}
