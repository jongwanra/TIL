package 보이는_학생;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int idx = 0; idx < n; idx++) {
            arr[idx] = sc.nextInt();
        }

        System.out.println(main.mySolution(n, arr));

    }

    private int mySolution(int n, int[] arr) {
        int currentMaxHeight = Integer.MIN_VALUE;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] <= currentMaxHeight) {
                continue;
            }
            answer++;
            currentMaxHeight = arr[i];
        }
        return answer;
    }

    private int lectureSolution(int n, int[] arr) {
        int answer = 1, max = arr[0];
        for(int i = 1; i < n; i++) {
            if(arr[i] > max) {
                answer++;
                max = arr[i];
            }
        }
        return answer;
    }
}
