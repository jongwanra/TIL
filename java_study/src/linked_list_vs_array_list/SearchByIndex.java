package linked_list_vs_array_list;
import java.util.ArrayList;
import java.util.LinkedList;

public class SearchByIndex {
    public static void main(String[] args) {
        SearchByIndex test = new SearchByIndex();
        test.checkSearchByIndex();
    }

    private void checkSearchByIndex() {
        System.out.println("100만인 경우");
        compareSearchByValue(1_000_000);
        System.out.println("-------");

        System.out.println("500만인 경우");
        compareSearchByValue(5_000_000);
        System.out.println("-------");

        System.out.println("1000만인 경우");
        compareSearchByValue(10_000_000);
        System.out.println("-------");
    }

    private void compareSearchByValue(int size) {
        long arrayListTime = searchByIndexByArrayList(size, size -1);
        long linkedListTime = searchByIndexByLinkedList(size, size -1);

        System.out.println("ArrayList: " + arrayListTime + "ns");
        System.out.println("LinkedList: " + linkedListTime + "ns");

        if (arrayListTime < linkedListTime) {
            System.out.println("ArrayList가 더 빠릅니다.");
        } else if (arrayListTime > linkedListTime) {
            System.out.println("LinkedList가 더 빠릅니다.");
        } else {
            System.out.println("ArrayList와 LinkedList의 수행 시간이 동일합니다.");
        }
    }

    private long searchByIndexByArrayList(int size, int index) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
        }

        long beforeTotalTime = System.nanoTime();
        arrayList.get(index);
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }

    private long searchByIndexByLinkedList(int size, int index) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            linkedList.add(i);
        }

        long beforeTotalTime = System.nanoTime();

        linkedList.get(index);

        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }
}
