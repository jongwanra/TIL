# Overloading And Overriding

## Overloading
* 메소드 이름을 같도록 하고, 매개 변수만을 다르게 하는 것
  * 자바의 신(이상민 저)
* If two methods of a class (whether both declared in the same class, or both inherited
   by a class, or one declared and one inherited) have the same name but signatures that are not override-equivalent
  * Oracle Specifications(Java SE 11)

## Overriding
* 부모 클래스에 있는 메소드와 동일하게 선언하는 것을 "메소드 Overriding"이라고 한다. 접근 제어자, 리턴 타입, 메소드 이름, 매개 변수 타입 및 개수, 예외 처리까지가 모두 동일해야만, "메소드 Overiding"이라고 부른다.
  * 자바의 신(이상민 저)


## 오버로딩은 어떤 상황에서 유용하게 사용될 수 있을까?
* 다양한 타입에 대해 동일한 기능을 수행하는 경우에 사용하면 좋다. constructor(), System.out.println() 등과 같은 예시를 들 수가 있다.