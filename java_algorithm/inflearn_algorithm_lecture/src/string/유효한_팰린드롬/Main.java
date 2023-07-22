package string.유효한_팰린드롬;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(main.mySolution(sc.nextLine()));
        System.out.println(main.lectureSolution(sc.nextLine()));
    }

    private String lectureSolution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String tmp = new StringBuilder(str).reverse().toString();

        if(str.equals(tmp)) {
            return "YES";
        }
        return "NO";
    }


    /*
    * 문제 접근
    * toCharArray를 통해서 char[] 타입으로 변환
    * left, right를 통해서 검사 나머진 무시
    * */
    private String mySolution(String str) {
        str = str.toUpperCase();
        int left = 0;
        int right = str.length() - 1;
        while(left < right) {
            if(!Character.isAlphabetic(str.charAt(left))){
                left++;
            }else if(!Character.isAlphabetic(str.charAt(right))){
                right--;
            }else {
                if(str.charAt(left) != str.charAt(right)){
                    return "NO";
                }
                left++;
                right--;
            }

        }
        return "YES";
    }
}
