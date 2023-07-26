package two_pointer_and_sliding_window.공통원소_구하기;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int na = sc.nextInt();
        Integer[] arrA = new Integer[na];
        for(int i = 0 ; i < na; i++){
            arrA[i] = sc.nextInt();
        }
        int nb = sc.nextInt();
        Integer[] arrB = new Integer[nb];

        for(int i = 0 ; i < nb; i++){
            arrB[i] = sc.nextInt();
        }

        HashSet<Integer> retainSet = main.mySolution(na, nb, arrA, arrB);
        Integer[] arr = retainSet.toArray(new Integer[0]);
        Arrays.sort(arr);

        for(Integer x: arr) {
            System.out.print(x + " ");
        }
    }


    /* Access HashSet retainAll */
    private HashSet<Integer> mySolution(int na, int nb, Integer[] arrA, Integer[] arrB) {
        HashSet<Integer> setA = new HashSet<Integer>(Arrays.asList(arrA));
        HashSet<Integer> setB = new HashSet<Integer>(Arrays.asList(arrB));

        setA.retainAll(setB);
        return setA;
    }


    /* Access Two Pointers Algorithm*/
    private ArrayList<Integer> lectureSolution(int n, int m, int[] a, int[] b) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(a);
        Arrays.sort(b);
        int p1=0, p2=0;

        while(p1 <n && p2 < m) {
            if(a[p1] == b[p2]) {
                answer.add(a[p1++]);
                p2++;
            }else if(a[p1] < b[p2]){
                p1++;
            }else {
                p2++;
            }
        }

        return answer;
    }
}
