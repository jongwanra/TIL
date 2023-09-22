package valid_parentheses;
import java.util.*;
public class Solution230922 {
	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();

		for(char c: s.toCharArray()) {
			if(c == '(' || c == '[' ||  c == '{') {
				stack.push(c);
				continue;
			}

			if(stack.isEmpty()) {
				return false;
			}
			char popped = stack.pop();

			if(c == ')' && popped == '(') {
				continue;
			}
			if(c == '}' && popped == '{') {
				continue;
			}
			if(c == ']' && popped == '[') {
				continue;
			}

			return false;
		}

		return stack.isEmpty();
	}


	public boolean isValidV2(String s) {
		Map<Character, Character> closeToOpen = new HashMap<>();
		closeToOpen.put('}', '{');
		closeToOpen.put(')', '(');
		closeToOpen.put(']', '[');

		Deque<Character> stack = new LinkedList<>();

		for(char c: s.toCharArray()) {
			if(!closeToOpen.containsKey(c)) {
				stack.push(c);
				continue;
			}

			if(stack.isEmpty()) {
				return false;
			}

			Character popped = stack.pop();
			if(closeToOpen.get(c) != popped ) {
				return false;
			}
		}

		return stack.isEmpty();
	}


}
