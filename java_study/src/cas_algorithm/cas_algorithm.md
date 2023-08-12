# Atomic and CAS(Compare And Swap) Algorithm


## 용어 정리

### 데이터 무결성이란?
* 데이터가 정확성과 일관성을 있는 유지하고 있는 상태

### 경합조건이란?
* 멀티스레딩 환경에서 하나의 공유된 자원을 여러 스레드가 수정하려고 할때 데이터의 무결성이 깨질 수 있는 상황.

### 동기화란?
* 데이터의 무결성을 보장하고 경합 조건을 방지하는 것

### 원자성이란?

* 멀티 스레딩 환경에서, 연산을 실행하는 동안에 다른 스레드의 간섭을 받지 않는 특성

### 가시성이란?
* 멀티 스레딩 환경에서, 공유 자원의 변경 사항이 다른 스레드에 얼마나 빠르게 반영되는지를 나타내는 개념.


## volatile
* volatile은 사전적 의미로 `휘발성`을 의미한다.
* volatile keyword를 사용한 변수는 데이터를 읽거나 쓸 때, cache를 거치지 않고 main memory에서 직접 가져오고, 수정하는 특성을 가지고 있다.
* 그렇기 때문에 변수에 대한 가시성을 보장한다.
* 하지만, volatile keyword를 사용한다고 해서 `연산의 원자성`을 보장 받는 것은 아니다. 즉, 연산을 실행 하는 동안에 다른 스레드의 간섭을 받을 수 있다.

### volatile Test
* 멀티 스레딩 환경에서 volatile keyword를 사용하여 도출된 값이 얼마인지 체크해보자.
* AtomicInteger Class method인 get(), set()은 단순히 volatile keyword인 변수에 대해서 가져오고, 수정하는 메서드이다.

```java
public class VolatileTest {
    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
        test.checkJustVisibility(10);
    }
    private void checkJustVisibility(final int size) throws InterruptedException {
    	AtomicInteger atomicCount = new AtomicInteger(0);
	
        for (int loop = 0; loop < size; loop++) {
          new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
              atomicCount.set(atomicCount.get() + 1);
            }
          }).start();
        }
	
        Thread.sleep(5000);
        // atomic 결과 : 7252
        System.out.println("atomic 결과 : " + atomicCount.get());
				
	}
}
```

* 위에 테스트에서 데이터를 총 10,000번 추가했지만, 실제로는 대략 7,500 번 정도가 반영이 되었다.
* volatile keyword는 연산의 원자성을 보장해주지 않기 때문이다.
* 그렇다면, 연산의 원자성 까지 보장해주는 방법이 있을까?

## volatile + CAS Algorithm
* 가시성과 원자성을 보장하는 방법이 존재한다.
* java.util.concurrent.atomic Class들 안에 method중 일부에 해당한다.
* 한 예시로 AtomicInteger 클래스를 활용해서 내부 구현 구조를 봐보자.

```java
public class AtomicTest {
	
	public static void main(String[] args) throws InterruptedException {
		AtomicTest test = new AtomicTest();
		test.checkAtomicIntegerMethod(10);
	}
	
	private void checkAtomicIntegerMethod(int size) throws InterruptedException {
		
		AtomicInteger atomicCount = new AtomicInteger(0);
		
		for (int loop = 0; loop < size; loop++) {
			new Thread(() -> {
				for (int i = 0; i < 100_000; i++) {
					count++;
					atomicCount.incrementAndGet();
				}
			}).start();
		}
		
		Thread.sleep(5000);
		// atomic 결과 : 1000000
		System.out.println("atomic 결과 : " + atomicCount.get());
	}
}
```

* 결과값이 환상적으로 정확히 원했던 100만번이 출력된다.(thread 10개 * 100,000번)
* AtomicInteger 내부의 incrementAndGet() method를 확인해 보자.

```java
public class AtomicInteger {
	
	// volatile keyword로 선언된 변수
	private volatile int value;
	
	public final int getAndIncrement() {
        return U.getAndAddInt(this, VALUE, 1);
    }
    
	@HotSpotIntrinsicCandidate
	public final int getAndAddInt(Object o, long offset, int delta) {
		int v;
		do {
			// 실제 메모리에서 v값을 가져온다.
			v = getIntVolatile(o, offset);
					
            // 여기서 o, offset은 실제 값의 메모리 위치를 찾기위한 매개변수이며, v, v + delta는 각각 현재 값과, 변경할 값을 나타낸다.
		} while (!weakCompareAndSetInt(o, offset, v, v + delta)); 
		return v;
	}
	
	//in Unsafe.java method
	@HotSpotIntrinsicCandidate
	public native int getIntVolatile(Object o, long offset);
	
	//in Unsafe.java method
	@HotSpotIntrinsicCandidate
	public final boolean weakCompareAndSetInt(Object o, long offset,
		int expected,
		int x) {
		return compareAndSetInt(o, offset, expected, x);
	}
	
	//in Unsafe.java native method
    // 해당 native method 에서 매개변수인 expected값을 실제 메모리 값과 비교를 하게 된다. 이 때, 같을 경우 변경할 값인 x로 변경이 되고 true를 반환한다.
    // 다를 경우 false를 반환한다.
	@HotSpotIntrinsicCandidate
	public final native boolean compareAndSetInt(Object o, long offset,
      int expected,
    int x);
		
}
```
## CAS Algorithm
* Compare And Swap의 약자로, 멀티 스레딩 환경에서 동기화를 보장하기 위한 알고리즘이다.
* 위에 코드에서 설명했지만, 실제 메모리에서 가져온 값 v와 native method안의 매개변수인 expected로 직접 메모리에 있는 값과 비교를 해서 같을 경우에 변경할 값인 x로 업데이트가 이뤄진다.
* 다를 경우에는 계속 반복한다.


## synchronized vs Atomic Type(volatile + CAS Algorithm)
* synchronized keyword를 사용한다면, 해당 블럭이 lock이 걸리면서 다른 Thread들은 아무런 작업을 하지 못하고 기다리는 상황이 되어 버린다.
* 이때, Atomic Type을 사용한다면 NonBlocking 상태로 동기화 문제를 해결할 수 있게 된다.
* 하지만 Atomic Type은 간단한 연산에서는 원자성을 보장하며 처리할 수 있지만, 복잡한 연산을 하는 경우에는 busy-waiting이 발생한다.
* 복잡한 연산일 경우에는 synchronized keyword를 사용하는게 유리할 수 있다.




## Reference 
* https://steady-coding.tistory.com/568
* https://en.wikipedia.org/wiki/Compare-and-swap