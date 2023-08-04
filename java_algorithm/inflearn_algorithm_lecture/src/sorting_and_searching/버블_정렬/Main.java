package sorting_and_searching.버블_정렬;
import java.util.*;


/*
 * 버블 정렬
 * 앞에 값과 비교해가며 정렬을 하는 방법
 * 뒷부분의 값이 하나씩 정렬 된다.
 * */

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] sorted = main.mySolution(n, arr);
        for (int x : sorted) {
            System.out.print(x + " ");
        }
        System.out.println();

    }
    private int[] lectureSolution(int n, int[] arr) {
        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    private int[] mySolution(int n, int[] arr) {
        for(int i = n - 1; i > 0; i-- ) {
            int j = 0;
            while(j != i) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
                j++;
            }
        }
        return arr;
    }
}
