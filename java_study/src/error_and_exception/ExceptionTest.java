package error_and_exception;

public class ExceptionTest {
	public static void main(String[] args) {
		ExceptionTest main = new ExceptionTest();
		main.testException();
	}
	
	private void testException() {
		try {
			login(1L, "123456");
		} catch (MismatchPasswordException e) {
			System.out.println(e.toString());
		}
	}
	
	private void login(final long id, final String password) throws RuntimeException {
		if (!password.equals("123455")) {
			throw new MismatchPasswordException();
		}
	}
}
