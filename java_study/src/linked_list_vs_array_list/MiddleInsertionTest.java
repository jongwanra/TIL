package linked_list_vs_array_list;

import java.util.ArrayList;
import java.util.LinkedList;

public class MiddleInsertionTest {
    public static void main(String[] args) {
        int dataSize = 1_000;
        int insertValue = 999999;

        // ArrayList 중간 삽입 시간 측정
        long arrayListStartTime = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < dataSize; i++) {
            arrayList.add(i / 2, insertValue);
        }
        long arrayListEndTime = System.nanoTime();
        long arrayListTime = arrayListEndTime - arrayListStartTime;
        System.out.println("ArrayList 중간 삽입 시간: " + arrayListTime + "ns");

        // LinkedList 중간 삽입 시간 측정
        long linkedListStartTime = System.nanoTime();
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < dataSize; i++) {
            linkedList.add(i / 2, insertValue);
        }
        long linkedListEndTime = System.nanoTime();
        long linkedListTime = linkedListEndTime - linkedListStartTime;
        System.out.println("LinkedList 중간 삽입 시간: " + linkedListTime + "ns");

        // 결과 출력
        if (arrayListTime < linkedListTime) {
            System.out.println("ArrayList가 더 빠릅니다.");
        } else if (arrayListTime > linkedListTime) {
            System.out.println("LinkedList가 더 빠릅니다.");
        } else {
            System.out.println("ArrayList와 LinkedList의 수행 시간이 동일합니다.");
        }
    }
}

