package simulation_and_implements.사다리_타기;

import java.util.*;

/*
 * 40분 이상 걸림 -> 문제 해설 단계에서 품
 * 왜? => 문제를 너무 어렵게 생각했다.
 * ladder를 활용하지 못하고 board라는 2차원 배열을 이용해서 문제를 풀려고 접근했다.
 *
 * */
class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(5, new int[][] {{1, 3}, {2, 4}, {1, 4}})));
		System.out.println(Arrays.toString(T.solution(7, new int[][] {{1, 3, 5}, {1, 3, 6}, {2, 4}})));
		System.out.println(Arrays.toString(T.solution(8, new int[][] {{1, 5}, {2, 4, 7}, {1, 5, 7}, {2, 5, 7}})));
		System.out.println(Arrays.toString(
			T.solution(12, new int[][] {{1, 5, 8, 10}, {2, 4, 7}, {1, 5, 7, 9, 11}, {2, 5, 7, 10}, {3, 6, 8, 11}})));
	}
	
	public char[] solution(int n, int[][] ladder) {
		char[] answer = new char[n];
		for (int i = 0; i < n; i++) {
			answer[i] = (char)('A' + i);
		}
		
		for (int[] l : ladder) {
			for (int x : l) {
				swap(answer, x - 1, x);
			}
		}
		
		return answer;
	}
	
	private void swap(char[] answer, final int idx1, final int idx2) {
		char tmp = answer[idx1];
		answer[idx1] = answer[idx2];
		answer[idx2] = tmp;
	}
	
}
