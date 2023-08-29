package error_and_exception;

public class TryCatchTest {
	public static void main(String[] args) {
		TryCatchTest main = new TryCatchTest();
		try {
			main.checkOneDepth();
		} catch (Exception e) {
			System.out.println("qqqqq");
		}
	}
	
	private void checkOneDepth() {
		checkTwoDepth();
	}
	
	private void checkTwoDepth() {
		throw new RuntimeException("2222");
	}
}
