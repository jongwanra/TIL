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

## Error란?
* Java에서 Error란 주로 System Level에서 발생하는 심각한 문제를 나타낸다.
* 프로그램 외부에서 발생한다.
* 프로세스에 영향을 준다.
* StackOverflowError, OutOfMemoryError, NoClassDefFoundError

## Exception이란?
* Java에서 Exception이란 런타임 및 컴파일 시에 발생할 수 있는 예상 가능한 문제를 나타낸다.
* Program 내부에서 나타낸다.
* Thread에만 영향을 준다.
* checked exception, unchecked exception으로 구분된다.
  * checked Exception: 컴파일 시에 발생할 수 있는 예상 가능한 문제를 나타낸다.
  * unchecked Exception: 런타임 시에 발생할 수 있는 예상 가능한 문제를 나타낸다.

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
public class MismatchPasswordException extends RuntimeException {
	public MismatchPasswordException() {
		super(StatusCode.MISMATCH_PASSWORD.getMessage());
	}
}
```
위의 코드와 같이 `MismatchPasswordException` class명을 통해서 사용자에게 비밀번호가 일치하지 않다는 메시지를 전달함으로써 커뮤니케이션이 가능하다.

## Exception의 종류
* checked Exception
* unchecked Exception


## Unchecked Exception이란?
* Compile시에 확인 되지 않은 Exception을 말한다.
* Exception 하위의 RuntimeException을 상속 받은 class들을 의미한다.
* NullPonteException, ArrayIndexOutOfBoundException, IllegalArgumentException, ArithmeticException

## Checked Exception이란?
* Compile시에 잡히는 예외를 말한다?
* Exception Class를 확장한 class들을 의미한다.




