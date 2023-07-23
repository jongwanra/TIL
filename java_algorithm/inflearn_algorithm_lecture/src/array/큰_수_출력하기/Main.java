package array.큰_수_출력하기;
import java.util.*;
public class Main {

    /*
    * 6
    * 7 3 9 5 6 12
    *
    *
    * 자신의 바로 앞 수보다 큰 수만 출력
    * */
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        int[] array = new int[n];
        String input = sc.nextLine();
        String[] s = input.split(" ");

        for(int i = 0; i < s.length; i++) {
            array[i] = Integer.parseInt(s[i]);
        }

        ArrayList<Integer> list = main.mySolution(n, array);
        for(Integer x: list) {
            System.out.print(x + " ");
        }
    }

    private ArrayList<Integer> mySolution(int n, int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for(int i = 1; i < n; i++) {
            if(array[i - 1] < array[i]) {
                list.add(array[i]);
            }
        }
        return list;
    }
    private ArrayList<Integer> lectureSolution(int n, int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(array[0]);
        for(int i = 1; i < n; i++) {
            if(array[i - 1] < array[i]) {
                list.add(array[i]);
            }
        }
        return list;
    }
}
