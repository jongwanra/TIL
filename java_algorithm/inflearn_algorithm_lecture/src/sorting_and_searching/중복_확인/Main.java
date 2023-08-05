package sorting_and_searching.중복_확인;
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

    private String lectureSolution(int n,  int[] arr) {
        String answer = "U";
        Arrays.sort(arr);
        for(int i = 0; i < n - 1; i ++) {
            if(arr[i] == arr[i+1]) {
                return "D";
            }
        }
        return answer;
    }

    private Character mySolution(int n, int[] arr) {
        HashMap<Integer, Boolean> hm = new HashMap<>(n);

        for(int x: arr) {
            if(hm.get(x) != null) {
                return 'D';
            }
            hm.put(x, true);
        }
        return 'U';
    }
}
