# Generic


## 용어 정리
* Class와 Inteface 선언에 타입 매개변수(type-parameter)가 쓰이면, 이를 Generic Class 혹은 Generic Interface라고 한다.
  * List Interface는 원소의 타입을 나타내는 타입 매개변수 E를 받는다 (List<E>)
* Generic Interface와 Generic Class를 통틀어 Generic Type이라고 한다.
* Generic은 일련의 매개변수화 타입(parameterized type)을 정의한다.
* Raw Type: 제너릭 타입에서 타입 매개변수를 전혀 사용 하지 안흘 때
  * List<String> 중 Raw Type은 List이다.
  * Raw Type은 절대 사용해서는 안 된다. 제네릭이 안겨주는 안전성과 표현력을 모두 잃게 된다.
  * Law Type => List <->  Parameterized Type: List<String> 


