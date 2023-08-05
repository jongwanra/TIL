package sorting_and_searching.이분검색;
import java.util.*;


// Binary Search
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(main.mySolution(n, m, arr));
    }

    private int lectureSolution(int n, int m, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt =0, rt = n- 1;
        while(lt <= rt ){
            int mid=(lt+rt)/2;
            if(arr[mid] == m) {
                answer = mid + 1;
                break;
            }

            if(arr[mid] > m) rt = mid - 1;
            else lt = mid + 1;
        }

        return answer;
    }

    private int mySolution(int n, int m, int[] arr) {
        Arrays.sort(arr);
        int li = 0;
        int ri = n - 1;

        while(li <= ri) {
            int mi = (li + ri) / 2;
            if(arr[mi] == m) {
                return mi + 1;
            }

            if(arr[mi] > m) {
                ri = mi - 1;
            }else {
                li = mi + 1;
            }
        }
        return 0;
    }
}
