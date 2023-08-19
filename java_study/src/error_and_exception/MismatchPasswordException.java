package error_and_exception;

public class MismatchPasswordException extends RuntimeException {
	
	public MismatchPasswordException() {
		super(StatusCode.MISMATCH_PASSWORD.getMessage());
	}
	
}
