# Java Is Pass By What?

## Pass By Value란? (파라미터 전달 방식이다?!)

* Pass By Value는 함수의 파라미터로 변수를 전달하는 방법 중 `값을 복사해서 전달하는 방식`
* Pass by value: makes a copy in memory of the parameter's value, or a copy of the contents of the parameter.
* 즉, 원래의 값에 영향을 주지 않고 함수 내로 복사된 값을 전달한다.
* 값을 복사하기 때문에 변수의 크기가 클수록 비용이 증가하게 된다.

## Pass By Reference(= Call By Reference)

* Pass By Reference는 함수의 파라미터로 변수를 전달하는 방법 중 `변수의 주소를 전달하는 방식`
* 즉, 변수의 주소를 전달하기 때문에 원래 변수의 값에도 영향을 주게 된다.
* 값을 복사하지 않고 주소를 전달하기 때문에 변수의 크기에 상관 없이 비용이 일정하다.


## Java에서의 파라미터 전달 방식은 Pass By Value이다.

이 부분에 대해서 Stack에서 변수가 어떻게 저장이 되는지 궁금증이 생겨 알아 보게 되었다.
[Oracle 공식 문서](https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html#jvms-2.6)

## Frames
> A frame is used to store data and partial results, as well as to perform dynamic linking, return values for methods, and dispatch exceptions. A new frame is created each time a method is invoked. A frame is destroyed when its method invocation completes, whether that completion is normal or abrupt (it throws an uncaught exception). Frames are allocated from the Java Virtual Machine stack (§2.5.2) of the thread creating the frame. Each frame has its own array of local variables (§2.6.1), its own operand stack (§2.6.2), and a reference to the run-time constant pool (§2.5.5) of the class of the current method.
* 새로운 프레임은 매번 메서드가 호출 될때 생성 되고 메소드 호출이 마무리가 되면 사라진다.
* 프레임은 프레임을 생성하는 스레드의 JVM Stack으로 부터 할당 받는다(?)
* Frame은 아래의 구성 요소를 가지고 있다
  * array of local variables(compile 시점에 사이즈가 결정됨)
    * boolean, byte, char, short, int, float, reference, or returnAddress
    * A value of type long or type double occupies two consecutive local variables.
  * operand stack
  * a reference to the run-time constant pool of the class of the current method.

## Local Variable Array
* 각 프레임 마다 Local Variable Array를 가지고 있다. 
* Local Variable Array의 길이는 컴파일 시에 결정 된다.


Method가 호출 시, 해당 메소드에 대한 Frame이 Stack에 쌓이게 된다. 
Frame 내부에 Local Variable Array가 존재하고, 이 안에 파라미터 부터 순서대로 변수들이 저장된다. 이때 Parmeter들은 Pass By Value로 복사가 되어서 Local Variable Array에 넣어진다.


## Why Java is Passed By Value?

> Often, the confusion around these terms is a result of the concept of the object reference in Java. Technically, Java is always pass by value, because even though a variable might hold a reference to an object, that object reference is a value that represents the object’s location in memory. Object references are therefore passed by value.
## Reference 
* https://docs.oracle.com/javase/specs/jvms/se11/html/jvms-2.html#jvms-2.6
* https://www.cs.virginia.edu/~jh2jf/courses/cs2110/java-pass-by-value.html
* https://www.cs.virginia.edu/~jh2jf/courses/cs2110/java-pass-by-value.html
* https://mangkyu.tistory.com/107
* https://www.digitalocean.com/community/tutorials/java-is-pass-by-value-and-not-pass-by-reference

* https://stackoverflow.com/questions/2229498/passing-by-reference-in-c
  * c언어 관련 참고