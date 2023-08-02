package Stack_Queue.공주_구하기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(main.mySolution(sc.nextInt(), sc.nextInt()));
    }

    private int lectureSolution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();

        for(int i = 1; i <= n; i++) Q.offer(1);
        while(!Q.isEmpty()) {
            for(int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll();
            if(Q.size() == 1) answer = Q.poll();
        }

        return answer;
    }

    private int mySolution(int n, int k) {
        LinkedList<Integer> circleQueue = new LinkedList<>();
        int cnt = 0;
        for(int i = 1; i <= n; i++) {
            circleQueue.addLast(i);
        }

        while(circleQueue.size() > 1) {
            ++cnt;
            int target = circleQueue.pop();
            // 퇴출할 사람.
            if( cnt == k) {
                cnt = 0;
            }else {
                circleQueue.addLast(target);
            }
        }
        return circleQueue.pop();
    }
}
