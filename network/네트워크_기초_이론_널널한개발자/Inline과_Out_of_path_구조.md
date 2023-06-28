# Inline과 Out of path 구조

* Inline구조인지 OutOfPath(단속 카메라) 구조인지?
* Inline 구조와 반대되는 개념으로 OutOfPath구조가 있다. 
* Network Device는 주로 Inline이다.
* 게이트웨이에게 보통 HostId를 1번을 많이 준다.(10.10.10.1)
* 게이트웨이를 기점으로 내부망, 외부망으로 나뉜다.
* Inline장치는 톨게이트로 비유
* L2 Distribution를 통과할 때 ReadOnly로 Copy본을 만든다.
  * Port Mirroring
  * 네트워크 관리자는 Port Mirroring을 가급적 지양한다
  * CPU의 부하가 올라가기 때문
  * OutOfPath라고 불림.
  * 이런 요소는 기본적으로 Sensor일 가능성이 높다.
    * 목적에 따라 다르게 불림
    * 장애 용도 -> 장애 대응 센서 
    * 해킹하는지 알아보는 용도 -> *NIDS*