# Garbage Collection

## GC란?
* Garbage Collection이란 사용되지 않는 객체들을 식별하고 해제하는 프로세스를 말한다.
* Garbage Collector란, 실제로 Garbage Collection을 수행하는 주체를 말한다.

## Young Generation이란?
* 새로 생성된 또는 생성된지 얼마 되지 않은 객체들이 할당되는 영역이다. 세부적으로 Eden영역과 Survivor 영역으로 나뉜다.

## Old Generation이란?
* Young Generation에 있던 객체들 중 수명이 오래 되거나 객체의 크기가 Survivor 메모리 공간 보다 큰 객체들이 Promotion되는 영역이다.


## GC가 하는 역할
* 총 3가지
  * 메모리 할당
  * 사용중인 메모리 감시
  * 사용 중이지 않은 메모리 감시

## GC의 동작 방식
1. 객체 생성 시 Young Generation 내부 Eden 영역에 객체가 생성된다. 
2. Eden영역의 메모리 공간이 다 찼을 때 Minor GC가 수행이 된다. 이때 빈 Survivor(From Or To) 영역으로 살아 있는 객체들이 이동하게 된다.(Eden 영역 + 다른 Survicvor 영역의 객체들.)
    * Survivor 영역은 두 공간이 존재하는데 한 영역은 무조건 비어있어야 한다는 조건이 있다. 
    * 이동할 때 마다 각 객체의 header에는 age가 1씩 증가한다. 
    * age를 임계치로 초과 시에는 old Generation으로 Promotion된다.
    * Survivor 메모리 공간 보다 큰 객체인 경우에는 Survivor영역을 거치지않고 Eden 영역에서  바로 Old Generation 영역으로 Promotion 한다.
3. Old Generation 영역이 가득 찰 경우, Major(=Full) GC가 수행이 된다.


## GC는 garbage인지 어떻게 판단할까?
* GC는 객체가 가비지인지 판별하기 위해서 `reachability`라는 개념을 사용한다.
* Reachable: 객체가 참조되고 있는 상태를 말한다.
* UnReachable: 객체가 참조되고 있지 않은 상태를 말한다. 수거의 대상이 된다.
* GC Root로 부터 해당 객체에 접근 가능한지가 해제의 기준이 된다.
  * GC Root는 Local Variable, Parameter, Static Variable, JNI(Java Native Interface)가 될 수 있다.

## GC의 종류
* GC의 종류는 총 두 가지로, Minor GC, Major GC(= Full GC)가 존재한다.
* Minor GC는 young Generation 영역에서 동작하는 GC이다.
* Mager GC는 old Generation 영역에서 동작하는 GC이다.

## Old Generation으로 이동하는 기준은?
* 객체의 크기: Survivor 영역 이 이상의 크기의 데이터인 경우 Old Generation 으로 Promotion한다.
* 객체의 나이: Survivor 영역을 옮겨가며 살아남은 객체의 경우 age를 한개씩 추가하게 되는데, 이떄 age가 임계치를 넘게 되면 old Generation영역으로 Promotion한다.

## STW란?
* Stop-the-world의 약자이다.
* GC가 수행되는 동안 Application에서 실행 중인 Thread들이 멈추는 현상을 말한다.

## GC 방식

### Serial Collector
* Young Generation과 Old Generation이 연속적으로 처리되며 하나의 CPU를 사용한다.
* Young Generation에서는 `Mark-Sweep` Algorithm을 사용한다.
* Old Generation에서는 `Mark Sweep Compact` Algorithm을 사용한다.
* GC 수행 시, STW가 발생한다.
* 언제 사용하면 좋을까?
  * 실질적으로 실무에서 사용 안되는 방식
  * 한 번 GC가 발생했을 때 STW 시간이 너무 길다.

### Parallel Collector(Throughput Collector)
* Java8 에서의 default GC이다.
* Serial Collector와 다른 점은 Young Generation에서 Minor GC가 `병렬적으로` 수행된다.
* Serial GC에 비해 STW 시간 감소
* GC 스레드는 기본적으로 CPU 개수만큼 할당된다.

### Parallel Old Collector(Parallel Compacting Collector)
* Parallel Collector와 다른 점은 Old Generation Full GC가 `병렬적으로` 수행된다.
* Old Generation에서 Mark Summary Compact Algorithm을 사용한다.
* Full GC 수행 시, Summary단계에서 여러 스레드가 Old Generation을 분리해서 훑는다.

### CMS Collector(Concurrent Mark Sweep Collector, Low Latency Collector)
* STW 시간을 최소화 하기 위해 고안됨.
* Heap 메모리 영역이 클 때 적합하다.
* Young Generation의 Minor GC는 Parallel Collector와 동일하다.
* Old Generation의 Full GC는 아래의 단계를 거친다. 
  * Init Mark -> Concurrent Mark -> Remark -> Concurrent Sweep
  * 여러 단계로 Full GC가 수행되고 만큼 Application Thread와 동시에 실행되기 때문에 다른 GC 대비 CPU 사용량이 높다.
* Compact 단계를 거치지 않는다. -> 그렇기 때문에 메모리 단편화 문제가 있다.


### G1 Collector
* CMS GC를 대체하기 위해서 나왔다.
* Java9 버전 부터 Default GC로 지정되었다.
* 4GB 이상의 힙 메모리 를 가질 경우 권장(Heap영역이 작을 경우 미사용 권장)
* G1 GC이전의 GC는 Heap영역을 물리적으로 고정된 Young / Old 영역으로 나누어 사용하였지만, G1 GC는 `Region` 개념을 새로 도입하여 사용.
* 전체 Heap 영역을 체스 같이 분할하여 상황에 따라 Eden, Survivor, Old, Humongous등 구역의 역할을 동적으로 부여했다.
* 메모리가 많이 차 있는 구역을 우선으로 GC를 하기 때문에 Garbage First라는 이름이 붙었다.
* CMS Collector에서의 문제였던 메모리 단편화 문제 해결

## Survivor 영역이 2개인 이유?
* 메모리 단편화 문제를 최대한 빠르게 해결하기 위해서 나누게 되었다.
  * Young Generation은 Minor GC가 굉장히 빈번하게 수행된다.
  * STW 시간을 최소한으로 가져 가야한다.
  * 여기서 메모리 공간을 추가해서 성능을 더욱 늘리는 방법을 선택했다.


## Reference
* https://steady-coding.tistory.com/590
* https://d2.naver.com/helloworld/329631
* https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC
* 자바 성능 튜닝 이야기(이상민 지음)