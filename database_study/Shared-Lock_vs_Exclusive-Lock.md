# Shared Lock Vs. Exclusive Lock

설명하기 위해 간단하게 id=1 nickname=A인 회원A가 있다고 가정하자. 그리고 회원A에 접근하는 transaction-1, transaction-2가 존재한다고 가정하자.

## Shared Lock이란?

`읽기 락`으로도 불리며, Shared Lock을 획득한 트랜젝션은 읽기만 가능하다. 다른 Transaction도 해당 레코드에 대해서 읽기 접근만 가능하며, 쓰기는 불가능하다.

즉 treansaction-1이 먼저 회원A에 대해서 Shared-Lock을 획득한다. 다른 transaction-2는 회원A에 대해 읽기를 원할 경우 Shared-Lock을 획득하여 읽기가 가능하다. 
<br> 하지만 쓰기를 원할 경우에는 trasaction-1의 Shared-Lock을 풀 때까지 대기하게 된다.

## Exclusive Lock이란?
`쓰기 락`으로도 불리며, Exclusive Lock을 획득한 트랜잭션은 읽기/쓰기가 가능하다. 하지만 다른 트랜잭션은 Exclusive Lock이 해제될 떄까지 읽기/쓰기가 불가능하다.

즉, trasaction-1이 먼저 회원A에 대해서 Exclusive-Lock을 획득한다. 다른 trasaction-2는 회원A에 대해 읽기를 원할 경우에도 쓰기를 원할 경우에도 trasaction-1의 Exclusive-Lock이 풀릴 때까지 대기해야 한다.


## isolation level `SERIALIZABLE`을 왜 사용하면 안될까?

운영 환경에서는 SERIALIZABLE은 금기시 된다. 왜 사용하면 안될까? 알아 보니, Shared-Lock과 관련이 있었다.
Real MySQL에서는 아래와 같이 이야기 한다.

> 가장 단순한 격리 수준이면서 동시에 가장 엄격한 격리 수준이다. 그만큼 동시 처리 성능도 다른 트랜잭션 격리 수준보다 떨어진다. InnoDB 테이블에서 기본적으로 순수한 SELECT 작업은 아무런 레코드 잠금도 설정하지 않고 실행된다. 
> ... 중간 생략
> 하지만 트랜잭션의 격리 수준이 SERIALIZABLE로 설정되면 읽기 작업도 공유 잠금(읽기 잠금)을 획득해야만 하며, 동시에 다른 트랜잭션은 그러한 레코드를 변경하지 못하게 된다. 즉,
> 한 트랜잭션에서 읽고 쓰는 레코드를 다른 트랜잭션에서는 절대 접근할 수 없는 것이다.


즉, SERIALIZABLE 격리 수준으로 트랜잭션을 걸게 된다면  SELECT 시에는 Shared-Lock, INSERT/UPDATE/DELETE 시에는 Exclusive-Lock이 걸리게 된다.
<br> 그렇기 때문에 다른 transaction은 잠금이 해제될 때까지 기다리게 되면서 성능 저하가 발생하게된다. 따라서 실제 사용 시에는 많은 고려가 필요하다.

## 참고
* [Select 쿼리는 S락이 아니다. (X락과 S락의 차이)](https://velog.io/@soongjamm/Select-%EC%BF%BC%EB%A6%AC%EB%8A%94-S%EB%9D%BD%EC%9D%B4-%EC%95%84%EB%8B%88%EB%8B%A4.-X%EB%9D%BD%EA%B3%BC-S%EB%9D%BD%EC%9D%98-%EC%B0%A8%EC%9D%B4)
* Real MySQL 8.0 - 183p