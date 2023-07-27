# Equlas and Hashcode 

## 동일성(Identity)

* 동일성은 `두 객체가 완전히 같은 경우`를 의미한다.
* 두 객체를 사실상 하나의 객체로 봐도 무방하며, 주소 값이 같기 때문에 두 변수가 같은 객체를 가리키게 된다.

## 동등성(Equality)

* 동등성은 `두 객체가 서로 같은 정보를 갖고 있는 경우`를 의미한다.
* 동등성은 변수가 참조하고 있는 객체의 주소가 서로 다르더라도 내용만 같으면 두 변수는 동등하다고 이야기할 수 있다. 

---
* Identity하면 Equality 하지만, Equality한다고 해서 Identity한 것은 아니다.
* 해당 변수가 동등한지 에대해서는 equals method를 통해 판별할 수 있다.


## 동일성과 동등성의 차이는 무엇인가?
* 두 객체가 할당된 메모리 주소가 같으면 동일하다를 의미한다.
* 두 객체 안에 값들이 같으면 동등하다고 말한다.
* 동일성은 == 연산자를 통해 판별할 수 있고, 동등성은 equals 연산자를 통해 판별할 수 있다.
* 동일하면 동등하지만, 동등하다고 해서 동일한 것은 아니다.


## == 연산자와 equals 연산자의 차이는 무엇인가?
* == 연산자는 객체의 동일성을 판별하기 위해 사용한다.
* equals method는 두 객체의 동등성을 판별하기 위해 사용한다.
* equals 연산자는 재정의하지 않으면 내부적으로 == 연산자와 같은 로직을 수행하므로 차이가 없다. 따라서 equals 연산자는 각 객체의 특성에 맞게 재정의를 해야 동등성의 기능을 수행한다.


## equals method Contract

Java SE defines the contract that out implementation of the equals() method must fulfill. Most of the criteria are common sense.
The equals() method must be:

> It is reflexive: for any non-null reference value x, x.equals(x) should return true.
* 반사적이다: 널이 아닌 참조 값 x,x.equals(x)는 반환값이 true여야 한다.
> It is symmetric: for any non-null reference values x and y, x.equals(y) should return true if and only if y.equals(x) returns true.
* 대칭적이다: 널이 아닌 참조 값 x와 y가 주어질 때, y.equals(x) 가 true일 경우, x.equals(y) 역시 true를 반환해야 한다.
> It is transitive: for any non-null reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns true, then x.equals(z) should return true.
* 이행적이다(?): 널이 아닌 참조 값 x, y, z가 주어질 때  x.equals(y) == true && y.equals(z) 일 경우, x.equals(z) 도 true를 반환해야 한다.
> It is consistent: for any non-null reference values x and y, multiple invocations of x.equals(y) consistently return true or consistently return false, provided no information used in equals comparisons on the objects is modified.
* 일관되다: x, y가 널이 아니면서, 중간에 객체가 수정이 된 사항이 아니라면, x.equals(y)를 여러번 호출할 경우 일관된 결과값 true 혹은 false를 반환해야 한다.
> For any non-null reference value x, x.equals(null) should return false.
* 널이 아닌 참조 값 x가 주어질 때, x.equals(null) 은 false를 반환해야 한다.

## hashCode Method Contract

The general contract of hashCode is:

> Whenever it is invoked on the same object more than once during an execution of a Java application, the hashCode method must consistently return the same integer, provided no information used in equals comparisons on the object is modified. This integer need not remain consistent from one execution of an application to another execution of the same application.
> If two objects are equal according to the equals method, then calling the hashCode method on each of the two objects must produce the same integer result.
> It is not required that if two objects are unequal according to the equals method, then calling the hashCode method on each of the two objects must produce distinct integer results. However, the programmer should be aware that producing distinct integer results for unequal objects may improve the performance of hash tables.


## HashCode? 

* 해시코드는 해시 알고리즘에 의해 생성된 정수 값이다.
* 해시 코드의 규약
  * equals 비교에 사용되는 정보가 변경되지 않았다면, 애플리케이션이 실행되는 동안 그 객체의 hashCode 메소드는 몇 번을 호출해도 일관되게 항상 같은 값을 반환해야 한다.
  * equlas(Object)가 두 객체를 같다고 판단했다면, 두 객체의 hashCode는 똑같은 값을 반환해야 한다.
  * equals(Object)가 두 객체를 다르다고 판단했더라도, 두 객체의 hashCode가 서로 다른 값을 반환할 필요는 없다. 단, 다른 객체에 대해서는 다른 값을 반환해야 해시테이블의 성능이 좋아진다.

## equals와 hashCode 메서드는 무엇이고 언제 사용할까?

equals는 객체의 동등성 여부를 판단하는 메소드이며, hashCode는 해당 객체의 유니크한 int값을 반환하는 메서드 이다.
equals와 hashCode는 객체의 동등성 여부를 판단할 때 사용된다. 예시로 HashTable, HashMap, HashSet 등을 들 수 있다. 

위의 예시 3가지에서 key값을 지정할 때 hashCode 메서드를 통해 반환 받은 정수값을 사용하게 된다. 이를 통해서 value를 조회, 저장 혹은 삭제가 가능하다.
이때 이때 존재하는지 유무를 판단하게 되는데, 같은 key값을 가지고 있는 value값들이 2개 이상일 경우 equals method를 통해 추가 검증을 시도하게 된다.

## equals와 hashCode 메서드의 관계에 대해 자세히 설명해주세요.

위 두가지의 관계는 equals를 통해서 동등한 객체일 경우, hashCode역시 동일한 값을 보장해야한다.
반대로 equals를 통해사 동등하지 않은 객체인 경우, hashCode는 동일할 경우가 존재한다.

## Reference
* https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/lang/Object.html
* https://steady-coding.tistory.com/534
* https://www.digitalocean.com/community/tutorials/java-equals-hashcode
* https://www.baeldung.com/java-equals-hashcode-contracts