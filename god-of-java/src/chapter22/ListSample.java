package chapter22;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListSample {
    public static void main(String[] args) {
        ListSample sample = new ListSample();
//        sample.checkArrayList1();
//        sample.checkArrayList3();
//        sample.checkArrayList6();
//        sample.checkArrayList8();
          sample.checkArrayListContainMethod();
    }

    private void checkArrayListContainMethod() {
        ArrayList<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "melon", "grape", "tomato"));
        boolean isContained = fruits.contains("grape");
        System.out.println("isContained = " + isContained);
    }


    private void checkArrayList1() {
        ArrayList<String> list1 = new ArrayList<>(10);
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

    private void checkArrayList6() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("A");
        list.add("A");

        String[] array = list.toArray(new String[0]);

        for(String e: array){
            System.out.println(e + " ");
        }
    }

    private void checkArrayList7() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        String[] tempArray = new String[0];
        String[] strList = list.toArray(tempArray);
        printArray(strList);


    }

    private void checkArrayList8() {
        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("A");

        System.out.println("list:" + list);

        ArrayList<String> temp = new ArrayList<>(List.of("A"));

        list.removeAll(temp);
        System.out.println("list:" + list);
    }


    private void printArray(Object[] array) {
        for(Object e: array){
            System.out.println(e + " ");
        }
        System.out.println();
    }
    private <E> void printList(ArrayList<E> list) {
        for(E e: list){
            System.out.println(e + " ");
        }
        System.out.println();
    }
}
