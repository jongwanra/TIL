package java8_updated;

@FunctionalInterface
interface Calculate {
	int add(final int x, final int y);
}

public class LambdaTest {
	public static void main(String[] args) {
		Calculate operationAddWithAnonymous = new Calculate() {
			@Override
			public int add(int x, int y) {
				return 0;
			}
		};
		
		Calculate operationAddWithLambda = (x, y) -> x + y;
		System.out.println("operationAddWithLambda = " + operationAddWithLambda.add(1, 2));
	}
	
}
