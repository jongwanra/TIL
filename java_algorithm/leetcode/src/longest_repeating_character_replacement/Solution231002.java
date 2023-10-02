package longest_repeating_character_replacement;

import java.util.HashSet;
import java.util.Set;


// Not Solved
// 재시도 필요
public class Solution231002 {
	public int characterReplacement(String s, int k) {
		int[] count = new int[26];
		int maxCount = 0;
		int maxLength = 0;

		int leftIdx = 0;

		for(int rightIdx = 0; rightIdx < s.length(); rightIdx++ ) {
			char target = s.charAt(rightIdx);
			count[target - 'A']++;
			// ACABA가 주어질 때
			maxCount = Math.max(maxCount, count[target - 'A']);

			while (rightIdx - leftIdx + 1 - maxCount > k) {
				count[s.charAt(leftIdx) - 'A']--;
				leftIdx++;
			}

			maxLength = Math.max(maxLength, rightIdx - leftIdx + 1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		Solution231002 main = new Solution231002();
		System.out.println(main.characterReplacement("ACABA", 1));
	}
}
