package level4.자동완성;

import java.util.HashMap;
import java.util.Map;

// 45분 정도 소요..
// 실패
// 원인: 아이디어는 떠올랐지만 구현 능력이 부족하다.
// https://school.programmers.co.kr/learn/courses/30/lessons/17685
public class Solution240119 {

	static class Node {
		char word;
		int nextCount = 0;
		Map<Character, Node> nextMap = new HashMap<>();

	}


	public int solution(String[] words) {
		Node rootNode = new Node();

		for (String word : words) {
			Node currentNode = rootNode;
			for (Character currentChar : word.toCharArray()) {
				Map<Character, Node> currentMap = currentNode.nextMap;
				if(currentMap.get(currentChar) == null) {
					Node nextNode = new Node();
					currentMap.put(currentChar, nextNode);
					currentNode.nextCount++;
					currentNode = nextNode;
				}else {
					Node nextNode = currentMap.get(currentChar);
					nextNode.nextCount++;
					currentNode = nextNode;
				}
			}
		}

		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
		Solution240119 solution = new Solution240119();

		String[] caseOne = {"go", "gone", "guild"}; // 7
		String[] caseTwo = {"abc", "def", "ghi", "jklm"}; // 4

		solution.solution(caseOne);
		solution.solution(caseTwo);
	}
}
