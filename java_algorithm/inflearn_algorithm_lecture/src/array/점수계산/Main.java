package array.점수계산;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i <n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(main.mySolution(n, arr));
    }

    private int lectureSolution(int n, int[] arr){
        int answer=0, cnt =0;
        for(int i = 0; i < n; i++) {
            if(arr[i] == 1){
                cnt++;
                answer+= cnt;
            }else {
                cnt = 0;
            }
        }
        return answer;
    }

    private int mySolution(int n, int[] arr) {
        int answer = 0;
        int acc = 0;
        for(int loop = 0; loop < n; loop++) {
            if(arr[loop] == 0) {
                acc = 0;
                continue;
            }
            acc++;
            answer += acc;
        }

        return answer;
    }
}
