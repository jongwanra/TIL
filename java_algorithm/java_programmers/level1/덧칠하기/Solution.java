package level1.덧칠하기;

import java.util.LinkedList;

/*
* 접근 방법
* 1. section에서 제공되는 배열로 순회
* 2. deque로 요소를 FIFO하면서 칠해진 공간을 빼나감.
* 3. 현재 칠해진 공간에 포함되어 있는 경우 계속 뺌
* */
public class Solution {

    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int currentEndPoint = -1;

        LinkedList<Integer> deque = new LinkedList<Integer>();
        for(int e: section){
            deque.add(e);
        }

        while(!deque.isEmpty()) {
            answer++;
            currentEndPoint = deque.removeFirst() + m;
            while(!deque.isEmpty() && currentEndPoint > deque.getFirst()){
                deque.removeFirst();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8, 5 , new int[]{ 2,3,6});
    }
}
