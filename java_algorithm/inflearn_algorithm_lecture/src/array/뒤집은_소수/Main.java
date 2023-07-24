package array.뒤집은_소수;
import java.util.*;
public class Main {
    public static void main(String[] args ){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        main.lectureSolution(n, arr);


    }

    private boolean[] getIsPrimeArr(int n){
        boolean[] arr = new boolean[n + 1];
        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for(int i = 2; i <= n; i++) {
            if(!arr[i]) {
                continue;
            }

            for(int j = i * 2; j <= n; j += i) {
                arr[j] = false;
            }
        }
        return arr;
    }
    private void mySolution(int n, int[] arr) {
        boolean[] isPrimeArr = this.getIsPrimeArr(100_000);

        for( int x: arr) {
            String reversed = new StringBuilder(String.valueOf(x))
                    .reverse()
                    .toString();
            int reversedNum = Integer.parseInt(reversed);

            if(isPrimeArr[reversedNum]) {
                System.out.print(reversedNum + " ");
            }
        }
    }

    private void lectureSolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int tmp = arr[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }
            if(isPrime(res)) answer.add(res);
        }
        for(Integer x: answer) {
            System.out.print(x + " ");
        }
    }

    // 소수를 제곱근 까지 돌려서 구할 때 제곱근을 포함해서 돌려줘야 확실히 소수인지를 판별할 수 있다.
    private boolean isPrime(int n) {
        if(n == 1) {
            return false;
        }

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
