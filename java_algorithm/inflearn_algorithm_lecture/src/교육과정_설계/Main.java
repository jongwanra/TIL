package 교육과정_설계;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        System.out.println(main.mySolution(sc.next(), sc.next()));
        System.out.println(main.lectureSolution(sc.next(), sc.next()));
    }

    private String lectureSolution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for(char x: need.toCharArray()) Q.offer(x);
        for(char x: plan.toCharArray()) {
            if(Q.contains(x)){
                if(x != Q.poll()) return "NO";
            }
        }

        if(!Q.isEmpty()) return "NO";
        return answer;
    }

    private String mySolution(String s1, String s2) {
        Queue<Character> queue = new LinkedList<>();

        for(char x: s1.toCharArray()) queue.offer(x);

        for(char x: s2.toCharArray()) {
            if(queue.isEmpty()) {
                break;
            }
            char compareTo = queue.peek();
            if(x == compareTo) {
                queue.poll();
            }
        }
        return (queue.isEmpty()) ? "YES" : "NO";
    }
}
