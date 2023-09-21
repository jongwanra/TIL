package valid_palindrome;
import java.util.*;

public class Solution230921 {
	
	// 처음 풀었을 떄
	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder();
		
		for(char c: s.toCharArray()){
			if(Character.isAlphabetic(c) || Character.isDigit(c)) {
				sb.append(Character.toLowerCase(c));
			}
		}
		
		String converted = sb.toString();
		final int convertedLength = converted.length();
		for(int i = 0; i < convertedLength; i++) {
			if(converted.charAt(i) != converted.charAt(convertedLength - i - 1))	{
				return false;
			}
		}
		return true;
	}
	
	// 다른 사람 코드 보고 풀었을 떄
	// for-loop 한 번으로 끝내자
	public boolean isPalindromeV2(String s) {
		char[] charArray = s.toCharArray();
		int left = 0;
		int right = charArray.length - 1;
		
		while(left < right) {
			if(!isAlphaNumeric(charArray[left])) {
				left++;
				continue;
			}
			if(!isAlphaNumeric(charArray[right])) {
				right--;
				continue;
			}
			
			if(Character.toLowerCase(charArray[left]) != Character.toLowerCase(charArray[right])) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}
	
	private boolean isAlphaNumeric(char c) {
		if(Character.isDigit(c)) {
			return true;
		}
		if(Character.isAlphabetic(c)) {
			return true;
		}
		return false;
	}
}
