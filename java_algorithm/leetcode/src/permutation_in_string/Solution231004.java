package permutation_in_string;

import java.util.HashMap;
import java.util.Map;


// Not Solved
// 내일 다시 풀어보기
public class Solution231004 {
	public boolean checkInclusion(String s1, String s2) {
		int[] originCount = new int[26];
		int[] copiedCount = new int[26];

		for (int i = 0; i < s1.length(); i++) {
			int idx = s1.charAt(i) - 'a';
			originCount[idx]++;
			copiedCount[idx]++;
		}

		int left = 0;
		int right = 0;

		while (right < s2.length()) {
			// 유효한 문자일 경우
			if (copiedCount[s2.charAt(right) - 'a'] > 0) {
				copiedCount[s2.charAt(right) - 'a']--;
				if ((right - left + 1) == s1.length()) {
					return true;
				}
				right++;
				continue;
			}

			if (originCount[s2.charAt(left) - 'a'] > 0) {
				copiedCount[s2.charAt(left) - 'a']++;
				left++;
				continue;
			}

			right++;
			left = right;

		}
		return false;
	}

	public static void main(String[] args) {
		Solution231004 main = new Solution231004();
		System.out.println(main.checkInclusion("ba", "eidbaooo"));
	}
}