package string.문장_속_단어;

import java.util.*;
public class Main {

    // indexOf
    private String lectureSolution2(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();

            if(len > m) {
                m=len;
                answer = tmp;
            }
            str = str.substring(pos + 1);
        }
        if(str.length() > m) {
            answer = str;
        }
        return answer;
    }

    // splited
    private String lectureSolution(String str) {
        String answer = "";
        int m = Integer.MIN_VALUE;
        String[] s = str.split(" ");

        for(String x: s) {
            int len = x.length();
            if(len > m) {
                m= len;
                answer = x;
            }
        }
        return answer;
    }
    private String mySolution(String str) {
        int maxIdx = 0;
        String[] splited = str.split(" ");

        for(int idx = 1; idx < splited.length; idx++) {
            if (splited[maxIdx].length() < splited[idx].length()) {
                maxIdx = idx;
            }
        }

        return splited[maxIdx];
    }
    public static void main(String[] args){
        Main main = new Main();
        Scanner in=new Scanner(System.in);
        String input = in.nextLine();
        System.out.println(main.mySolution(input));
    }
}
