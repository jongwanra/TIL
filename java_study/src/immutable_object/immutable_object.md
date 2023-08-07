# Immutable Object

## Immutable Object?
* 생성된 이후로 상태의 변경을 할 수 없는 객체를 말한다. 
* 불변 객체는 Object에 대해서 읽기 권한 만을 부여한다. 꼭 필요한 경우가 있다고 한다면 방어적 복사를 통해 제공한다.
* Java의 대표적인 불변 객체로는 String, BigDecimal, BigInteger가 존재한다.

## Immutable Object를 사용해야 하는 이유?
* 불변객체는 Thread-Safe하여 병렬 프로그래밍에 유용하며, 동기화를 고려하지 않아도 된다.
  * 멀티 스레드 환경에서 문제가 되는 부분은 공유 자원인 `객체`이다. 
  * 객체에서 상태 값 변경이 각각의 스레드에서 일어나면서 동기화에 문제가 발생한다.
  * 이를 불변객체에서는 상태 변경을 못하게 막기 때문에 동기화를 신경쓰지 않아도 되는 굉장한 장점이 있다.

* Cache, Map, Set등의 요소로 활용하기에 용이하다.
  * HashMap, HashSet등의 key값은 hashCode method와 아주 밀접한 관련이 있다. 객체를 key값으로 주었을 때 상태가 변경이 된다면, 
  * 극단적으로 해당 bucket을 찾을 수 없는 문제가 발생할 위험이 크다. 이때 불변객체라면 이러한 문제를 일으킬 원인을 차단할 수 있다.
* 실패 원자성이 보장된다.
  * 실패 원자성 실행 중인 method에서 exception이 발생했을 경우에도 해당 객체의 상태는 유효해야 한다는 성질이다.
  * 불변객체의 경우 실패 원자성이 보장된다.
* 안정성, 신뢰성이 보장된다.
  * 불변 객체라고 한다면 로직을 파악하는 과정 혹은 버그를 찾아가는 과정 중에 있을 때 일을 처리하는 속도가 현저하게 줄어든다. 당연히 내부의 상태가 변경되는 객체라고 했을 때에는 
  * 내부에 상태를 변경시키는 메서드가 있는지 여부, 외부에서 변경시키는 메서드가 있는지 여부 등 다방면으로 확인할 필요가 있는데 이런 과정이 현저하게 줄어든다.
  
## Immutable Object의 단점?
* 상태값이 빈번하게 변경되는 객체라면 오버헤드를 불러일으킬 수 있다.
  * 예시로 String Class는 불변 객체이다.
  * 값이 변경될 때마다 새롭게 객체를 호출하게 된다.
  * 글자 수만큼 변경이 일어나야 한다면? 굉장히 많은 객체가 생성되었다가 사라지게 될 것이다.


## 실패 원자성(Failure atomicity)이란?
* 메서드가 Exception이 발생허더라도 해당 객체의 상태는 유효해야 한다는 성질을 말한다.


## Immutable Object Sample 

```java
package immutable_object;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Contribution {
    private final int amount;
    private final List<String> sponsers = new ArrayList<>();

    private Contribution(final int amount) {
        this.amount = amount;
    }
    
    
    // 생성시에는 정적 팩토리 메서드를 추가하자.
    public static Contribution valueOf(final int amount) {
        return new Contribution(amount);
    }

    public Contribution donate() {
        return new Contribution(amount + 1);
    }
    public int getTotal() {
        return amount;
    }


    // 방어적 복사
    // 여기서 sponsers를 그대로 내보낸다면, 참조에 의해 값이 변경될 위험이 존재한다.
    // 따라서 방어적 복사를 통해 내보내자.
    public List<String> getSponsers() {
        return Collections.unmodifiableList(sponsers);
    }
}


```


## Reference 
* 이펙티브 자바
* https://docs.oracle.com/javase/tutorial/essential/concurrency/immutable.html
* https://mangkyu.tistory.com/131