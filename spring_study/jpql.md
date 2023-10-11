# JPQL

## 📗 JPQL이란?

JPQL(Java Persistence Query Language)은 **객체 지향 쿼리 언어**이다.<br>
테이블을 대상으로 쿼리하는 것이 아니라 Entity 객체를 대상으로 쿼리한다.
JPQL은 SQL을 추상화 해서 특정 DB SQL에 의존하지 않는다.

## 📗 JPQL의 문제점
* JPQL은 기본 문자열로 작성되기 때문에 컴파일 시 에러를 발생하지 않는다.
* 동적 쿼리를 작성하는데 비효율적이다.

## 📗 JPQL과 SQL의 차이점
* JPQL Entity 객체를 대상으로 쿼리한다.
* SQL은 데이터베이스 테이블을 대상으로 쿼리한다.

```java
public class JpaMain {
	public static void main(String[] args) {
        //...
        
        TypedQuery<Member> query = em.createQuery("select m from Member m", Member.class);
		List<Member> members = query.getResultList();
		//...
	}
}
```
위에서 JPQL 문법으로 작성된 쿼리 `select m from Member m`를 보면 Member Entity 객체를 말하며 Member Table을 의미하지 않는다.

```sql
SELECT * FROM MEMBER;
```
위에 SQL 문법으로 작성된 쿼리는 Member의 Table을 대상으로 쿼리한다.


## Reference
* [[JPA] JPQL(Java Persistence Query Language)이란?](https://dev-coco.tistory.com/141)