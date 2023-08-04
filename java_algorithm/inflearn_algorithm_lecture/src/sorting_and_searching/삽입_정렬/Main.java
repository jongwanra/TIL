package sorting_and_searching.삽입_정렬;

import java.util.*;


/*
* 삽입 정렬
* 두 번째 요소부터 순회하며
* 이전 요소들과 비교해서 적절한 위치에 삽입하는 정렬
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
        for(int i = 1; i < n; i++) {
            int tmp = arr[i], j;
            for(j = i -1;  j >= 0; j--) {
                if(arr[j] > tmp) arr[j+ 1] = arr[j];
                else break;
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    private void printArr(int[] arr) {
        for(int x: arr) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
    private int[] mySolution(int n, int[] arr) {
        for(int i = 1; i < n; i++) {
            int target = arr[i];
            int insertIdx = 0;
            for(int j = i - 1; j >= 0; j--) {
                if(target < arr[j]) {
                    arr[j + 1] = arr[j];
                }else {
                    insertIdx = j + 1;
                    break;
                }
            }
            arr[insertIdx] = target;
        }
        return arr;
    }
}
