package linked_list_vs_array_list;
import java.util.ArrayList;
import java.util.LinkedList;

public class RemoveByValueTest {
    public static void main(String[] args) {
        RemoveByValueTest test = new RemoveByValueTest();
        test.checkRemoveByRemove();

    }

    private void checkRemoveByRemove() {

        System.out.println("1000인 경우");
        compareRemoveByRemove(1_000);
        System.out.println("-------");

        System.out.println("1만인 경우");
        compareRemoveByRemove(10_000);
        System.out.println("-------");

        System.out.println("3만인 경우");
        compareRemoveByRemove(30_000);
        System.out.println("-------");

        System.out.println("5만인 경우");
        compareRemoveByRemove(50_000);
        System.out.println("-------");

        System.out.println("10만인 경우");
        compareRemoveByRemove(100_000);
        System.out.println("-------");

        System.out.println("100만인 경우");
        compareRemoveByRemove(1_000_000);
        System.out.println("-------");

        System.out.println("500만인 경우");
        compareRemoveByRemove(5_000_000);
        System.out.println("-------");

        System.out.println("1000만인 경우");
        compareRemoveByRemove(10_000_000);
        System.out.println("-------");

        System.out.println("1500만인 경우");
        compareRemoveByRemove(15_000_000);
        System.out.println("-------");

        System.out.println("2000만인 경우");
        compareRemoveByRemove(20_000_000);
        System.out.println("-------");

        System.out.println("3000만인 경우");
        compareRemoveByRemove(30_000_000);
        System.out.println("-------");

        System.out.println("4000만인 경우");
        compareRemoveByRemove(40_000_000);
        System.out.println("-------");

        System.out.println("5000만인 경우");
        compareRemoveByRemove(50_000_000);
        System.out.println("-------");
    }

    private void compareRemoveByRemove(int size) {
        long arrayListTime = removeByValueByArrayList(size);
        long linkedListTime = removeByValueByLinkedList(size);

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

    private long removeByValueByArrayList(int size) {
        ArrayList<Integer> arrayList = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {
            arrayList.add(i);
        }

        long beforeTotalTime = System.nanoTime();
        arrayList.remove(Integer.valueOf(arrayList.size() / 2));
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }

    private long removeByValueByLinkedList(int size) {
        LinkedList<Integer> linkedList = new LinkedList<>();


        for (int i = 1; i <= size; i++) {
            linkedList.add(i);
        }

        long beforeTotalTime = System.nanoTime();
        linkedList.remove(Integer.valueOf(linkedList.size() / 2));
        long afterTotalTime = System.nanoTime();
        return afterTotalTime - beforeTotalTime;
    }
}
