package hash_map_and_tree_map.학급_회장;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        System.out.println(main.mySolution(n, str.toCharArray()));

    }


    private char lectureSolution(int n, String s) {
        char answer  = '\u0000';
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char x: s.toCharArray()){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for(char key: map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }

        return answer;
    }
    private char mySolution(int n, char[] charArray) {
        HashMap<Character, Integer> map = new HashMap<>(n);

        for(char x: charArray) {
            if(map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }else {
                map.put(x, 1);
            }
        }

        int maxCnt = -1;
        char maxCh = '\u0000';

        for(Character x: map.keySet()) {
            Integer cnt = map.get(x);
            if( maxCnt < cnt) {
                maxCnt = cnt;
                maxCh = x;
            }
        }

        return maxCh;
    }
}
