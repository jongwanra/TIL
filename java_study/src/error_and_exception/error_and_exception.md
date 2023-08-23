# Error와 Exception

## Exception과 Error의 전체 계층 구조
![Error와 Exception 전체 계층 구조](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fbl3YyZ%2FbtqzxB7Z585%2F0K5euztPye3Tj1be2PdjOK%2Fimg.png)
* Object
  * Throwable
    * Error
      * StackOverFlowError
      * OutOfMemoryError
      * VirtualMachineError
      * NoClassDefFoundError
      * ...
    * Exception
      * RunTimeException(UncheckedException)
        * NullPointerException
        * IllegalStateException
        * IllegalArgumentException
        * ...
      * 그외의 Exception(CheckedException)
        * IOException
        * 

## Java에서 Error와 Exception이란?
Error는 주로 System Level에서 발생하는 예측 불가능하고 심각한 문제를 나타냅니다. 
프로세스에 영향을 미치며, 프로그램 외부에서 발생합니다. 
대표적인 Error로 OutOfMemoryError, StackOverFlowError, NoClassDefFound Error 등이 있습니다.
그리고 Exception은 예측 가능한 문제를 나타냅니다. Error와 다르게 Thread에 영향을 미치며 프로그램 내부에서 발생하는 특징을 가지고 있습니다.

## Checked Exception과 Unchecked Exception?
Checked Exception과 Unchecked Exception은 어느 시점에 발생하는 문제인지에 따라 나눌 수 있습니다.
Checked Exception은 컴파일 시에 발생하는 예외이고, Unchecked Exception은 런타임 시에 발생하는 예외입니다.
계층 구조를 통해 파악해 보면 Exception 하위의 RuntimeException을 포함한 하위 클래스들이 UncheckedException이고, 나머지 Exception을 CheckedException입니다.
CheckedException 같은 경우 컴파일 시에 예외가 발생하기 때문에 따로 예외처리를 해주거나 throws keyword를 사용하여 호출한 method에게 예외처리를 위임해야 합니다.


## Error와 Exception 차이점은?
* 각각 개발자가 컨트롤할 수 있는 문제인지 컨트롤 할 수 없는 문제인지에 따라 구분된다.
* 시스템 외부에서 발생한 문제인지, 시스템 내부에서 발생한 문제인지에 따라 구분된다.
* Process에 영향을 미치는지, Thread에 영향을 미치는지에 따라서도 차이가 존재한다.


## Exception은 주로 어떤 용도로 사용되나?
* 사용자와의 커뮤니케이션 용도로 사용이 된다.

```java
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
```

```java
public class MismatchPasswordException extends MismatchPasswordException {
	public MismatchPasswordException() {
		super(StatusCode.MISMATCH_PASSWORD.getMessage());
	}
}
```
위의 코드와 같이 `MismatchPasswordException` class명과 "비밀번호가 일치하지 않습니다." 메세지를 통해서 사용자에게 비밀번호가 일치하지 않다는 메시지를 전달함으로써 커뮤니케이션이 가능하다.





