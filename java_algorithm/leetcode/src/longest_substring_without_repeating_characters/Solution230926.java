package longest_substring_without_repeating_characters;
import java.util.*;
public class Solution230926 {

	public int lengthOfLongestSubstring(String s) {
		if(s.length() == 0) {
			return 0;
		}

		Map<Character, Integer> map = new HashMap<>();
		char[] arr = s.toCharArray();
		int leftIdx = 0;
		int maxLength = 1;
		map.put(arr[0], 1);

		for(int rightIdx = 1;  rightIdx < arr.length; rightIdx++) {
			map.put(arr[rightIdx], map.getOrDefault(arr[rightIdx], 0) + 1);
			maxLength = Math.max(maxLength, map.size());

			if(map.get(arr[rightIdx]) == 1) {
				continue;
			}

			while (map.get(arr[rightIdx]) > 1 && leftIdx < rightIdx) {
				map.put(arr[leftIdx], map.get(arr[leftIdx]) - 1);
				if(map.getOrDefault(arr[leftIdx], 0) == 0) {
					map.remove(arr[leftIdx]);
				}
				leftIdx++;
			}

		}
		return maxLength;
	}
}
