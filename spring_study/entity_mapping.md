# Entity Mapping

### @Entity
* @Entity가 붙은 클래스는 JPA가 관리하는 Entity를 의미한다.
* JPA를 사용해서 테이블과 매핑할 클래스는 @Entity가 필수이다.
* 주의) **기본 생성자 필수**(매개변수가 없는 public or protected 생성자)
* 주의) final class, enum, interface, inner class 사용 X
* 주의) Database에 저장하고 싶은 Field에는 final 사용이 불가능하다.

### @Entity 속성 
* 속성: name
  * JPA에서 사용할 Entity 이름을 지정한다.
  * default: 클래스 이름을 그대로 사용(예: Member)
  * 같은 클래스 이름이 없으면 가급적 기본값을 사용한다.

### @Table
* @Table은 Entity와 매핑할 테이블을 지정한다.

### 스키마 자동 생성하기(hibernate.hbm2ddl.auto)

* create: 기존테이블 삭제 후 다시 생성 (drop -> create)
* create-drop: 종료시점에 테이블 drop(drop -> create -> drop)
* update: column을 추가하는 부분만 적용된다.(field 삭제했을 경우는 적용 X) => 실무에서 사용하지 말자.
* validate: entity와 table이 정상 매핑되었는지만 확인
* none: 사용X

운영에서는 절대 createm create-drop, update를 절대 사용하면 안된다.<br>
개발 서버에서 DB에 스크립트를 직접 적용하고 문제없으면 운영서버에 직접 DB scheme를 추가하자.
update로 설정을 해놓고, column이 추가가 되는 경우에 table 전체에 락이 걸리면서 몇 분동안 서버가 멈출 수 있기 때문. 
* 개발 초기 단계는 create or update
* 테스트 서버는 update or validate
* staging에서는 validate or none

### @Enumerated
EnumType은 절대 ORIGINAL을 사용하면 안된다.
EnumType.STRING으로 적용하자.

### @Temporal
LocalDate, LocalDateTime을 사용할 때는 생략이 가능해서 쓸 일이 없다.

### @Lob
데이터베이스 BLOB(이진 대형 객체 - Binary), CLOB(문자 대형 객체 - Character) 타입과 매핑
매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑을 한다.

### @Transient
* 필드 매핑X

## 📗기본 키 매핑

### @Id
- 직접 할당을 하고 싶은 경우
- 
### @GeneratedValue

```java
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
```
* GenerationType.AUTO: DB Dialect에 맞춰서 생성
* GenerationType.IDENTITY: 기본 키 생성을 데이터베이스에 위임 
  * 주로 MySQL, PostgreSQL에서 사용 (MySQL은 AUTO_INCREMENT)
  * JPA는 보통 Transaction Commit 시점에 Insert SQL 실행
  * **PK 값을 활용해서 1차 캐시의 키값으로 사용 한다, 영속성 컨텍스트에 넣기 때문에 JPA에서는 예외적으로 IDENTITY 시, em.persist() 때 insert query를 내보낸다.**

### 권장하는 식별자 전략
* 기본 키 제약 조건
  * null이면 안됨
  * unique
  * **변하면 안된다.**
* 미래까지 이 조건을 만족하는 자연키는 찾기 어렵다. 대치키를 사용하자.
  * 예를 들어 주민등록번호도 기본 키로 적절하지 않다.

* 권장: long형 or 대체키 or 키 생성전략 사용





## 참고
* [자바 ORM 표준 JPA 프로그래밍 - 기본편](https://www.inflearn.com/course/ORM-JPA-Basic/dashboard)