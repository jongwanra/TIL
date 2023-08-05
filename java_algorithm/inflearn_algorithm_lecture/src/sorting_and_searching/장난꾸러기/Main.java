package sorting_and_searching.장난꾸러기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(m.mySolution(n, arr));
    }

    private ArrayList<Integer> lectureSolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();

        int[] tmp = arr.clone();
        Arrays.sort(tmp);

        for(int i = 0; i < n; i++ ){
            if(arr[i] != tmp[i]) {
                answer.add(i + 1);
            }
        }

        return answer;
    }

    private void printAll(int[] arr) {
        for(int x: arr) System.out.print(x + " ");
        System.out.println();
    }
    private String mySolution(int n, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] copiedArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);

        for(int i = 0; i < n; i++) {
            if(arr[i] !=copiedArr[i]){
                answer.add(i + 1);
            }
        }

        return new StringBuilder()
                .append(Math.min(answer.get(0), answer.get(1)))
                .append(" ")
                .append(Math.max(answer.get(0), answer.get(1)))
                .toString();
    }
}
