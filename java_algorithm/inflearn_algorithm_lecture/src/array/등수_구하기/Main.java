package array.등수_구하기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];

        for(int i = 0; i< n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> result = main.mySolution(n, arr);
        for(Integer x: result) {
            System.out.print(x + " ");
        }

    }

    private int[] lectureSolution(int n, int[] arr) {
        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            int cnt = 1;
            for(int j = 0; j < n; n++) {
                if(arr[j] > arr[i]) {
                    cnt ++;
                }
                answer[i] = cnt;
            }
        }
        return answer;
    }

    private ArrayList<Integer> mySolution(int n, Integer[] arr) {
        ArrayList<Integer> originList = new ArrayList<>(Arrays.asList(arr));
        HashMap<Integer, Integer> map = new HashMap<>(n);
        Arrays.sort(arr, Collections.reverseOrder());


        int rank = 1;
        for(Integer x: arr) {
            if(map.get(x) != null) {
                rank++;
                continue;
            }
            map.put(x, rank++);
        }

        ArrayList<Integer> rankList = new ArrayList<>(n);
        for(Integer x: originList) {
            rankList.add(map.get(x));
        }

        return rankList;
    }
}
