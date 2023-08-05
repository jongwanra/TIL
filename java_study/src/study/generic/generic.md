# Generic


## Generic
* Generic의 사전적 의미는 '일반적인', '범용적인'이다
* 제네릭은 클래스 내부에서 타입을 지정하는 것이 아닌 외부에서 사용자에 의해 지정되는 것을 의미한다.
* class 를 Generic Type으로 설계한다면, public class Stack<E> {} 와 같이 구성하고 외부에서 Stack<Integer> stack = new Stack<>(); 와 같이 지정해서 사용할 수 있다.

## Generic이 자바에 추가된 이유
* 타입 형변환에서 발생할 수 있는 문제점을 컴파일 시에 체크해 없애기 위해서 추가가 되었다.

## wildcard 타입
* ? 로 명시한 타입
* wildcard는 메소드의 매개 변수로만 사용하는 것이 좋다.

## bounded wild card
* ? extends 타입
* 사용 하는 타입을 제한할 수 있음.
* 

## 용어 정리
* generic type(제네릭 타입): List<E>
* parameterized type(매개변수화 타입): List<String>
* actual type parameter(실제 타입 매개변수): String
* formal type parameter(정규 티입 매개변수): E, V, S...
* unbounded wildcard type(비한정적 와일드카드 타입): List<?>
* bounded wildcard type(한정적 와일드카드 타입): List<? extends Number>
* raw type(로 타입):List
* bounded type parameter(한정적 타입 매개변수): <E extends Number> 
* recursive type bound(재귀적 타입 한정): <T extends Comparable<T>>
* generic method(제네릭 메서드): static <E> List<E> as List(E[] a)
* type token(타입 토큰): String.class?





## Reference
* https://medium.com/%EC%8A%AC%EA%B8%B0%EB%A1%9C%EC%9A%B4-%EA%B0%9C%EB%B0%9C%EC%83%9D%ED%99%9C/java-generic-%EC%9E%90%EB%B0%94-%EC%A0%9C%EB%84%A4%EB%A6%AD-f4343fa222df
* https://docs.oracle.com/javase/tutorial/java/generics/methods.html
