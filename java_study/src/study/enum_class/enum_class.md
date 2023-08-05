# Enum

* Enum에 대해서 들어가면 들어갈 수록, 깊은 내용이구나 하는 생각이 절로 든다.
* Enum을 이해하려면 class, static, singleton, 등 다양한 부분에 대해서 익히고 있어야 한다는 생각이 많이 들었다.

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

> 타입에 안전하다.
* enum type을 parameter로 받는 method에 다른 타입 혹은 enum type에 존재하지 않는 값을 넣을 경우 compile 시에 잡을 수 있다.

> Enum은 클래스이기 때문에 Constructor, Method, Interface, Field등 추가가 가능하다.

> Enum은 각자의 이름 공간이 있기 때문에 상수값이 동일해도 공존할 수 있다.


```java

public enum FRUIT {
    // 각자의 이름 공간이 있기 때문에 상수 값이 동일해도 문제가 없다.
    APPLE(2000),
    BANANA(2000),
    ORANGE(3000);
    
    
    private final int price;
    FRUIT(int price) {
        this.price = price;
    }
}
```

> toString Method를 Override하는 것이 가능하다.
> Enum Class는 values() method를 사용하여 전체 타입에 대한 정보를 배열로 가져올 수 있다.
> Enum은 완전한 싱글톤이기 때문에 안정성이 보장된다.

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
위의 enum class는 아래와 유사한 형태를 가지고 있는 싱글톤이다.

```java
class Fruit {
  public static final String ORANGE = "ORANGE";
  public static final String APPLE = "APPLE";
  public static final String BANANA = "BANANA";
}

public class Main {
  public static void main(String[] args) {
    System.out.println(Fruit.APPLE == Fruit.APPLE);
    
  }
}

```

* 하지만, 생성자를 클래스 내부가 아닌 외부에서 호출은 불가능하다.
* 즉, enum Class는 생성자에 한해서 private, package-private Access Modifier를 사용해야 한다.
* 그리고, 동적 할당이 불가능하다. 
* enum class에서는 해당 클래스의 상수들을 array순서대로 반환해주는 values() Method가 존재한다.


## Reference 
* 자바의 신(이상민 저)
* Effective Java 