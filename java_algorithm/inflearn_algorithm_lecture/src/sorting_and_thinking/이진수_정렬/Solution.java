package sorting_and_thinking.이진수_정렬;

import java.sql.Array;
import java.util.*;

class NumInfo implements Comparable<NumInfo> {
	int origin, countOfOne;
	
	NumInfo(final int origin) {
		this.origin = origin;
		this.countOfOne = makeCountOfOne();
	}
	
	private int makeCountOfOne() {
		int count = 0;
		int copiedOrigin = origin;
		while (copiedOrigin > 1) {
			if (copiedOrigin % 2 == 1) {
				count++;
			}
			copiedOrigin = copiedOrigin / 2;
		}
		return count;
	}
	
	@Override
	public int compareTo(NumInfo n) {
		if (this.countOfOne == n.countOfOne) {
			return this.origin - n.origin;
		}
		return this.countOfOne - n.countOfOne;
	}
}

class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(Arrays.toString(T.solution(new int[] {5, 6, 7, 8, 9})));
		System.out.println(Arrays.toString(T.solution(new int[] {5, 4, 3, 2, 1})));
		System.out.println(Arrays.toString(T.solution(new int[] {12, 5, 7, 23, 45, 21, 17})));
	}
	
	public int[] solution(int[] nums) {
		ArrayList<NumInfo> numInfos = new ArrayList<>(nums.length);
		
		for (int i = 0; i < nums.length; i++) {
			numInfos.add(new NumInfo(nums[i]));
		}
		
		Collections.sort(numInfos);
		
		return numInfos.stream()
			.mapToInt((v) -> v.origin)
			.toArray();
	}
}
