# Stream

## Stream이란?

> A sequence of elements supporting sequential and parallel aggregate operations.
> [Oracle](https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html)

스트림은 일종의 데이터 흐름이며 컬렉션(List, Map, Set 등)을 함수형 프로그래밍 방식으로 다룰 수 있게 해주는 API이다.

## Stream의 구조

스트림은 총 3가지의 구조로 되어 있다. 
* 스트림 생성
  * stream() method를 호출하면 Stream 타입을 리턴한다.
* 중간 연산(Intermediate Operation)
  * 데이터 가공 시 사용하며 연산 결과로 Stream 타입을 리턴한다.
* 최종 연산(Terminal Operation)
  * 스트림 처리를 마무리 하기 위해서 사용하며 숫자값을 리턴하거나 목록형 데이터를 리턴한다.
  * 최종 연산을 통해 수행된 stream은 재사용이 불가능하다.

## Intermediate Operation 종류
* filter()
* map() / mapToInt() / mapToLong() / mapToDouble()
* flatMap() / flatMapToInt() / flatMapToLong() / flatMapToDouble()
* distinct()
  * 중복을 제거하는 역할을 한다. distinct() method는 equals와 hashCode의 값을 활용해서 중복을 제거하기 때문에 직접 생성한 클래스인 경우 꼭 재정의 해주자.
* sorted()
* peek() 
  * 사전적 의미로 "확인해본다"의 의미와 같이 debugging을 도와준다.
* limit()
* skip()


## Terminal Operation 종류
* forEach() / forEachOrdered()
* toArray()
* reduce()
* collect()
  * collect() method는 반환 받고 싶은 타입을 매개변수로 넘기면 해당 타입으로 변경시켜준다
  * Collectors.toList(), Collectors.toSet(), Collectors.joining() 등이 있다. 
* min() / max() / count()
* anyMatch() / allMatch() / noneMatch()
* findFirst() / findAny()


## Stream을 사용했을 때 장점

### 1. 병렬 프로그래밍이 가능하다.
> 계산도 올바로 수행하고 성능도 빨라질 거라는 확신 없이는 스트림 파이프라인 병렬화는 시도조차 하지 말라. 스트림을 잘못 병렬화 하면 프로그램을 오동작하게 하거나 성능을 급격히 떨어뜨린다. [Effective Java - 람다와 스트림]()

병렬화가 가능하다는 것은 분명히 장점이다. 하지만 단점으로서 작용될 수 있다. 
병렬화를 시도했을 때 좋은 자료구조는 배열을 기반으로 하는 자료구조이다. Array, ArrayList, HashMap, HashSet, ConcurrentHashMap 등에서 병렬화의 효과가 가장 좋다.

Parallel Stream은 내부적으로 Fork & Join을 사용하고 있다.

```java

package stream;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ParallelStreamTest {
	public static void main(String[] args) {
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println("commonPool.getParallelism() = " + commonPool.getParallelism());
		
		Arrays.asList("a", "b", "c", "d", "e")
			.parallelStream()
			.filter(s -> {
				System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
	}
}

/*

commonPool.getParallelism() = 7
filter: c [main]
map: c [main]
filter: b [ForkJoinPool.commonPool-worker-3]
map: b [ForkJoinPool.commonPool-worker-3]
forEach: B [ForkJoinPool.commonPool-worker-3]
filter: a [ForkJoinPool.commonPool-worker-7]
map: a [ForkJoinPool.commonPool-worker-7]
forEach: A [ForkJoinPool.commonPool-worker-7]
filter: e [ForkJoinPool.commonPool-worker-5]
map: e [ForkJoinPool.commonPool-worker-5]
forEach: E [ForkJoinPool.commonPool-worker-5]
filter: d [ForkJoinPool.commonPool-worker-9]
map: d [ForkJoinPool.commonPool-worker-9]
forEach: D [ForkJoinPool.commonPool-worker-9]
forEach: C [main]        
*/
```


### 2. 지연 평가(Lazy Evaluation)를 수행 한다.
Lazy Evaluation이란, Stream에서 최종 연산이 호출될 때까지 실행을 하지 않는 것을 의미한다. 
그렇게 때문에 실행되기 전에 JVM내부에서 따로 최적화 작업을 진행해주는데 크게 2가지의 최적화가 이뤄진다.

#### 루프 퓨전(loop fusion)
loop fusion이란 연속적으로 체이닝된 1개 이상의 스트림 연산(filter, map, etc..)을 하나의 연산 과정으로 병합하는 것을 의미한다.
Stream을 사용할 시 일반적으로 수직적 구조로 순회가 된다. 아래의 코드를 보자.

```java
class Main {
	public static void main(String[] args) {
      Stream.of("a", "b", "c", "d", "e")
        .filter(s -> {
          System.out.println("filter: " + s);
          return true;
        })
        .forEach(s -> System.out.println("forEach: " + s));
    }
}


/*
실행 결과

filter: a
forEach: a
filter: b
forEach: b
filter: c
forEach: c
filter: d
forEach: d
filter: e
forEach: e
*/

```
즉 요소 하나 마다 수직적으로 연산을 수행한다는 것을 알 수 있다.

#### 쇼트서킷(short circuit)

쇼트서킷이란 기본적으로 불필요한 연산을 의도적으로 수행하지 않음으로써 실행 속도를 높이는 기법을 의미한다.
중간 연산으로 limit() method나 최종 연산으로 findFirst() method 등이 존재하는 경우 일반적으로 수평적으로 순회해서 연산을 진행하는 것 보다 연산 수행을 적게 수행하게 된다.

```java

class Main {
	public static void main(String[] args) {
      Stream.of("a", "b", "c", "d", "e")
        .filter(s -> {
          System.out.println("filter: " + s);
          return true;
        })
        .limit(2)
        .forEach(s -> System.out.println("forEach: " + s));
    }
}

/*
출력 결과

filter: a
forEach: a
filter: b
forEach: b        
 */
```

## Reference
* 자바의 신(이상민 저) - Java 8에서 변경된 것들은?
* [[Java] 스트림:지연 연산과 최적화](https://bugoverdose.github.io/development/stream-lazy-evaluation/)
* [[Java] Stream API의 고급 활용 및 사용 시의 주의할 점 - (4/5)](https://mangkyu.tistory.com/115)