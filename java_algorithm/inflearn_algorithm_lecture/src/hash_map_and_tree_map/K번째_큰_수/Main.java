package hash_map_and_tree_map.K번째_큰_수;
import  java.util.*;
public class Main {

    private static int lectureSolution(int[] arr, int n, int k) {
        int answer = 0;

        TreeSet<Integer> Tset = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int l = j + 1; l < n; l++) {
                    Tset.add(arr[i] + arr[j] + arr[l]);
                }
            }
        }

        int cnt = 0;
        for(int x: Tset) {
            cnt++;
            if(cnt == k) return x;
         }

        return -1;
    }

    private static int mySolution(int n, int k, int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        // 모든 3자리의 합 경우의 수 돌기(조합)
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                for(int s = j + 1; s < n; s++) {
                    int sum = arr[i] + arr[j] + arr[s];
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }

        int cnt = 0;
        for(Integer x: map.keySet()) {
            cnt++;
            if(cnt ==  k) {
                return x;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for(int i =0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(mySolution(n, k, arr));
    }
}
