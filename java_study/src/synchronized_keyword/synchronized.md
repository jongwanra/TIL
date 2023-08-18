# Synchronized Keyword

## Synchronized를 공부하기 이전에 Thread Cycle은 어떻게 될까?
총 6가지 상태가 존재한다.
* NEW: thread가 생성되었지만 아직 start() method를 호출하기 전 상태이다.
* RUNNABLE : 실행 가능한 혹은 실행 중인 상태를 의미한다.
* TERMINATED: 종료된 상태를 의미한다.
* WAITING: wait(), join() method를 호출했을 경우에 해당 상태로 변경이 된다. notify() method 혹은 notifyAll() method를 통해서 깨울 수 있다.
* TIMED_WAITING: wait(long timeoutMillis) method 혹은 sleep() method를 호출했을 경우 해당 상태로 변경이 된다.
* BLOCKED: synchronized method/block 에서 모니터락을 얻기 전까지 대기하는 상태를 의미한다.

## synchronized block에서 static keyword가 붙어 있는 경우와 안 붙어 있는 경우의 차이가 뭘까?
* synchronized 경우에, 인스턴스 마다 독립된 락을 가지고 있기 때문에 서로 다른 인스턴스 간 동시에 실행이 가능하다.
* static synchronized 경우에, 클래스에 해당하는 락이기 때문에 동시에 하나의 스레드로만 실행이 가능하다.

## synchronized keyword를 봤을 때 Instrinic lock 혹은 monitor lock을 획득한다고 하는데 누가 획득한다는 걸 의미하는 걸까?
[자바 객체의 해더 정보](https://hg.openjdk.org/jdk8/jdk8/hotspot/file/87ee5ee27509/src/share/vm/oops/oop.hpp)
> When a thread invokes a synchronized method, it automatically acquires the intrinsic lock for that method's object and releases it when the method returns. The lock release occurs even if the return was caused by an uncaught exception. [Locks In Synchronized Methods](https://docs.oracle.com/javase/tutorial/essential/concurrency/locksync.html)
* thread가 synchronized method를 호출할 때, `thread`는 자동적으로 메서드의 공유 자원에 대한 intrinsic lock 을 획득한다!
* 즉, 내용을 정리 해보면 synchronized method/block을 진입하려는 thread가 객체(공유 자원)에 대한 lock을 획득한다고 이해함.

## Context Switching이란?
* 멀티 스레딩 환경에서, 하나의 CPU를 여러 스레드에서 공유하고 있을 때 발생한다.
* 이 때 실행 중이던 스레드의 상태를 저장하고 다음 실행할 스레드의 상태를 복원하는 작업을 의미한다.
* Context Swithing은 Overhead가 발생하는 작업이다.

## synchronized와 CAS 속도 차이가 나는 이유
* Compare and Swap Algorithm을 적용할 때 하드웨어 적인 도움을 받을 수 있기 때문이다.
  * CPU Atomic Operation(하드웨어의 특정 명령어나 기능을 통해 원자적 연산을 수행한다)
  * 그렇기 때문에 `synchronized` 보다 더 낮은 오버헤드가 발생한다.
* synchronized를 사용할 경우 한 스레드에서 lock을 해제하고 다른 스레드에서 lock을 취득하는 과정에서 `context switching`이 발생하며, 이로 인해 오버헤드가 발생한다.


## synchronized vs CAS 성능테스트
* thread 개수에 따른 테스트(고정값: 100만번 증가 연산)

| Thread  | synchronized(s) |  CAS(s)  | Faster |
|:-------:|:---------------:|:--------:|:------:|
|    2    |     0.128s      |  0.059s  |  CAS   |
|    4    |     0.666s      |  0.147s  |  CAS   |
|   10    |     1.790s      |  0.533s  |  CAS   |
|   50    |     7.935s      |  2.524s  |  CAS   |

```java
import java.util.concurrent.atomic.AtomicInteger;

public class SynchronizedVsCASPerformance {
	
	private static final int NUM_THREADS = 4;
	private static final int NUM_ITERATIONS = 1_000_000;
	
	private static int synchronizedCounter = 0;
	private static AtomicInteger casCounter = new AtomicInteger(0);
	
	public static void main(String[] args) throws InterruptedException {
		Thread[] synchronizedThreads = new Thread[NUM_THREADS];
		Thread[] casThreads = new Thread[NUM_THREADS];
		
		// Synchronized Test
		long beforeTestWithSynchronized = System.nanoTime();
		for (int i = 0; i < NUM_THREADS; i++) {
			synchronizedThreads[i] = new Thread(() -> {
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					synchronized (SynchronizedVsCASPerformance.class) {
						synchronizedCounter++;
					}
				}
			});
			synchronizedThreads[i].start();
		}
		
		for (Thread thread : synchronizedThreads) {
			thread.join();
		}
		
		// System.out.println("Synchronized Counter: " + synchronizedCounter);
		long afterTestWithSynchronized = System.nanoTime();
		long performanceTimeWithSynchronized = afterTestWithSynchronized - beforeTestWithSynchronized;
		
		// CAS Test
		
		long beforeTestWithCAS = System.nanoTime();
		for (int i = 0; i < NUM_THREADS; i++) {
			casThreads[i] = new Thread(() -> {
				for (int j = 0; j < NUM_ITERATIONS; j++) {
					casCounter.getAndIncrement();
				}
			});
			casThreads[i].start();
		}
		
		for (Thread thread : casThreads) {
			thread.join();
		}
		
		// System.out.println("CAS Counter: " + casCounter.get());
		long afterTestWithCAS = System.nanoTime();
		long performanceTimeWithCAS = afterTestWithCAS - beforeTestWithCAS;
		
		System.out.println("synchronized performance : " + performanceTimeWithSynchronized);
		System.out.println("CAS performance : " + performanceTimeWithCAS);
		System.out.print("Who is Faster : ");
		if (performanceTimeWithCAS < performanceTimeWithSynchronized) {
			System.out.println("CAS");
		} else if (performanceTimeWithCAS > performanceTimeWithSynchronized) {
			System.out.println("synchronized");
		} else {
			System.out.println("Same");
		}
	}
}

```


## Synchronization 3가지 전략
* Spin lock
* Mutex
* Semaphore

## Spin lock
* 락을 가질 수 있을 때까지 반복해서 시도하는 방식
* 락을 기다리는 동안 CPU를 낭비한다는 단점이 존재한다.


## Critical Section(임계 영역)
* 공유 자원의 무결성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역

## Mutual Exclusion(상호 배제)
* `하나의 프로세스/스레드만 진입해서 실행 한다`는 의미

## Monitor 
* Mutual Exclusion 보장
* 조건에 따라 스레드가 대기(Waiting) 상태로 전환하는 기능

## Monitor는 언제 사용되나?
* 한번에 하나의 스레드만 실행돼야 할 때
* 여러 스레드와 협업(Cooperation)이 필요할 때

## 모니터의 구성 요소
* mutex
* condition variable(s)

## mutex
* Critical Section에서 Mutual Exclusion을 보장하는 장치
* Critical Section에 진입하려면 Mutex Lock을 취득해야 함
* Mutex Lock을 취득하지 못한 스레드는 큐에 들어간 후 대기(Waiting) 상태로 전환
* mutex lock을 쥔 스레드가 lock을 반환하면 락을 기다리며 큐에 대기 상태로 있던 스레드 중 하나가 실행 


## condition variable
* waiting queue를 가짐
* 조건이 충족되길 기다리는 스레드들이 대기 상태로 머무는 곳

## condition variable에서 주요 동작(operation)
* wait
  * thread가 자기 자신을 condition variable의 waiting queue에 넣고 대기 상태로 전환하는 동작
* signal
  * waiting queue에서 대기 중인 thread 중 하나를 깨움.
* broadcast
  * waiting queue에 대기 중인 thread 전부를 깨움

## Monitor에는 두 개의 큐가 존재한다.
* entry queue: critical section에 진입을 기다리는 큐(mutex에서 관리하는 큐)
* waiting queue: 조건이 충족되길 기다리는 큐(condition variable에서 관리 되는 큐) 

## Reference
* [Difference Between Atomic, Volatile, and Synchronized In java.](https://medium.com/@basecs101/difference-between-atomic-volatile-and-synchronized-in-java-programming-14156c3c8f46)
