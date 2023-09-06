package optional;

import java.util.Optional;

public class OptionalMethod {
	public static void main(String[] args) {
		System.out.println(Optional.empty());
		
		Optional<Object> nullable = Optional.ofNullable(null);
		
		String s = "jongwan";
		
		Optional<String> s1 = Optional.of(s);
		s1.orElse("name");
	}
}
