package string.단어_뒤집기;
import java.util.*;
public class Main {


    // StringBuilder로 풀어보기
    // StringBuilder 내부에 reverse Method가 존재한다!
    private ArrayList<String> lectureSolution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x: str) {
            String tmp = new StringBuilder(x).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }


    // 단어 뒤집었을 때, lt와 rt를 활용해서 O(n/2) 성능을 낼 수 있음.
    // String.valueOf(char[] x) => String객체로 변환
    private ArrayList<String> lectureSolution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for(String x: str) {
            char[] s = x.toCharArray();
            int lt=0;
            int rt = x.length() - 1;
            while(lt < rt) {
                char tmp = s[lt];
                s[lt] = s[rt];
                s[rt] = tmp;

                lt++;
                rt--;
            }
            String tmp = String.valueOf(s);
            answer.add(tmp);
        }

        return answer;
    }
    private ArrayList<String> mySolution(int num, String[] strList) {
        ArrayList<String> reversedStrList = new ArrayList<String>(num);
        for(int loop = 0; loop < num; loop++) {
            char[] target = strList[loop].toCharArray();
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = target.length -1; i >= 0; i-- ) {
                stringBuilder.append(target[i]);
            }
            reversedStrList.add(stringBuilder.toString());
        }

        return reversedStrList;
    }

    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        String[] strList = new String[num];
        for(int loop = 0; loop < num; loop++) {
            strList[loop] = scanner.next();
        }
        ArrayList<String> reversedStringList = main.mySolution(num, strList);

        for(int loop = 0; loop < reversedStringList.size(); loop++) {
            System.out.println(reversedStringList.get(loop));
        }
    }
}
