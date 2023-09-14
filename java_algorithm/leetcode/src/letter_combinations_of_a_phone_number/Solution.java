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
		
		char[] combi = new char[4];
		Arrays.fill(combi, '0');
		char[] charArr = digits.toCharArray();
		if(charArr.length == 0) {
			return answer;
		}
		dfs(charArr, 0, charArr.length, answer, combi);
		
		return answer;
	}
	
	private void dfs(char[] digits, final int curDepth, final int endDepth, List<String> answer, char[] combi) {
		// finished
		if(curDepth == endDepth) {
			StringBuilder sb = new StringBuilder();
			for(char x: combi) {
				if(x != '0') {
					sb.append(x);
				}
				
			}
			answer.add(sb.toString());
			return;
		}
		// recursive
		Character[] curTarget = hm.get(digits[curDepth]);
		for(int i = 0; i < curTarget.length; i++) {
			combi[curDepth] = curTarget[i];
			dfs(digits, curDepth + 1, endDepth, answer, combi);
		}
	}
	
}