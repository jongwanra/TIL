package linked_list_vs_array_list;
import java.util.ArrayList;
import java.util.LinkedList;

public class SearchByValue {
    public static void main(String[] args) {
        SearchByValue test = new SearchByValue();
        test.checkSearchByValue();
    }

    private void checkSearchByValue() {
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
        long arrayListTime = searchByValueByArrayList(size, size -1);
        long linkedListTime = searchByValueByLinkedList(size, size -1);

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

    private long searchByValueByArrayList(int size, int value) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
        }

        long beforeTotalTime = System.nanoTime();
        arrayList.contains(value);
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }

    private long searchByValueByLinkedList(int size, int value) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        for (int i = 1; i <= size; i++) {
            linkedList.add(i);
        }

        long beforeTotalTime = System.nanoTime();

        linkedList.contains(value);

        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }
}
