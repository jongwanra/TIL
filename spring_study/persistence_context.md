# 영속성 컨텍스트(Persistence Context)

JPA에서 가장 중요한 2가지라고 한다면,

> 1. 객체와 관계형 데이터베이스 매핑하기
> 2. 영속성 컨텍스트
> [자바 ORM 표준 JPA 프로그래밍 - 기본편(영한님)](https://www.inflearn.com/course/ORM-JPA-Basic/dashboard)


## 📗 EntityManagerFactory & EntityManager

웹 애플리케이션 내부에서 처음 실행 시, EntityManagerFactory Instance를 Database 당 1개를 생성한다.<br>
이후 요청이 올 때마다 EntityManagerFactory에서는 EntityManager를 생성하게 되고 Connection Pool에서 Idle상태인 Connection을 가져오고 사용하게 된다.

## 📗 영속성 컨텍스트란?

> A persistence context is a set of entity instances in which for any persistent entity identity 
> there is a unique entity instance. Within the persistence context, the entity instances and their lifecycle are managed.
> <br> [Oracle](https://docs.oracle.com/javaee/7/api/javax/persistence/EntityManager.html)

JPA에서 영속성 컨텍스트는 Entity를 관리하는 환경을 의미한다.

## 📗 Entity의 생명주기

### 비영속(new/transient)
영속성 컨텍스트와 전혀 관계가 없는 새로운 상태를 의미한다.

```java

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
	
    try{
      // Entity를 생성한 상태(비영속)
      Member memberA = new Member(1L, "memberA");

      em.persist(memberA);
      tx.commit();
    }catch (Exception e) {
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }
}
```
memberA를 생성하기만 한 상태를 **비영속 상태**라고 한다.

### 영속(managed)
  * 영속성 컨텍스트에 관리되는 상태
  * 생성하고 나서 persist() method를 통해 영속 상태가 되기도 하고,
  * 따로 조회를 했을 때 1차 캐시에 없을 경우에 db에서 조회해서 1차 캐시에 넣는 케이스도 영속 상태라고 표현한다.

```java

public class JpaMain {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();
    tx.begin();
	
    try{
      // Entity를 생성한 상태(비영속)
      Member memberA = new Member(1L, "memberA");
	  
	  // Entity를 persist한 상태/영속성 컨텍스트에 관리되는 상태(영속)
      em.persist(memberA);
	  
      tx.commit();
    }catch (Exception e) {
      tx.rollback();
    }finally {
      em.close();
    }
    emf.close();
  }
}
```

em.persist() method를 호출하면서 영속성 컨텍스트에서 관리가되게 된다. 
해당 상태를 **영속 상태**라고 한다. 
영속 상태가 되었다고 해서 Database에 데이터가 저장이 되는 것이 아니라 1차 캐시에 저장이되고 
동시에 Insert Query를 생성해서 쓰기 지연 SQL 저장소에 저장한다.

> 왜 이렇게 query를 모을까? 장점이 있을까? 
> 한 번에 하게 되면 버퍼링 기술(?)을 사용할 수 있다.
> <property name="hibernate.jdbc.batch_size" value="10"/>
> 계속 모았다가 batch-size가 초과하게 되면 한 번에 데이터를 보낼 수 있다.

---
21:20
JPA는 내부적으로 객체를 영속하는 시점에 초기 값을 snapshot을 떠둔다.
그리고 JPA는 commit을 하는 시점에 내부적으로 flush() method를 호출하는데, 호출이 되었을 때 변경이 되었는지 snapshot과 비교를 하고
변경이 되었다고 하면 update query를 쓰기 지연 SQL 저장소에 저장하고 DB에 반영 하게 된다.(Dirty Checking)

### 준영속(detached)
  * 영속성 컨텍스트에 저장되었다가 분리된 상태
### 삭제(removed)
  * 삭제된 상태
  * flush도 commit도 발생하지 않은 상태이다.
  * remove method호출 이후에 쓰기 지연 SQL 저장소에 delete query가 생성된다.
```java
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try{
            // Entity를 생성한 상태(비영속)
            Member memberA = new Member(1L, "memberA");
            Member memberB = new Member(2L, "memberB");
            Member memberC = new Member(3L, "memberC");

            em.persist(memberA);
            em.persist(memberB);
            em.persist(memberC);
			
            em.flush();

            System.out.println("====");
            Member findMember = em.find(Member.class, 1L);
            System.out.println("before removed====");
            em.remove(findMember);
            System.out.println("after removed====");
            Member removedMember = em.find(Member.class, 1L);
			// removedMember = null
            System.out.println("removedMember = " + removedMember);
            // delete query가 commmit 시점에 발생한다.
            tx.commit();
        }catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
```


## 📗 영속성 컨텍스트의 이점

* 1차 캐시
* 동일성 보장
* 트랜잭션을 지원하는 쓰기 지연(transactional-write-behind)
* 변경 감지(Dirty Checking)
* 지연 로딩(Lazy Loading)

## 📗 Flush

* 영속성 컨텍스트의 변경내용을 데이터베이스에 반영한다는 의미

### flush가 발생한다면?

1. Dirty Checking(변경 감지)이 일어난다.
2. 수정된 엔터티들을 쓰기 지연 SQL 저장소에 등록한다.
3. 쓰기 지연 SQL 저장소의 쿼리를 데이터베이스에 전송한다.(등록, 수정, 삭제 쿼리)

주의 1) flush가 발생한다고 해서 transaction의 commit이 발생하는 것은 아니다.
주의 2) flush가 발생한다고 해서 1차 캐시가 지워지는 것은 아니다. 그대로 유지된다.


### 영속성 컨텍스트를 flush하는 방법

* em.flush() - 직접 호출
* transaction commit - flush 자동 호출
* JPQL 쿼리 실행 - flush 자동 호출

```java
public class JpaMain {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try{
			Member memberA = new Member(1L, "memberA");
			Member memberB = new Member(2L, "memberB");
			Member memberC = new Member(3L, "memberC");

			em.persist(memberA);
			em.persist(memberB);
			em.persist(memberC);
			
			// 중간에 JPQL 실행 - 자동 flush() 실행됨
            // 단순히 영속상태인 memberA, memberB, memberC가 조회된다.
			TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
			List<Member> members = query.getResultList();

			
			/*
			    output
                name: memberA
                name: memberB
                name: memberC

			 */
			members.stream()
				.forEach(v -> System.out.println("name: " + v.getName()));

			tx.commit();
		}catch (Exception e) {
			tx.rollback();
		}finally {
			em.close();
		}
		emf.close();
	}
}
```


## 📗 준영속 상태

영속 상태인 Entity를 영속성 컨텍스트에서 떼어낸(분리한) 상태를 **준영속 상태**라고 한다.

### 준영속 상태로 만드는 방법
* em.detach(Object) -> 영속 상태인 Object를 영속성 컨텍스트 내부에서 떼어냄(지움)
* em.clear() -> EntityManager 내부의 영속성 컨텍스트를 다 지워버림
* em.close() -> 영속성 컨텍스트를 닫아버림.