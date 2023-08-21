# Select All Query를 사용하면 안되는 이유

## 5개의 컬럼을 가진 Member Table 대략 200만 건을 통해서 속도 차이를 비교해보자.

| 조회 칼럼 수 | Fetch Time(sec) |
|:-------:|:----------------|
|    5    | 0.892sec        |
|    4    | 0.789sec        |
|    3    | 0.656sec        |
|    2    | 0.545sec        |
|    1    | 0.434sec        |


## 조회하는 컬럼 수를 줄일 때마다 속도차이가 준다. 이유가 뭐지..?!


## 우선 내부적으로 어떻게 조회로직이 동작할지 살펴보자.

### MySQL Server는 총 2개로 구분된다.
* MySQL Engine
* Storage Engine

### MySQL Engine의 구성 요소
* 커넥션 헨들러: 클라이언트로 부터 접속 및 query 요청을 처리하는 역할을 수행한다.
* SQL Parser: query 구문을 해석하는 역할을 수행한다.
* SQL Optimizer: query 구문을 최적화하는 역할을 수행한다.

### Storage Engine 
* 대표적으로 InnoDB Engine, MyISAM Engine이 존재한다.
* Storage Engine에서는 Disk에 Read/Write를 수행한다.
* InnoDB Storage Engine에서는 성능 향상을 위해 InnoDB Buffer Pool을 내장하고 있다.

### Handler API
* MySQL Engine과 Storage Engine이 서로 주고받을 때 사용되는 API
* MySQL Engine이 Read/Write를 요청 시, Handler Request라고 한다.

