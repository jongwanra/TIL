package array.격자판_최대합;
import java.util.*;
public class Main {

    private void printMatrix(int[][] matrix) {
        int len = matrix[0].length;
        for(int h = 0; h < len; h++) {
            for(int w = 0; w < len; w++) {
                System.out.print(matrix[h][w] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int h = 0; h < n; h++) {
            for(int w = 0; w < n; w++) {
                matrix[h][w] = sc.nextInt();
            }
        }
        System.out.println(main.mySolution(n, matrix));
    }

    private int lectureSolution(int n, int[][] arr) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        for(int i = 0; i < n; i++) {
            sum1=sum2=0;
            for(int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            answer = Math.max(sum1, answer);
            answer = Math.max(sum2, answer);
        }

        sum1=sum2=0;

        for(int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }

        answer = Math.max(sum1, answer);
        answer = Math.max(sum2, answer);
        return answer;
    }

    private int mySolution(int n, int[][] matrix) {
        int answer = Integer.MIN_VALUE;

        // 각 행의 합
        for(int h = 0; h < n; h++) {
            int rowSum = 0;
            int colSum = 0;
            for(int w = 0; w < n; w++) {
                rowSum += matrix[h][w];
                colSum += matrix[w][h];
            }
            answer = Math.max(rowSum, answer);
            answer = Math.max(colSum, answer);
        }

        // \ 대각선의 합
        //  / 대각선의 합
        int leftLineSum = 0;
        int rightLineSum = 0;
        for(int i = 0; i < n; i++) {
            leftLineSum += matrix[i][i];
            rightLineSum += matrix[i][n - i - 1];
        }
        answer = Math.max(answer, leftLineSum);
        answer = Math.max(answer, rightLineSum);

        return answer;
    }
}
