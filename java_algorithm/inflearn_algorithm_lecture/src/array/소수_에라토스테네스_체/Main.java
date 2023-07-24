package array.소수_에라토스테네스_체;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(main.mySolution(n));
    }

    private int lectureSolution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        for(int i =2; i <= n; i++) {
            if(ch[i] == 0) {
                answer++;
                for(int j = i; j <= n; j= j+i) {
                    ch[j] = 1;
                }
            }
        }
        return answer;
    }

    private int mySolution(int n) {
        int answer = 0;
        boolean[] isPrimeArr = new boolean[n + 1];
        Arrays.fill(isPrimeArr, true);

        for(int i = 2; i < isPrimeArr.length; i++) {
            if(!isPrimeArr[i]) {
                continue;
            }
            answer++;
            int j = i + i;
            while(j < isPrimeArr.length) {
                isPrimeArr[j] = false;
                j = j + i;
            }
        }

        return answer;
    }
}
