package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		StreamTest main = new StreamTest();
		main.test5();
	}
	
	private void test1() {
		int[] arr = new int[100];
		
		Arrays.stream(arr).map(i -> i + 1).forEach(System.out::print);
		
	}
	
	private void test2() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int sum = list.stream().filter(v -> v % 2 == 0).mapToInt(Integer::intValue).sum();
		System.out.println("sum = " + sum);
	}
	
	private void test3() {
		String[] arr = {"aaaa", "bbbb", "ccccc"};
		Arrays.stream(arr).forEach(System.out::println);
	}
	
	private void test4() {
		List<AppleWrapper> appleWrappers = List.of(
			AppleWrapper.of(new Apple(1, Color.RED)),
			AppleWrapper.of(new Apple(2, Color.RED)),
			AppleWrapper.of(new Apple(3, Color.GREEN)),
			AppleWrapper.of(new Apple(4, Color.GREEN)),
			AppleWrapper.of(new Apple(5, Color.YELLOW)),
			AppleWrapper.of(new Apple(6, Color.YELLOW)),
			AppleWrapper.of(new Apple(7, Color.YELLOW))
		);
		
		List<Dto> threeAppleData = appleWrappers.stream()
			.map(AppleWrapper::ripOpen)
			.peek(apple -> System.out.println(apple.getId()))
			.peek(apple -> System.out.println(apple.getColor()))
			.map(apple -> new Dto(apple))
			.limit(3)
			.collect(Collectors.toList());
		
		System.out.println("threeAppleData = " + threeAppleData);
	}
	
	private void test5() {
		Stream.of("a", "b", "c", "d", "e")
			.filter(s -> {
				System.out.println("filter: " + s);
				return true;
			})
			.limit(2)
			.forEach(s -> System.out.println("forEach: " + s));
		
	}
}
