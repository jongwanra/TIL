package letter_combinations_of_a_phone_number;
import java.util.*;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/description
class Solution {
	static HashMap<Character, Character[]> hm;
	public List<String> letterCombinations(String digits) {
		List<String> answer = new ArrayList<>();
		hm = new HashMap<>();
		hm.put('2', new Character[]{'a', 'b','c'});
		hm.put('3', new Character[]{'d', 'e','f'});
		hm.put('4', new Character[]{'g', 'h','i'});
		hm.put('5', new Character[]{'j', 'k','l'});
		hm.put('6', new Character[]{'m', 'n','o'});
		hm.put('7', new Character[]{'p', 'q','r', 's'});
		hm.put('8', new Character[]{'t', 'u','v'});
		hm.put('9', new Character[]{'w', 'x','y', 'z'});
		
		char[] charArr = digits.toCharArray();
		if(charArr.length == 0) {
			return answer;
		}
		StringBuilder sb = new StringBuilder();
		dfs(charArr, 0, charArr.length, answer, sb);
		
		return answer;
	}
	
	private void dfs(char[] digits, final int curDepth, final int endDepth, List<String> answer, StringBuilder sb) {
		// finished
		if(curDepth == endDepth) {
			answer.add(sb.toString());
			return;
		}
		
		// recursive
		Character[] curTarget = hm.get(digits[curDepth]);
		for(int i = 0; i < curTarget.length; i++) {
			sb.append(curTarget[i]);
			dfs(digits, curDepth + 1, endDepth, answer, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
	
}