package java8_updated;

import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionTest {
	public static void main(String[] args) {
		Supplier<String> getMyName = () -> {
			return "name";
		};
		
		System.out.println("getMyName.get() = " + getMyName.get());
		
		Function<Integer, String> what = (x) -> String.valueOf(x);
		System.out.println("what = " + what.apply(111) instanceof String);
		;
		
		;
	}
}
