package chapter22;
import java.util.ArrayList;
import java.util.Arrays;

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
//        sample.checkArrayList1();
        sample.checkArrayList3();
    }

    private void checkArrayList1() {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("sample");
        list1.add("sample2");
        list1.add("sample3");
        System.out.println("list1 = " + list1);
    }

    private void checkArrayList2() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        list.add(1, "A1");
        System.out.println("list = " + list);
    }

    private void checkArrayList3() {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E"));

        list.add(1, "A1");

        ArrayList<String> list2 = new ArrayList<>();
        list2.add(" 0");
        list2.addAll(list);

        System.out.println("list2 = " + list2);
    }
}
