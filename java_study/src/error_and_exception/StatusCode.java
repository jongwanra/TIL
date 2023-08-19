package error_and_exception;

public enum StatusCode {
	NOT_FOUND_MEMBER(400_001, "멤버가 조회되지 않습니다."),
	MISMATCH_PASSWORD(400_002, "비밀번호가 일치하지 않습니다.");
	// ...
	
	private int code;
	private String message;
	
	StatusCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public int getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
}
