package hash_map_and_tree_map.아나그램;
import java.util.*;
public class Main {
    public static void main(String[] args){
        Main main = new Main();
        Scanner sc = new Scanner(System.in);

        System.out.println(main.mySolution(sc.next(), sc.next()));
    }

    private String lectureSolution(String s1, String s2) {
        String answer = "YES";

        HashMap<Character, Integer>  map = new HashMap<>();

        for(char x: s1.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(char x: s2.toCharArray()){
            if(!map.containsKey(x) || map.get(x) == 0) {
                return "NO";
            }

            map.put(x, map.get(x) - 1);
        }
        return answer;
    }

    private String mySolution(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>(s1.length());

        for(char key: s1.toCharArray()) {
            map.put(key, map.getOrDefault(key, 0)  + 1);
        }

        for(char key: s2.toCharArray()) {

            Integer target = map.getOrDefault(key, -1 );
            if(target == -1) {
                return "NO";
            }

            if(target == 1) {
                map.remove(key);
                continue;
            }
            map.put(key, target - 1);
        }

        return (map.size() == 0) ? "YES": "NO";
    }
}
