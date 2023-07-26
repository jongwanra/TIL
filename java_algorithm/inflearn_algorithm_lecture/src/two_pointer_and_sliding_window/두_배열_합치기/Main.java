package two_pointer_and_sliding_window.두_배열_합치기;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int numA = sc.nextInt();
        int[] arrA = new int[numA];

        for(int i = 0; i < numA; i++) {
            arrA[i] = sc.nextInt();
        }
        int numB = sc.nextInt();
        int[] arrB = new int[numB];

        for(int i = 0; i < numB; i++) {
            arrB[i] = sc.nextInt();
        }


        ArrayList<Integer> list = main.mySolution(numA, arrA, numB, arrB);
        for(Integer x: list) {
            System.out.print(x + " ");
        }
    }

    private ArrayList<Integer> mySolution(int numA, int[] arrA, int numB, int[] arrB) {
        ArrayList<Integer> list = new ArrayList<>(numA + numB);
        int ap = 0;
        int bp = 0;

        while(ap < numA && bp < numB) {
            if(arrA[ap] >= arrB[bp]) {
                list.add(arrB[bp]);
                bp++;
            }else {
                list.add(arrA[ap]);
                ap++;
            }
        }

        while(ap < numA){
            list.add(arrA[ap]);
            ap++;
        }

        while(bp < numB) {
            list.add(arrB[bp]);
            bp++;
        }


        return list;
    }
}
