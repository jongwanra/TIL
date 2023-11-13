# Isolation Level

## 📌 Isolation Level?

Database에서 동시성 제어를 하기 위한 개념이다.
특정 트랜잭션이 다른 트랜잭션에서 변경하거나 조회하는 데이터를 볼 수 있게 허용할지 여부를 결정하는 것이다.

즉, isolation level은 조금 더 구체적으로 **트랜잭션 동안 어떤 시점에 데이터를 읽을 수 있게 할지에 대한 level**로 받아들여진다.


## 📌 READ UNCOMMITED

READ UNCOMMITED 수준에서는 각 트랜잭션에서의 변경 내용이 Commit/Rollback 유무와 상관 없이 조회할 수 있다.  
데이터의 정합성을 보장해 주지 못한다. **사용하지 말자!**

### *Dirty Read*
어떤 트랜잭션에서 처리한 작업이 완료되지 않았음에도 다른 트랜잭션에서 볼 수 있는 현상을 `Dirty Read`라고 한다.



## 📌 READ COMMITED

오라클 DBMS에서 기본으로 사용되는 격리 수준이며, 온라인 서비스에서 가장 많이 선택되는 격리 수준이다.  
어떤 트랜잭션에서 데이터를 변경했더라도 COMMIT이 완료된 데이터만 다른 트랜잭션에서 조회할 수 있다.  

### *Non-Repeatable Read*
하지만 READ COMMITED 수준에서는 Non-Repeatable Read의 부정합 문제가 발생할 수 있다.  
동일한 query를 한 트랜잭션 내에서 2번 사용했는데 그 사이에 다른 트랜잭션에서 해당 데이터의 변경하고 commit 했다면?  
2번 조회한 트랜잭션은 다른 정보를 보게 될 것이며 이것은 정합성을 꺠지게 한다.


## 📌 REPEATABLE READ

MySQL의 스토리지 엔진에서 기본으로 사용되는 격리 수준이다. 바이너리 로그를 가진 MySQL 서버에서는 최소 REPEATABLE READ 격리 수준 이상을 사용해야 한다(?)
<br>
REPEATABLE READ 격리 수준에서는 `NON-REPEATABLE READ` 부정합이 발생하지 않는다. InnoDB 스토리지 엔진은 트랜잭션이 ROLLBACK될 가능성에 대비해 변경되기 전 레코드를 언두(Undo) 공간에 백업해두고 실제 레코드 값을 변경한다. 이러한 방식을 MVCC(Multi Version Concurrency Control)라고한다. <br>

REPEATABLE READ 격리 수준이라고 하더라도 `Phantom Read`가 발생할 수 있다. 
<br>
변경 사항에 대해서는 같은 트랜잭션 내에서는 동일한 데이터를 보장해주지만 추가된 데이터의 경우에는 마치 유령처럼 추가된 데이터도 조회가 되면서 데이터의 정합성이 깨지는 부분이다. 
<br> **하지만 InnoDB 스토리지 엔진에서는 갭 락과 넥스트 키 락 덕분에 REPEATABLE READ 격리 수준에서도 이미 `Phantom Read`가 발생하지 않는다.**

### *Phantom Read*
*Phantom Read*는 동일한 transaction 내에서 동일한 쿼리를 실행했을 때 먼저 수행된 쿼리에서 나오지 않았던 record가 나타나는 현상을 의미한다.


### MVCC(Multi Version Concurrency Control)  ?

일반적으로 레코드 레벨의 트랜잭션을 지원하는 DBMS가 제공하는 기능이며, MVCC의 가장 큰 목적은 **잠금을 사용하지 않는 일관된 읽기를 제공하는데 있다.**
<br> InnoDB는 언두 로그(Undo log)를 이용해 이 기능을 구현한다. 여기서 멀티 버전은 하나의 레코드에 대해 여러 개의 버전이 동시에 관리된다는 의미다.


### 잠금 없는 일관된 읽기(Non-Locking Consistent Read)

InnoDB 스토리지 엔진은 MVCC 기술을 이용해 잠금을 걸지 않고 읽기 작업을 수행한다. 잠금을 걸지 않기 때문에 InnoDB에서 읽기 작업은 다른 트랜잭션이 가지고 있는 잠금을 기다리지 않고, 읽기 작업이 가능하다.  
격리 수준이 READ_UNCOMMITED, READ_COMMITED, REPEATABLE_READ 수준인 경우 INSERT와 연결되지 않은 순수한 읽기 작업은 다른 트랜잭션의 변경 작업과 관계없이 항상 잠금을 대기하지 않고 바로 실행된다.  
특정 사용자가 레코드를 변경하고 아직 커밋을 수행하지 않았다고 하더라도 이 변경 트랜잭션이 다른 사용자의 읽기 작업을 방해하지 않는다.  
InnoDB에서는 변경되기 전의 데이터를 읽기 위해 언두 로그를 사용한다.

## 📌 SERIALIZABLE

가장 단순한 격리 수준이면서 동시에 가장 엄격한 격리 수준이다. 그만큼 동시 처리 성능도 다른 트랜잭션 격리 수준보다 떨어진다.
<br> SERIALIZABLE로 격리 수준을 설정하면 읽기 작업도 Shared-Lock을 획득해야만 한다. 즉, 한 트랜잭션에서 읽고 쓰는 레코드를 다른 트랜잭션에서는 절대 접근할 수 없다.



