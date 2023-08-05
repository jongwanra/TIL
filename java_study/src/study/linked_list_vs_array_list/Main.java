package study.linked_list_vs_array_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Main m = new Main();
//        m.checkAddMethodOfArrayList(10_000_000);
        m.checkAddMethodOfLinkedList(10_000_000);
    }

    private void checkAddMethodOfLinkedList(int testSize) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        int count = 0;
        long beforeTotalTime = System.nanoTime();
        for(int i = 1; i <= testSize; i++) {
            long before = System.nanoTime();
            linkedList.add(i);
            long after = System.nanoTime();
            long total = after - before;
            if(total > 10_000)  {
                System.out.println(i + " : "+ total);
                count++;
            }
        }

        long afterTotalTime =  System.nanoTime();

        System.out.println("total => " + (afterTotalTime - beforeTotalTime));
        System.out.println("totalCount => " + count);
    }

    private void checkAddMethodOfArrayList(int testSize) {
        ArrayList<Integer> arrayList = new ArrayList<>(10);

        int count = 0;
        int curretCapacity = 10;
        long beforeTotalTime = System.nanoTime();
        for(int i = 1; i <= testSize; i++) {
            if(i == curretCapacity) {
                System.out.println("-----grow capacity: " + i + "------------");
                curretCapacity = curretCapacity + (curretCapacity >> 1);
            }
            long before = System.nanoTime();
            arrayList.add(i);
            long after = System.nanoTime();
            long total = after - before;
            if(total > 10_000)  {
                System.out.println(i + " : "+ total);
                count++;
            }
        }

        long afterTotalTime =  System.nanoTime();

        System.out.println("total => " + (afterTotalTime - beforeTotalTime));
        System.out.println("totalCount => " + count);
    }
}
