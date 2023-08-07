# Inheritance

## Purpose of Inheritance

* 상속의 주된 목적은 `코드의 재사용성`이다.
* 부모 클래스를 상속 받은 자식 클래스는 부모클래스의 public or protected 접근 제어자로 선언된 상태와 행위를 사용할 수 있다.

## Inheritance란?
* 상속은 기존에 존재하는 클래스로 부터 (public 혹은 protected의 접근 제어자를 가진) 멤버(상태와 행위)들을 위임받을 수 있는 메커니즘이다.
* 여기서 말하는 기존에 존재하는 클래스를 SuperClass라고 하고, 위임 받은 Class를 Sub Class라고 한다.
* 자바에서는 단일 상속만 지원하며 SubClass에서 extends keyword를 사용하여 상속을 받을 수 있다.


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