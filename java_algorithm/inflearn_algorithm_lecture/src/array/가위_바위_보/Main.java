package array.가위_바위_보;

import java.util.*;

public class Main {

    private String lectureSolution(int n, int[] a, int[] b) {
        String answer = "";
        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) answer += "D";
            else if (a[i] == 1 && b[i] == 3) answer += "A";
            else if (a[i] == 2 && b[i] == 1) answer += "A";
            else if (a[i] == 3 && b[i] == 2) answer += "A";
            else answer += "B";
        }

        return answer;
    }

    private void mySolution(int n, int[] arrA, int[] arrB) {
        for (int i = 0; i < n; i++) {
            if (arrA[i] == arrB[i]) {
                System.out.println('D');
                continue;
            }
            char info = 'D';
            switch (arrA[i]) {
                // A가 가위를 낸 경우
                case 1:
                    info = arrB[i] == 2 ? 'B' : 'A';
                    break;
                // A가 바위를 낸 경우
                case 2:
                    info = arrB[i] == 1 ? 'A' : 'B';
                    break;
                // A가 보를 낸 경우
                case 3:
                    info = arrB[i] == 2 ? 'A' : 'B';
                    break;
            }
            System.out.println(info);
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arrA = new int[n];
        int[] arrB = new int[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arrB[i] = sc.nextInt();
        }

        main.mySolution(n, arrA, arrB);

    }
}
