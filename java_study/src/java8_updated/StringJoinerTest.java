package java8_updated;

import java.util.StringJoiner;

public class StringJoinerTest {
	public static void main(String[] args) {
		String[] stringArray = {"StudyHard", "God of Java", "Book"};
		
		StringJoiner joiner = new StringJoiner(",", "(", ")");
		for (String s : stringArray) {
			joiner.add(s);
		}
		
		System.out.println("joiner = " + joiner);
	}
}
