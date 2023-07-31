package hash_map_and_tree_map.모든_아나그램_찾기;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.mySolution(sc.next(), sc.next()));
        System.out.println(main.lectureSolution(sc.next(), sc.next()));
    }


    private int lectureSolution(String a, String b) {
        int answer = 0;
        HashMap<Character, Integer> am = new HashMap<>();
        HashMap<Character, Integer> bm = new HashMap<>();

        for(char x: b.toCharArray()) bm.put(x, bm.getOrDefault(x, 0) + 1);
        int L = b.length() - 1;

        for(int i = 0; i < L; i++) {
            am.put(a.charAt(i), am.getOrDefault(a.charAt(i), 0) + 1);
        }

        int lt = 0;
        for(int rt=L; rt < a.length(); rt++ ){
            am.put(a.charAt(rt), am.getOrDefault(a.charAt(rt), 0) + 1);

            if(am.equals(bm)) {
                answer++;
            }

            am.put(a.charAt(lt), am.get(a.charAt(lt)) - 1);
            if(am.get(a.charAt(lt)) == 0) am.remove(a.charAt(lt));
        }
        return answer;
    }

    private int mySolution(String s1, String s2) {
        int answer = 0;
        int lt = 0;
        TreeMap<Character, Integer> originMap = new TreeMap<>();
        TreeMap<Character, Integer> curMap = new TreeMap<>();

        // 초기 s2 => TreeMap으로 구성
        for (char x: s2.toCharArray()) {
            originMap.put(x, originMap.getOrDefault(x, 0) + 1);
        }


        // s2요소까지 현재 구성 요소 채우기
        for(int rt = 0; rt < s2.length(); rt++) {
            char t = s1.charAt(rt);
            curMap.put(t, curMap.getOrDefault(t, 0) + 1);
        }

        if(originMap.equals(curMap)) {
            answer++;
        }


        // 이후에 curMap two pointer로 업데이트 및 equals 비교
        for(int rt = s2.length(); rt < s1.length(); rt++) {

            // lt 제거
            char ltt = s1.charAt(lt);
            Integer ti = curMap.get(ltt);
            if(ti == 1){
                curMap.remove(ltt);
            }else {
                curMap.put(ltt, ti - 1);
            }
            lt++;

            // rt 추가
            char rtt = s1.charAt(rt);
            curMap.put(rtt, curMap.getOrDefault(rtt, 0) + 1);


            // 비교
            if(originMap.equals(curMap)) {
                answer++;
            }

        }


        return answer;
    }
}
