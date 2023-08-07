package linked_list_vs_array_list;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveByIndex {
    public static void main(String[] args) {
        RemoveByIndex test = new RemoveByIndex();
        test.checkRemoveByIndex();
    }

    private void checkRemoveByIndex() {

        System.out.println("1000인 경우");
        removeByIndexByLinkedList(1_000);
        removeByIndexByArrayList(1_000);
        System.out.println("-------");

        System.out.println("5000인 경우");
        removeByIndexByLinkedList(5_000);
        removeByIndexByArrayList(5_000);
        System.out.println("-------");

        System.out.println("1만인 경우");
        removeByIndexByLinkedList(10_000);
        removeByIndexByArrayList(10_000);
        System.out.println("-------");

        System.out.println("3만인 경우");
        removeByIndexByLinkedList(30_000);
        removeByIndexByArrayList(30_000);
        System.out.println("-------");

        System.out.println("5만인 경우");
        removeByIndexByLinkedList(50_000);
        removeByIndexByArrayList(50_000);
        System.out.println("-------");

        System.out.println("10만인 경우");
        removeByIndexByLinkedList(100_000);
        removeByIndexByArrayList(100_000);
        System.out.println("-------");


        System.out.println("100만인 경우");
        removeByIndexByLinkedList(1_000_000);
        removeByIndexByArrayList(1_000_000);
        System.out.println("-------");


        System.out.println("1000만인 경우");
        removeByIndexByLinkedList(10_000_000);
        removeByIndexByArrayList(10_000_000);
        System.out.println("-------");



    }
    private long removeByIndexByArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        long beforeTotalTime = System.nanoTime();
        for(int i = 1; i <= size; i++) {
            arrayList.add(i);
        }

        long afterTotalTime =  System.nanoTime();
        BigDecimal totalTime = new BigDecimal(String.valueOf(afterTotalTime - beforeTotalTime));
        BigDecimal toMilliSecond = totalTime.divide(new BigDecimal(String.valueOf(1_000_000)), RoundingMode.FLOOR);
        System.out.println("ArrayList: " + toMilliSecond + "ms");

        return afterTotalTime;

    }

    private long removeByIndexByLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        long beforeTotalTime = System.nanoTime();
        for(int i = 1; i <= size; i++) {
            linkedList.addLast(i);
        }

        long afterTotalTime =  System.nanoTime();
        BigDecimal totalTime = new BigDecimal(String.valueOf(afterTotalTime - beforeTotalTime));
        BigDecimal toMilliSecond = totalTime.divide(new BigDecimal(String.valueOf(1_000_000)), RoundingMode.FLOOR);
        System.out.println("LinkedList: " + toMilliSecond + "ms");

        return afterTotalTime;
    }
}

