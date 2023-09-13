package longest_substring_without_repeating_characters;

import java.util.HashSet;

public class Solution {
	
	// two-pointer algoriitm
	public int lengthOfLongestSubstring(String s) {
		char[] charArr = s.toCharArray();
		HashSet<Character> hs = new HashSet<>();
		if(charArr.length == 0) {
			return 0;
		}
		hs.add(charArr[0]);
		int answer = 1;
		int rightIdx = 1;
		
		for(int leftIdx = 0; leftIdx < charArr.length;leftIdx++) {
			while(rightIdx < charArr.length && !hs.contains(charArr[rightIdx])) {
				hs.add(charArr[rightIdx]);
				answer = Math.max(answer, hs.size());
				rightIdx++;
			}
			hs.remove(charArr[leftIdx]);
		}
		
		return answer;
	}
}
