# Java 8에서 변경 및 추가된 사항들

## 추가된 사항들
1. Optional
2. Interface default method
3. 날짜 관련 클래스들 추가
4. 병렬 배열 정렬
5. StringJoiner 추가
6. Lambda 표현식
7. java.util.function

## 1. Optional 

### Optional?
> A container object which may or may not contain a non-null value. [Oracle - Class Optional<T>](https://docs.oracle.com/javase/8/docs/api/java/util/Optional.html)

Oracle에서 `Optional Class는 null일 수 있는 컨테이너 객체`라고 정의한다.

자바에서 field 혹은 method에 접근할 때 '.'을 활용해서 접근한다. 그런데 null일 경우에는?! 
우리는 `NullPointerException`을 마주하게 된다. 
자바8에서 Optional Class는 `NullPointerException을 피하기 위한 대안`으로 만들어졌다.

### Optional 생성
1. empty(): 데이터가 없는 Optional 객체를 생성할 경우
2. ofNullable(): 널일 수 있는 값일 경우
3. of(): 널이 아닌 값일 경우

### Optional Class에서 값을 꺼낼려면?
1. get() : 반환 값이 null일 경우 NoSuchElementException 발생, null이 아닐 경우 반환한다.
2. orElse(T other): 반환 값이 null일 경우 값으로 제공한 other 반환, null이 아닐 경우 기존 값 반환 
    * 주의 사항: orElse() method는 null여부와 관계 없이 반드시 호출 된다.
3. orElseGet(Supplier<? extends T> supplier): 반환 값이 null일 경우 supplier의 반환 값을 반환, null이 아닐 경우 기존 값 반환
4. orElseThrow()/ orElseThrow(Supplier<? extends T> supplier): 
   * null이 아닐 경우, 기존 값 반환  null일 경우,
   * parameter가 없으면 NoSuchElementException 예외 발생 parameter가 존재하면 해당 Exception 발생


## 2. Interface Default Method

Java 8부터 Interface에 default method를 사용해서 구현할 수 있다.

```java
public interface Person {
	default String getEmail() {
		return "default@gmail.com";
    }
}
```

### Interface Default Method는 왜 나온거지?
`하위 호환성` 때문이다. 협업을 진행하면서 누군가 method를 추가하는 상황이다. 그런데 추가된 interface를 구현한 클래스들 전부에 따로 재정의를 해주지 않으면 반드시 오류가 난다. 
오픈소스 프로젝트에서 interface에 개발자가 따로 method를 추가했다면 해당 오픈소스를 사용하는 분들 모두에게 Exception이 발생할 것이다.

## 3. 날짜 관련 클래스들 추가

### 왜 새로 추가가 되었을까?
Java 8이전에 Date나 SimpleDateFormatter Class는 Thread-Safe하지 않다. 그렇기 때문에 여러 스레드가 접근할 때 예상치 못한 값을 반환했었다.
그리고 불변 객체가 아니기 때문에 상태가 변경될 가능성이 다분했다. 또한 연도는 1900년 부터, 달은 1부터, 일은 0부터 시작한다. 1900, 1, 0을 매개변수로 전달하면 1900년 1월 1일이였다.
이러한 이유 때문에 java.time 패키지가 만들어졌다.

### 갑작스럽게 고민..! 
전세계에서 사용하는 애플리케이션으로 가정했을 때 시간을 어떻게 저장하면 좋을까?

* 현재 생각으로는 UTC(Coordinated Universal Time)를 표준으로 값을 저장한다?
* 조회 시에는 User에 저장된 국가에 따라 데이터를 조회해서 보여준다?


## 4. 병렬 배열 정렬

Java 8부터는 parallelSort가 추가 되었다. Arrays Class의 static method에 위치한다.
parallelSort는 내부적으로 Fork-Join 프레임웍이 사용된다. 

### sort() vs parallelSort()

* sort() method는 싱글 스레드로 동작하고 parallelSort()는 필요에 따라 여러 개의 스레드로 나뉘어 작업을 진행한다.
* parallelSort()는 CPU를 더 많이 사용하게 되겠지만, 처리 속도는 더 빠르다.
* 테스트를 진행했을 떄 대략 5000개 부터 성능이 빨라진다.

```java
import java.util.Arrays;

public class ParallelSortTest {
   public static void main(String[] args) {
      final int size = 5_000;
      int[] arr = new int[size];

      for (int i = size; i > 0; i--) {
         arr[i - size] = i;
      }

      Arrays.parallelSort(arr);
   }
}
```


### 5. String Joiner

```java
public class StringJoinerTest {
	public static void main(String[] args) {
		String[] stringArray = {"StudyHard", "God of Java", "Book"};
		
		StringJoiner joiner = new StringJoiner(",", "(", ")");
		for (String s : stringArray) {
			joiner.add(s);
		}
		
		System.out.println("joiner = " + joiner);
	}
}
```

## 6. Lambda 표현식 & @FunctionalInterface

### 람다는 왜 나왔지?
람다가 나오기 전에는 익명 클래스를 만들어서 적용했었다.
하지만 밑에 Anonymous Class를 보면 가독성도 떨어지고 사용하기 불편하다. 이러한 단점을 보완하기 위해 만들어졌다.
---
람다는 하나의 method를 가지고 있는 interface를 통해서만 만들 수 있다. 람다 표현식은 익명 클래스와 서로 대체 가능하다는 특징이 있다.
또 협업 시에 interface에 람다인지 몰라서 다른 method()를 추가하는 경우를 방지하기 위한 방법으로 @FunctionalInterface가 나왔는데 
다른 메서드를 추가할 경우 컴파일 시 예외를 발생시킨다.


```java
package java8_updated;

@FunctionalInterface
interface Calculate {
	int add(final int x, final int y);
}

public class LambdaTest {
	public static void main(String[] args) {
		// Annonymous Class 
		Calculate operationAddWithAnonymous = new Calculate() {
			@Override
			public int add(int x, int y) {
				return 0;
			}
		};
		
		// Lambda
		Calculate operationAddWithLambda = (x, y) -> x + y;
		
		System.out.println("operationAddWithLambda = " + operationAddWithLambda.add(1, 2));
	}
	
}

```


## 7. java.util.function

Java 8에서 제공하는 주요 Functional Interface는 java.util.function에 존재한다.

* Predicate
  * test() method를 통해 2 객체를 비교할 때 사용한다.
* Supplier
  * get() method가 있으며, 리턴 값은 generic으로 선언된 타입을 리턴한다.
* Consumer
* Function
  * R apply(T t) method가 있으며, 변환이 필요할 때 해당 인터페이스를 사용한다.
* UnaryOperator
* BinaryOperator


## Reference 
* 자바의 신(이상민 저) - Java 8에 추가된 것들은?