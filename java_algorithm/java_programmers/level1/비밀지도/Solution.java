package level1.비밀지도;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		List<String> answer = new ArrayList<>(n);
		for(int i = 0; i < n; i++) {
			String binaryValueA = toBinaryString(n, arr1[i]);
			String binaryValueB = toBinaryString(n, arr2[i]);

			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < binaryValueA.length(); j++ ) {
				if(binaryValueA.charAt(j) == '1' || binaryValueB.charAt(j) == '1') {
					sb.append("#");
					continue;
				}
				sb.append(" ");
			}
			answer.add(sb.toString());
		}

		return answer.toArray(new String[0]);
	}

	private String toBinaryString(int n, int value) {
		String format = new StringBuilder()
			.append("%").append(n).append("s").toString();

		return String.format(format, Integer.toBinaryString(value)).replace(" ", "0");
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// String[] answers = solution.solution(5, new int[] {9, 20, 28, 18, 11}, new int[] {30, 1, 21, 17, 28});
		// for (String answer : answers) {
		// 	System.out.println("answer = " + answer);
		// }

		String[] answers = solution.solution(6, new int[] {46,33,33,22,31,50}, new int[] {27,56,19,14,14,10});
		for (String answer : answers) {
			System.out.println("answer = " + answer);
		}
	}
}
