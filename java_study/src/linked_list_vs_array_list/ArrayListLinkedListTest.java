package linked_list_vs_array_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListTest {
    public static void main(String[] args) {
        ArrayList ary = new ArrayList(2000000);
        LinkedList lkd = new LinkedList();

        System.out.println("======순차적으로 추가하기======");
        System.out.println("ArrayList = " + addF(ary));
        System.out.println("LinkedList = " + addF(lkd));

        System.out.println("\n======중간에 추가하기======");
        System.out.println("ArrayList = " + addM(ary));
        System.out.println("LinkedList = " + addM(lkd));

        System.out.println("\n======중간에 삭제하기======");
        System.out.println("ArrayList = " + removeM(ary));
        System.out.println("LinkedList = " + removeM(lkd));

        System.out.println("\n======순차적으로 삭제하기======");
        System.out.println("ArrayList = " + removeF(ary));
        System.out.println("LinkedList = " + removeF(lkd));

    }

    public static long addF(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            list.add(i+"");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long addM(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.add(500,"X");
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long removeF(List list) {
        long start = System.currentTimeMillis();
        for(int i = list.size() - 1; i >= 0; i--) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static long removeM(List list) {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++) {
            list.remove(i);
        }
        long end = System.currentTimeMillis();
        return end - start;
    }
}
