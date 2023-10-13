# Chapter02. 자바의 절차적/구조적 프로그래밍s

## JDK/JRE/JVM의 차이

* JDK(Java Development Kit)
  * JVM용 소프트웨어 개발 도구
* JRE(Java Runtime Environment)
  * JVM용 OS
* JVM(Java Virtual Machine)
  * 가상 컴퓨터

* **자바 개발 도구인 JDK를 이용해 개발된 프로그램은 JRE에 의해 가상의 컴퓨터인 JVM 상에서 구동된다.**
* JDK는 자바 소스 컴파일러인 javac.exe를 포함하고 있다.
* JRE는 자바 프로그램 실행기인 java.exe를 포함하고 있다.


## 함수(Function)와 메서드(Method)의 차이

전혀 다르지 않다. 절차적/구조적 프로그래밍에서는 함수라고 불렀는데 객체 지향에서는 좀 다르게 불러야 하지 않을까? 그래서 메서드라고 불렀다고 한다.


## 아래의 프로그램은 어떻게 실행될까?

```java
public class Start {
	public static void main(Stirng[] args){
		System.out.println("Hello OOP!!");
    }
}
```

1. JRE는 먼저 프로그램 안에 main() method가 있는지를 확인한다.
2. main() method의 존재를 확인하면 JRE는 프로그램 실행을 위한 사전 준비를 시작한다.
3. 가상 머신인 JVM에 전원을 넣어 부팅한다.
4. 부팅된 JVM은 목적 파일을 받아 그 목적 파일을 실행한다.
5. 부팅이 완료된 JVM은 가장 먼저 java.lang 패키지를 T 메모리의 스태틱 영역에 가져다 놓는다.(그렇기 때문에 System.out.println() 같은 메서드를 사용이 가능하다.)
6. JVM은 개발자가 작성한 모든 클래스와 임포트 패키지 역시 스태틱 영역에 가져다 놓는다.