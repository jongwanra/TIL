package hash_map_and_tree_map.매출액의_종류;
import java.util.*;


public class Main {


    private ArrayList<Integer> lectureSolution(int n, int k, int[] arr) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> HM = new HashMap<>();

        for(int i = 0; i < k - 1; i++) {
            HM.put(arr[i], HM.getOrDefault(arr[i], 0) + 1);
        }

        int lt = 0;
        for(int rt = k - 1; rt < n; rt++) {
            HM.put(arr[rt], HM.getOrDefault(arr[rt], 0) + 1);
            answer.add(HM.size());

            HM.put(arr[lt], HM.get(arr[lt]));
            if(HM.get(arr[lt]) == 0) {
                HM.remove(arr[lt]);
            }
            lt++;
        }

        return answer;
    }

    /* time exceed error */
    private void mySolution(int n, int k, int[] arr) {
        for(int i = 0; i <= n - k; i++) {
            HashSet<Integer> set = new HashSet<>(k);
            for(int j = i; j < k + i; j ++) {
                set.add(arr[j]);
            }
            System.out.print(set.size() + " ");
        }
    }


    /*
    * HashMap을 이용해서 two pointer로 O(n)으로 문제를 해결해보자
    * */
    private void mySolution2(int n, int k, int[] arr ){
        HashMap<Integer, Integer> map = new HashMap<>(k);
        int lp = 0;

        for(int rp = 0; rp < n; rp++) {
            map.put(arr[rp], map.getOrDefault(arr[rp], 0) + 1);
            if(rp - lp == k){
                Integer target = map.get(arr[lp]);
                if(target == 1) {
                    map.remove(arr[lp]);
                }else {
                    map.put(arr[lp], map.get(arr[lp]) - 1);
                }
                lp++;
            }
            if(rp - lp + 1 == k) {
                System.out.print(map.size() + " ");
            }


        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        main.mySolution2(n, k, arr);

    }

}
