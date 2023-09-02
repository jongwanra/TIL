# Connection Pool
 
> Connection is not available, request timed out after 5000ms. 

아.. 내가 실무에서 봤던 이 에러 메시지 관련된 내용이 Connection Pool이였구나.. ㅠ

## 왜 5000ms timeout error를 발생시켰을까?
DB설정 값 중 max_connections와 DBCP 설정 값 중 maximumPoolSize 값이 요청 수 보다 부족했기 떄문이라고 판단이 된다.
예를 들어서 DB에 설정된 max_connections가 10이고 DBCP의 maximumPoolSize값과  minimumIdle값이 10이라고 했을 때 Client로 부터 10,000건의 요청이 들어왔다면,
pool에서 connection을 받기 위해 대기하다가 connectionTimeout값인 5000ms를 초과해서 발생한 error라고 생각된다. 


## Connection Pool이란?
미리 여러개의 Connection을 생성해놓고 필요할 때마다 꺼내 쓰는 방법이다. 
WAS는 DB Connection이 필요할 때 직접 Connection을 생성하지 않고 Connection Pool Container로부터 Connection 하나를 받고, 사용을 마치면 반납하게 된다.

## Connection Pool은 왜 필요할까?
DB Server와 WAS는 통신 시 tcp기반으로 통신을 하기 때문에 connection 생성 시 3-way-handshake, connection을 끊을 시, 4-way-handshake를 하게 된다.
쿼리를 요청하고 응답을 받을 때마다 connection을 생성하고 끊는 과정 자체에 많은 비용이 발생한다. 이를 해결하기 위해서 필요하다.

## DB Server 설정

### max_connections
* Connection 수를 제대로 설정하기 위해선 DB Server의 `max_connections`를 적절하게 지정해줘야 한다.
여기서 `max_connections`는 client와 맺을 수 있는 최대 connections를 의미한다.

### wait_timeout
* connection이 연결된 이후에 다시 요청이 오기까지 얼마의 시간을 기다린 뒤에 close할 것인지를 결정하는 옵션
* 시간 내에 요청이 도착하면 0으로 초기화 된다.
* 비정상적인 connection에서 중요한 parameter이다.
  * 비정상적인 connection 종료
  * connection을 다 쓰고 반환이 안된 상황
  * 네트워크 단절

## DBCP 설정
WAS에서의 Connection Pool을 의미한다.

### minimumIdle
pool에서 유지하는 최소한의 idle connection 수를 의미한다.
idle connection 수가 minimumIdle보다 작고, 
전체 connection 수도 maximumPoolSize보다 작다면 신속하게 추가로 connection을 만든다.

### maximumPoolSize
* pool이 가질 수 있는 최대 connection 수
* idle과 active(in-use) connection 합쳐서 최대 수

### maxLifetime
* pool에서 connection의 최대 수명을 의미한다.
* maxLifetime을 넘기면 idle일 경우 pool에서 바로 제거, active인 경우 pool로 반환된 후 제거된다.
* DB의 connection time limit 보다 몇 초 짧게 설정해야 한다.(HikariCP 권장사항)

### connectionTimeout
* pool에서 connection을 받기 위한 대기 시간을 의미한다.

### HikariCP 권장사항
minimumIdle값과 maximumPoolSize 값을 동일하게 만들자. (pool size 고정)



## Reference 
* [DBCP (DB connection pool)의 개념부터 설정 방법까지! hikariCP와 MySQL을 예제로 설명합니다! 이거 잘 모르면 힘들..](https://www.youtube.com/watch?v=zowzVqx3MQ4)
* [데이터베이스 커넥션 풀 (Connection Pool)과 HikariCP](https://hudi.blog/dbcp-and-hikaricp/)