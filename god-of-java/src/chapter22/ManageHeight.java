package chapter22;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ManageHeight {

    private ArrayList<ArrayList<Integer>> gradeHeights = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> getData() {
        return this.gradeHeights;
    }

    public void setData() {
        this.gradeHeights.add(new ArrayList<>());
        this.gradeHeights.add(new ArrayList<>(Arrays.asList(170, 180, 173, 175, 177)));
        this.gradeHeights.add(new ArrayList<>(Arrays.asList(160, 165, 167, 186)));
        this.gradeHeights.add(new ArrayList<>(Arrays.asList(158, 177, 187, 176)));
        this.gradeHeights.add(new ArrayList<>(Arrays.asList(173, 182, 181)));
        this.gradeHeights.add(new ArrayList<>(Arrays.asList(170, 180, 165, 177, 172)));
    }

    public void printHeight(int classNo) {
        ArrayList<Integer> targetClass = this.getData().get(classNo);
        System.out.println("Class No.:" + classNo);
        for(Integer target: targetClass) {
            System.out.println(target);
        }
    }

    public void printAverage(int classNo) {
        System.out.println("Class No.:" + classNo);
        ArrayList<Integer> targetClass = this.getData().get(classNo);
        int total = 0;
        for(Integer target: targetClass) {
            total += target;
        }

        double average = (double) total / targetClass.size();
        System.out.println("Height average: " + average);
    }
    public static void main(String[] args) {
        ManageHeight manageHeight = new ManageHeight();
        manageHeight.setData();
//        for(int i = 1; i <= 5; i++) {
//            manageHeight.printHeight(i);
//        }
        for(int i = 1; i <= 5; i++) {
            manageHeight.printAverage(i);
        }


    }
}
