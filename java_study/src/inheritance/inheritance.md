# Inheritance

Inheritance should only be used when subclass ‘is a’ superclass. Don’t use inheritance to get code reuse. If there is no ‘is a’ relationship, then use composition for code reuse.

## Purpose of Inheritance

* 상속의 주된 목적은 `코드의 재사용성`이다.
* 부모 클래스를 상속 받은 자식 클래스는 부모클래스의 public or protected 접근 제어자로 선언된 상태와 행위를 사용할 수 있다.

## Inheritance란?
* 상속은 기존에 존재하는 클래스로 부터 (public 혹은 protected의 접근 제어자를 가진) 멤버(상태와 행위)들을 위임받을 수 있는 메커니즘이다.
* 여기서 말하는 기존에 존재하는 클래스를 SuperClass라고 하고, 위임 받은 Class를 Sub Class라고 한다.
* 자바에서는 단일 상속만 지원하며 SubClass에서 extends keyword를 사용하여 상속을 받을 수 있다.
* 상속은 `is-a 관계`에 사용하는 것이 적절하다.
  * Employee is a Person


## 상속 예시

```java

// Super Class
class Animal {
    // public, protected 접근 제어자가 적혀있는 멤버를 자식 클래스에서도 사용할 수 있다.
    private int footCount;

    public Animal(int footCount) {
        this.footCount = footCount;
    }

    protected void eat() {
        System.out.println("eat!");
    }

    protected void sleep () {
        System.out.println("sleep!");
    }

    protected int getFootCount() {
        return footCount;
    }
}

// Sub Class
public class Person extends Animal {
    private static final int FOOT_COUNT = 2;
    private String name;
    private int age;

    public Person(String name, int age) {
        super(FOOT_COUNT);
        this.name = name;
        this.age = age;

    }

    // 오버라이딩을 통해 자식 클래스에서 원하는 메서드 내용으로 변경이 가능하다.
    @Override
    protected void eat() {
        System.out.println(name + " is eating");
    }

    @Override
    protected void sleep() {
        System.out.println(name + " is sleeping");
    }

    public static void main(String[] args) {
        Person jongwan = new Person("jongwan", 29);
        
        jongwan.eat();
        jongwan.sleep();
        
        // 부모 클래서의 method에 접근 가능하다.
        System.out.println(jongwan.getFootCount());
    }
}

```

## 상속의 단점?!
* 상속은 결합성이 매우 높기 때문에 유연성과 유지 보수성이 떨어진다. 
* 상속은 캡슐화가 깨질 위험이 다분하다.(갑작스럽게 Super-Class의 method가 변경이 될 경우)
* 상속은 단일 상속만 가능하다.
* 자식 클래스에 불필요한 field 혹은 method까지 가질 수 있기 때문에 복잡하다.

## Encapsulation(캡슐화)
* 외부로 부터 내부 상태와 동작에 대해서 숨기고 접근을 제어하며, 외부와는 인터페이스를 통해 상호 작용하는 메커니즘을 말한다.  

## Composition(조합)
* 조합은 `has-a 관계`를 가질 때 적합하다.
  * Car has a Engine
  * Person has a Family


## Composition의 장점
* 조합은 다중 상속이 가능하다.
* 조합은 상속과 달기 굉장히 유연하다(Flexibility).
* 코드의 재사용성 역시 장점으로 가져갈 수 있다.
* 캡슐화의 문제점도 사라진다.



## Reference 
* https://www.geeksforgeeks.org/favoring-composition-over-inheritance-in-java-with-examples/