package string.가장_짧은_문자거리;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
//        int[] answer = main.mySolution(sc.next(), sc.next().charAt(0));
        int[] answer = main.lectureSolution(sc.next(), sc.next().charAt(0));

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
        System.out.println();
    }


    /*
    * 강의에서 최단 거리를 구할때
    * 우선, 각 왼쪽 target기준으로의 거리를 구한다.
    * 그 이후에, 각 오른쪽 target기준으로의 거리를 구한다.(기존 거리와의 최소값으로 채운다)
    * */
    private int[] lectureSolution(String s, char t)   {
        int[] answer = new int[s.length()];
        int p = 1000;
        for(int i = 0; i < s.length(); i++) {
            p = s.charAt(i) == t ? 0: p + 1;
            answer[i] = p;
        }

        p = 1000;
        for(int i = s.length() - 1; i >= 0; i--){
            p = s.charAt(i) == t ? 0: p + 1;
            answer[i] = Math.min(p, answer[i]);
        }
        return answer;
    }

    /*
    * 순회하면서 e를 찾는다
    * 찾은 e에서 의 최소 거리를 덮는다.
    * */
    private int[] mySolution(String str, char w) {
        int[] answer = new int[str.length()];
        Arrays.fill(answer, Integer.MAX_VALUE);

        for (int idx = 0; idx < str.length(); idx++) {
            char target = str.charAt(idx);
            if (target != w) {
                continue;
            }

            for (int i = 0; i < answer.length; i++) {
                answer[i] = Math.min(answer[i], Math.abs(idx - i));
            }
        }
        return answer;
    }
}
