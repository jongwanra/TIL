## Checked Exception Vs Unchecked Exception

## 우선 정의부터!

Throwable의 자식 클래스로 Error와 Exception이 존재한다. Exception의 하위 클래스로는 RuntimeException과 나머지 Exception Class가 존재하는데, 
RuntimeException을 포함한 하위 클래스를 Unchecked Exception이라고 하며, 나머지를 CheckedException이라고 한다. 여기서 구분을 하는 기준은 예외가 언제 발생할까인데
UncheckedException은 Runtime 시에 발생하고 checked exception은 컴파일 시에 발생한다.

이 외에 둘의 차이점은 try-catch 또는 throws keyword를 강제로 처리해야하는 checked exception과 처리하지 않아도 되는 unchecked exception이 존재한다.


## 왜 unchecked exception을 훨씬 많이 사용하는 걸까?
첫 번째로 checked exception을 사용할 경우 강제로 try-catch or throws 처리를 해줘야 한다. 해주는 것은 성능상 느리다는 부분도 있지만, 
더 중요한 부분은 catch block 내부에 어떤 내용을 집어 넣어야 하는 걸까? logging을 남길 수 있지만 checked exception의 경우 문제가 발생하면 대부분의 경우 thread가 종료하면서 예외에 대한 로그가 자동으로 남긴다. 
checked exception에 대한 복구가 가능한 로직이 있다면 사용하면 좋지만 그렇지 않을 경우 checked exception을 사용할 이유가 없다.

두 번째로 checked exception은 throws 처리를 하면서 Open Closed Principle(OCP)을 위배한다. 

OCP란 개방 폐쇄의 원칙으로, 수정 없이 확장 되어야 하며 변경에는 닫혀있어야 한다는 의미로 이 중 `변경에는 닫혀있어야 한다.`를 위반했다.
제일 마지막에 호출한 method에서 위임한 checked exception이 변경이 된다면? 해당 method를 호출한 method의 exception 내용도 변경해 줘야한다. (만약에 수십개의 메서드들이 연결되어 있다면 전부 수정해줘야 한다)

세 번째로 Spring Framework 에서 @Transactional 처리를 할 경우 기본값으로 checked exception은 rollback처리를 하지 않게 설정되어 있다.

```java
// 아무 설정을 하지 않는 경우,  기본적으로 UncheckedException과 Error에 한해서 rollback을 해준다.
@Transactional(rollbackFor = { RuntimeException.class, Error.class})
```

그렇기 때문에 checked exception을 사용 시 Transactional 처리는 아래와 같이 지정해줘야 한다.

```java
@Transactional(rollbackFor = { Exception.class, Error.class})
```


## Wrapping Checked Exception?
I/O Exception같은 checked exception이 발생할 경우 catch block에서 따로 unchecked exception을 발생 시키는 것을 말한다.

```java

public class Test{
	private String getContent(Path targetFile) {
		try {
			byte[] content = Files.readAllBytes(targetFile);
			return new String(content);
		} catch (IOException e) {
			// wrapping checked exception
			throw new RepositoryException("Unable to read file content. File: " + targetFile, e);
		}
	}	
}


public class RepositoryException extends RuntimeException {
//...
}
```
## 왜 wrapping checked exception을 해줘야할까?

위의 코드 형식으로 checked Exception 발생 시 catch block에서 unchecked exception을 발생 시키고 있다. 
checked exception은 따로 강제적으로 try-catch 또는 throws를 처리 해줘야 한다. 

총 메서드 호출을 10번 했다고 가정해보자.
wrapping checked exception을 해주지 않는다면, 에러를 핸들링할 방법이 없기 때문에 throws keyword를 통해 최상위 메서드로 위임해야 한다. 이는 OCP를 위반하는 행위이며 exception을 추가하거나 변경 시에 호출한 메서드 만큼 변경해줘야 하는 번거러움과 불편함이 있다.
또한 Spring framework로 개발을 진행할 때 보통 비즈니스 로직에는 데이터의 무결성을 보장하기 위해서 @Transactional을 사용하게 된다. 이 떄 기본값으로 unchecked exception, error에 대해서만 rollback처리가 되어 있기 때문에
따로 설정을 해줘야 한다. 이러한 불편함을 해결하기 위한 방법으로 wrapping checked exception 방법을 사용하고 있다.





## Reference
* Clean Code
* [Checked Exceptions are Evil](https://phauer.com/2015/checked-exceptions-are-evil/)