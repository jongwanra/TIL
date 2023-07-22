package string.특정_문자_뒤집기;

import java.util.*;
public class Main {

    // Charater static method 에 isAlphabetic이 존재하는구나..!
    private String lectureSolution(String str) {
        char[] s = str.toCharArray();
        int lt= 0, rt= str.length() - 1;
        while(lt < rt) {
            if(!Character.isAlphabetic(s[lt])) {
                lt++;
            }else if(!Character.isAlphabetic(s[rt])) {
                rt--;
            }else {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(s);
    }
    private boolean isAlphabet(char t) {
        if(t >= 65 && t <= 90) {
            return true;
        }
        if(t >= 92 && t <= 117) {
            return true;
        }
        return false;
    }
    private String mySolution(String str) {
        char[] s = str.toCharArray();

        int leftIdx = 0;
        int rightIdx = s.length - 1;

        while(leftIdx < rightIdx) {
            // 둘다 알파벳이면 뒤집기
            if(this.isAlphabet(s[leftIdx]) && this.isAlphabet(s[rightIdx])) {
                char tmp = s[leftIdx];
                s[leftIdx] = s[rightIdx];
                s[rightIdx] = tmp;
                leftIdx++;
                rightIdx--;
                continue;
            }
            while(!this.isAlphabet(s[leftIdx]) && leftIdx < rightIdx) {
                leftIdx++;
            }

            while(!this.isAlphabet(s[rightIdx]) && leftIdx < rightIdx) {
                rightIdx--;
            }
        }
        return String.valueOf(s);
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        System.out.println(main.mySolution(scanner.next()));
    }
}
