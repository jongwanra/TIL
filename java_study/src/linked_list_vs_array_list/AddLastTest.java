package linked_list_vs_array_list;
import java.util.ArrayList;
import java.util.LinkedList;

public class AddLastTest {
    public static void main(String[] args) {
        AddLastTest test = new AddLastTest();
        test.checkAddLast();
    }

    private void checkAddLast() {

        System.out.println("1000인 경우");
        compareAddLast(1_000);
        System.out.println("-------");

        System.out.println("1만인 경우");
        compareAddLast(10_000);
        System.out.println("-------");

        System.out.println("3만인 경우");
        compareAddLast(30_000);
        System.out.println("-------");

        System.out.println("5만인 경우");
        compareAddLast(50_000);
        System.out.println("-------");

        System.out.println("10만인 경우");
        compareAddLast(100_000);
        System.out.println("-------");

        System.out.println("100만인 경우");
        compareAddLast(1_000_000);
        System.out.println("-------");

        System.out.println("1000만인 경우");
        compareAddLast(10_000_000);
        System.out.println("-------");
    }

    private void compareAddLast(int size) {
        long arrayListTime = addLastByArrayList(size);
        long linkedListTime = addLastByLinkedList(size);

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

    private long addLastByArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>(size + 1);

        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
        }
        long beforeTotalTime = System.nanoTime();
        arrayList.add(1);
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }

    private long addLastByLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();


        for (int i = 1; i <= size; i++) {
            linkedList.add(i);
        }

        long beforeTotalTime = System.nanoTime();
        linkedList.addLast(1);
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }
}
