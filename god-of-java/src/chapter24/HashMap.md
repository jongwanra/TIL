# HashMap 관련 정리

## What
* key에 대한 hash값을 사용하여 값을 저장하고 조회하며, 키-값 쌍의 개수에 따라 동적으로 크기가 증가하는 `associate array`이다.
* 해시 테이블은 연관배열 구조를 이용하여 key에 결과값을 저장 및 조회하는 자료구조
    * 연관 배열 구조란 key 1개와 값 1개가 연관되어 있는(매핑) 구조이다.
* 해시 테이블은 key, hash function, hash, value 저장소(bucket, slot)
* key는 해시 함수(hash function)을 통해 해시(hash)로 변경이 되며 hash는 값(value)와 매핑이 되어 저장소에 저장 된다.

## 해시 분포와 해시 충돌
* 같지 않은 객체 X와 Y가 있을 때, 
* !X.equals(Y)false && X.hashCode() != Y.hashCode()인 경우 이때 사용하는 해시 함수는 완전한 해시 함수(perfect hash functions)라고 한다.
* Boolean과 같이 서로 구별되는 객체의 종류가 적거나, Integer, Long, Double과 같은 객체는 객체가 나타내려는 값 자체를 해시 값으로 사용할 수 있기 때문에 완전한 해시 함수 대상으로 삼을 수 있다.
* 하지만, `String`이나 `POJO`(plain old java object)에 대하여 완전한 해시 함수를 제작하는 것은 사실상 불가능하다. -> 왜?
* Open Addressing, Separate Chaning
* 하나의 해시 버킷에 8개의 키-값 쌍이 모이면 링크드 리스트를 트리로 변경한다.
* 만약 해당 버킷에 있는 데이터를 삭제하여 개수가 6개에 이르면 다시 링크드 리스트로 변경한다.

## Open Addressing
* 데이터를 삽입하려는 해시 버킷이 이미 사용 중인 경우 다른 해시 버킷에 해당 데이터를 삽입하는 방식이다.
* 해시 버킷을 찾을 때에는 Linear Probing, Quadratic Probing 등의 방법을 사용한다.

## Separate Chaining
* Separate Chaning에서 `각 배열의 인자`는 인덱스가 같은 해시 버킷을 연결하는 링크드 리스트의 첫 부분(head)이다.


## 

java 8 HashMap에서는 Entry class 대신 Node class를 사용한다. Node class 자체는 사실상 Java 7의 Entry class와 내용이 같지만, 링크드 리스트 대신 트리를 사용할 수 있도록
하위 클래스인 TreeNode가 있다는 점이 Java 7 HashMap과 다르다.

## 

해시 버킷 개수의 기본값: 2^4
버킷의 최대 개수: 2^30
버킷 개수가 두 배로 증가할 때마다, 모든 키-값 데이터를 읽어 새로운 Separate Chaning을 구성해야 하는 문제가 있다.


## Reference
* https://d2.naver.com/helloworld/831311