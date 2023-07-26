package two_pointer_and_sliding_window.연속_부분수열;
import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();

        int n = sc.nextInt(), targetNum = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(main.mySolution(n, targetNum, arr));

    }

    private int lectureSolution(int n , int m, int[] arr) {
        int answer =0, sum=0, lt=0;
        for(int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if(sum == m) answer++;

            while (sum >= m) {
                sum -= arr[lt++];
                if( sum == m) answer++;
            }
        }

        return answer;
    }
    private int mySolution(int n, int targetNum, int[] arr) {
        int answer = 0;
        int lp = 0, rp = 1;
        int sum = arr[lp];

        while(rp < n) {
            if (sum == targetNum) {
                answer++;
                sum += arr[rp++];
            }else if(sum > targetNum) {
                sum -= arr[lp++];
            }else {
                sum += arr[rp++];
            }
        }

        if(sum == targetNum) {
            answer++;
        }

        return answer;
    }
}
