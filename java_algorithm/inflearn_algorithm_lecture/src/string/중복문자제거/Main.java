package string.중복문자제거;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println(main.mySolution(sc.next()));
        System.out.println(main.lectureSolution(sc.next()));

    }

    /*
    * indexOf로 해결
    * indexOf는 첫 번째로 발견된 index를 찾는 메소드이기 때문
    * */
    private String lectureSolution(String str) {
        String answer = "";
        for(int i = 0; i < str.length(); i++) {
            if(str.indexOf(i) == i){
                answer += str.charAt(i);
            }
        }
        return answer;
    }

    /*
     * 접근 방법
     * HashMap을 이용해서 중복으로 값이 들어간 알파벳에 대해서 체크 하기
     * 반복문으로 순회하면서 값이 기존에 들어갔는지 체크 및 없을 때 add, 존재하면 pass
     * */
    private String mySolution(String str) {
        HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();
        StringBuilder sb = new StringBuilder();
        for (char t : str.toCharArray()) {
            Boolean isExist = hashMap.get(t);
            if (isExist != null) {
                continue;
            }
            sb.append(t);
            hashMap.put(t, true);
        }
        return sb.toString();
    }
}
