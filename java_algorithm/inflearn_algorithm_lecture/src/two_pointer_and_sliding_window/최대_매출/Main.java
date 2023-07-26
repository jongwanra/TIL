package two_pointer_and_sliding_window.최대_매출;

import java.util.*;


/*
 * 문제 접근
 * 초반의 K일 동안을 우선 구한다.
 * start point, end point를 두고 end point 값을 증가 start point를 감소 하면서 최대값을 비교해 나간다.
 * */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(main.mySolution(n, k, arr));
    }

    private int lectureSolution(int n, int k, int[] arr) {
        int answer, sum = 0;

        for(int i = 0; i < k; i++) sum += arr[i];
        answer = sum;
        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            answer = Math.max(answer, sum);
        }
        return answer;
    }

    private int mySolution(int n, int k, int[] arr) {
        int lp = 0, rp = 0;
        int sum = 0;

        /* 초기값 구하기 */
        while(rp < k) {
            sum  += arr[rp++];
        }
        int max = sum;

        while(rp < n) {
            sum -= arr[lp++];
            sum += arr[rp++];

            max = Math.max(max, sum);
        }

        return max;
    }
}
