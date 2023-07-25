package array.봉우리;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] matrix = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j =0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.mySolution(n, matrix));
    }


    private int lectureSolution(int n, int[][] arr) {
        int[] dx = { -1, 0, 1, 0};
        int[] dy = { 0, 1, 0, -1};
        int answer = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for(int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }
                    // 아닌 경우를 찾아서 내보냄
                    if(arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    answer++;
                }
            }
        }
        return answer;
    }
    private int mySolution(int n, int[][] matrix) {
        // 오른쪽, 왼쪽, 위, 아래
        int[] dw = new int[] { 1, -1, 0, 0};
        int[] dh = new int[] { 0, 0, -1, 1};
        int answer =0;
        for(int h = 0; h < n; h++) {
            for(int w = 0; w < n; w++) {
                int mountainCount = 0;
                int target = matrix[h][w];
                for(int loop = 0; loop < 4; loop++) {
                    int hh = h + dh[loop];
                    int ww = w + dw[loop];
                    if(ww < 0 || hh < 0 || ww >= n || hh >= n) {
                        mountainCount++;
                        continue;
                    }
                    if(matrix[hh][ww] < target) {
                        mountainCount++;
                    }
                }
                if(mountainCount == 4) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
