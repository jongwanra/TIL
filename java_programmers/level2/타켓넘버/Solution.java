// 타겟 넘버
// https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java

/*
* 접근 방법
* 0으로 시작해서 마지막 depth일 경우의 숫자에 대한 카운트를 하면 될것 같다.
* dfs로 접근해 보자.
*
* */
package level2.타켓넘버;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public int solution(int[] numbers, int target) {
        int depth = numbers.length;
        int answer = 0;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        hashMap.put(0, new ArrayList<Integer>(Arrays.asList(numbers[0], -numbers[0])));

        for(int loop = 1; loop < depth; loop++) {
            ArrayList<Integer> prevList = hashMap.get(loop - 1);
            hashMap.put(loop, new ArrayList<Integer>());
            for(Integer prev: prevList) {
                hashMap.get(loop).add(prev + numbers[loop]);
                hashMap.get(loop).add(prev + -numbers[loop]);
            }
        }

        for(Integer element: hashMap.get(depth - 1)){
            if(element == target) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{4, 1, 2, 1}, 4);

    }
}
