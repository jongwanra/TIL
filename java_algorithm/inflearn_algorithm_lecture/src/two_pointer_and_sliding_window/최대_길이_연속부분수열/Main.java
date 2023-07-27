package two_pointer_and_sliding_window.최대_길이_연속부분수열;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt(); // 0을 1로 변경할 수 있는 cnt
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.mySolution(n, k, arr));
    }

    private int lectureSolution(int n, int k, int[] arr) {
        int answer = 0, cnt = 0, lt = 0;
        for(int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) cnt++;
            while(cnt > k) {
                if(arr[lt] == 0) cnt--;
                lt++;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
    private int mySolution(int n, int k, int[] arr) {
        LinkedList<Integer> queue = new LinkedList<>();
        int answer = 0;
        int lt = 0, kCnt = 0;
        for (int rt = 0; rt < n; rt++) {
            if(arr[rt] == 0) {
                queue.add(rt);
                kCnt++;
            }
            if(kCnt > k) {
                lt = queue.pop() + 1;
                kCnt--;
            }
            answer = Math.max(answer, rt - lt + 1);
        }
        return answer;
    }
}
