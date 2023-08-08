# Garbage Collection

## GC란?
* Garbage Collection이란 사용되지 않는 객체들을 식별하고 메모리를 해제하는 프로세스를 말한다.
* Garbage Collector란, 실제로 Garbage Collection을 수행하는 주체를 말한다.

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
    * age가 31을 임계치로 초과 시에는 old Generation으로 Promotion된다.
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

## SWT란?
* Stop-the-world의 약자이다.
* GC가 수행되는 동안 Application에서 실행 중인 Thread들이 멈추는 현상을 말한다.

## Reference 
* https://d2.naver.com/helloworld/329631
* https://inpa.tistory.com/entry/JAVA-%E2%98%95-%EA%B0%80%EB%B9%84%EC%A7%80-%EC%BB%AC%EB%A0%89%EC%85%98GC-%EB%8F%99%EC%9E%91-%EC%9B%90%EB%A6%AC-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%F0%9F%92%AF-%EC%B4%9D%EC%A0%95%EB%A6%AC
* 자바 성능 튜닝 이야기(이상민 지음)