package array.멘토링;
import java.util.*;

/*
* 문제 접근
* 매칭 가능한 오름차순 키값으로  전부 만든다
* 카운트가 m인 경우만 출력한다.
* */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int testCnt = sc.nextInt();

        int[][] matrix = new int[testCnt][n];

        for(int i = 0; i < testCnt; i++) {
            for(int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }


        System.out.println(main.mySolution(n, testCnt, matrix));
    }

    private String getKey(int numA, int numB) {
        return numA + "-" + numB;
    }
    private int mySolution(int n, int testCnt, int[][] matrix) {
        int answer = 0;

        HashMap<String, Integer> group = new HashMap<>(n * n);
        for(int h = 0; h < testCnt; h++) {
            for(int w = 0; w < n - 1; w++){
                for(int w2 = w + 1; w2 < n; w2++) {
                    String key = this.getKey(matrix[h][w], matrix[h][w2]);
                    Integer value = group.get(key);
                    if(value == null) {
                        group.put(key, 1);
                    }else {
                        group.put(key, value + 1);
                    }
                }
            }
        }

        for(String x: group.keySet()) {
            if(group.get(x) == testCnt) {
                answer++;
            }
        }

        return answer;
    }
}

