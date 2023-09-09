package hashing_and_parsing.한번_사용한_최초문자;

import java.util.*;

class Solution {
	public static void main(String[] args) {
		Solution T = new Solution();
		System.out.println(T.solution("statitsics"));
		System.out.println(T.solution("aabb"));
		System.out.println(T.solution("stringshowtime"));
		System.out.println(T.solution("abcdeabcdfg"));
	}
	
	public int solution(String s) {
		HashMap<Character, Integer> hm = new HashMap<>();
		char[] charArr = s.toCharArray();
		for (char x : charArr) {
			hm.put(x, hm.getOrDefault(x, 0) + 1);
		}
		
		for (int i = 0; i < charArr.length; i++) {
			if (hm.get(charArr[i]) != null && hm.get(charArr[i]) == 1) {
				return i + 1;
			}
		}
		return -1;
	}
}
