package utilization_of_data_structure.최대_길이_연속_수열;

import java.util.*;

class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.otherSolution1(new int[] {8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
		System.out.println(T.otherSolution1(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
		System.out.println(T.otherSolution1(new int[] {3, 3, 3, 3, 3, 3, 3, 3}));
		System.out.println(T.otherSolution1(new int[] {-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
		System.out.println(T.otherSolution1(new int[] {-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
	}
	
	public int solution(int[] nums) {
		int answer = 1;
		
		Arrays.sort(nums);
		
		for (int i = 1; i < nums.length; i++) {
			int curCount = 1;
			while (i < nums.length && (nums[i - 1] + 1 == nums[i] || nums[i - 1] == nums[i])) {
				if (nums[i - 1] + 1 == nums[i]) {
					curCount++;
				}
				i++;
			}
			answer = Math.max(curCount, answer);
		}
		return answer;
	}
	
	/*
	 * 문제 접근
	 * Set 자료 구조를 이용한 중복제거
	 * Set 자료구조에서 탐색을 시도.(하지만 그 다음 +1 의 수를 중복적으로 순회하는 것을 방지 하기 위해 트리거를 만들어 놓자)
	 * */
	private int otherSolution1(int[] nums) {
		
		HashSet<Integer> set = new HashSet<>();
		for (int x : nums) {
			set.add(x);
		}
		
		int answer = 0;
		for (int x : set) {
			if (set.contains(x - 1)) {
				continue;
			}
			int count = 1;
			while (set.contains(x + 1)) {
				count++;
				x++;
			}
			answer = Math.max(answer, count);
		}
		return answer;
	}
}
