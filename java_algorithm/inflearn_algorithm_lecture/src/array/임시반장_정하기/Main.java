package array.임시반장_정하기;
import java.util.*;


/*
* 문제 접근
* 한 학생 마다 같은 반이였던 학생들의 수를 HashMap을 순회하면서 학생 넘버: key, 같은 반이였던 학생을 Set으로 매핑한다
* 그리고 가장 많이 매핑이된 학생의 넘버를 출력한다.
*
* 문제는 풀었지만 적지 않은 시간이 걸렸다. 추후 다시 한 번 풀어보기로
* */
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n +1][6];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= 5; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(main.mySolution(n, matrix));
        System.out.println(main.lectureSolution(n, matrix));
    }

    private int lectureSolution(int n, int[][] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= 5; k++) {
                    if (arr[i][k] == arr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt) {
                answer = i;
                max = cnt;
            }
        }
         return answer;
    }

    private int mySolution(int n, int[][] matrix) {
        int answer = Integer.MIN_VALUE;
        HashMap<Integer, HashSet<Integer>> group = new HashMap<>(n + 1);

        for(int me = 1; me <= n; me++) {
            HashSet<Integer> sameClass = new HashSet<>(n + 1);
            for(int grade = 1; grade <= 5; grade++) {
                int myClass = matrix[me][grade];
                for(int otherStudent = 1; otherStudent <= n; otherStudent++) {
                    if(me == otherStudent) {
                        continue;
                    }
                    if(myClass == matrix[otherStudent][grade]) {
                        sameClass.add(otherStudent);
                    }
                }
            }
            group.put(me, sameClass);
        }

        int max_idx = -1;
        for(int i = 1; i <= n; i++) {
            HashSet<Integer> targets = group.get(i);
            if(targets.size() > answer) {
                answer = targets.size();
                max_idx = i;
            }
        }
        return max_idx;
    }
}
