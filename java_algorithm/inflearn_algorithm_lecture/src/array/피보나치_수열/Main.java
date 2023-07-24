package array.피보나치_수열;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int n = sc.nextInt();
        main.mySolution(n);
    }

    private void mySolution(int n) {
        int[] arr = new int[n + 1];
        arr[1] = 1;
        arr[2] = 1;
        System.out.print(arr[1] + " " + arr[2] + " ");
        for(int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
            System.out.print(arr[i] + " ");
        }
    }

    private void lectureSolution(int n) {
        int a = 1, b= 1, c;

        System.out.print(a+ " " + b +  " ");
        for(int i = 2; i < n; i++) {
            c = a + b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}
