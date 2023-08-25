# Enum

* Enum에 대해서 들어가면 들어갈 수록, 깊은 내용이구나 하는 생각이 절로 든다.
* Enum을 이해하려면 class, static, singleton, 등 다양한 부분에 대해서 익히고 있어야 한다는 생각이 많이 들었다.

## Enum이란?(23.08.25)
Enum이란, 상수의 집합으로 일종의 클래스이다.
Enum은 굉장히 장점들이 많다.

대표적으로 3가지를 말해보면 
1. 타입의 안전성을 보장한다. Enum Class를 파라미터로 넘길 때 Enum Class가 아닌 타입이 들어온다면 컴파일 시에 에러를 발생시킨다. 그렇기 때문에 타입의 안정성을 보장한다.
2. Enum은 Class이다. 그렇기 때문에 Field, Interface, Method등을 구현할 수 있다.
3. Enum타입은 완전한 싱글턴이다. Class Loader의 초기화 시점에 생성이 되고 프로그램이 종료될 때까지 공유 자원으로써 어디서든 사용이 가능하다. 또한 불변하기 때문에 Thread Safe하다.


## Enum이란?
* Enum은 클래스의 일종으로, 상수의 집합이다.

```java
public enum FRUIT {
    APPLE,
    ORANGE,
    BANANA
}
```

## Enum을 사용하는 이유

* 타입에 안전하다.
  * enum type을 parameter로 받는 method에 다른 타입 혹은 enum type에 존재하지 않는 값을 넣을 경우 compile 시에 잡을 수 있다.

* Enum은 클래스이기 때문에 Constructor, Method, Interface, Field등 추가가 가능하다.

* Enum은 완전한 싱글톤이다. (Enum의 핵심)

```java
enum Fruit {
  ORANGE, APPLE, BANANA
}

public class Main {
  public static void main(String[] args) {
      System.out.println(Fruit.APPLE == Fruit.APPLE);
  }
}

```


## Reference 
* 자바의 신(이상민 저)
* Effective Java 