package two_pointer_and_sliding_window.연속된_자연수의_합;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n =  sc.nextInt();

        System.out.println(main.mySolution(n));

    }

    private int lectureSolution(int n) {
        int answer = 0, sum = 0, lt = 0;
        int m = n/ 2 + 1;

        int[] arr = new int[m];

        for(int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for(int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if(sum == n) {
                answer++;
            }

            while(sum >= n) {
                sum -= arr[lt++];
                if(sum == n) {
                    answer++;
                }
            }
        }

        return answer;
    }
    private int mySolution(int n) {
        int answer = 0, acc = 0, lp = 1;
        int[] arr = new int[n];
        for(int i = 1; i < n; i++) {
            arr[i] = i;
        }
        for(int rp = 1; rp < n; rp++){
            acc += arr[rp];
            if(acc == n) {
                answer++;
            }
            while(acc >= n){
                acc -= arr[lp++];
                if(acc == n) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
