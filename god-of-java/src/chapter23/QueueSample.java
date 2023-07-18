package chapter23;

import java.util.LinkedList;

public class QueueSample {
    public static void main(String[] args) {
        QueueSample sample = new QueueSample();
        sample.checkLinkedList1();
    }

    private void checkLinkedList1() {
        LinkedList<String> link = new LinkedList<>();

        link.add("A");
        link.addFirst("B");
        System.out.println("link = " + link);

        link.offerFirst("C");
        System.out.println("link = " + link);

        link.addLast("D");
        System.out.println("link = " + link);

        link.offer("E");
        System.out.println("link = " + link);
    }
}
