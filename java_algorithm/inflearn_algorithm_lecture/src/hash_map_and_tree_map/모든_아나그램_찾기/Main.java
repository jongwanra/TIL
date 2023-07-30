package hash_map_and_tree_map.모든_아나그램_찾기;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.mySolution(sc.next(), sc.next()));
    }


    /*
    * s2 문자열을 HashSet으로 만든다.
    * counting 을 통해서 체크한다.
    * */
    private int mySolution(String s1, String s2) {
        HashMap<Character, Boolean> map = new HashMap<>();
        for (char x: s2.toCharArray()) {
            map.put(x, true);
        }
        int answer = 0;
        return answer;
    }
}
