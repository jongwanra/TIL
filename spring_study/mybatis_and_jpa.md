# JPA vs MyBatis

JPA와 MyBatis 각각 어떤 무엇이고, 어떤 장점/단점이 있는지 알아보자.

## MyBatis

### MyBatis란?
MyBatis는 Java Persistence Framework 중 하나로, XML 파일이나, Annotation을 사용하여
SQL 문으로 객체들을 연결시킨다. (SQL Mapper 라고 불림)

### Annotation을 활용한 방식

```java
package org.mybatis.example;

public interface BlogMapper {
    @Select("select * from Blog where id = #{id}")
    Blog selectBlog(int id);
}
```

```java
public class Test {
	public static void main(String[] args) {
        BlogMapper mapper = new session.getMapper(BlogMapper.class);
		Blog blog = mapper.selectBlog(101);
	}
}
```

BlogMapper Class와 같이 @Select Annotation 내부에 query문을 작성하고 mapper instance를 생성한 이후에 method를 실행한다.


### XML 파일을 활용한 방식

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="org.mybatis.example.BlogMapper">
    <select id="selectBlog" parameterType="int" resultType="Blog">
        select * from Blog where id = #{id}
    </select>
</mapper>
```
위와 같이 xml 파일에 쿼리문을 작성한다.

```java
public class Test {
	public static void main(String[] args) {
		Blog blog = session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
	}
}
```

작성한 이후에 session을 통해 사용할 수 있다.

### MyBatis 장점은?

* SQL 문을 직접 작성하기 때문에, 좀 더 세밀한 제어가 가능하며, 복잡한 쿼리, 동적 쿼리에 대해서도 유연하게 대처할 수 있다.
* XML 파일로 분리함으로써 query를 수정한 이후에 다시 빌드할 필요가 없다.

### MyBatis 단점은?

* table 혹은 entity가 변경이 될 때 마다 관련 query문을 수정해야하는 번거로움이 존재한다.
* runtime시에 오류를 확인할 수 있다.
* MySQL, Oracle, SQL Server 등 DBMS 제품 마다 SQL 문법이 조금씩 다르다. <br>
  관련 Database를 변경을 하게되면 database에 맞는 query문을 교체해줘야 한다.

  
## JPA

### JPA란?

Java Persistence API의 약자로 Java ORM 기술에 대한 API 표준 명세를 말한다.
JPA는 단순한 명세이기 때문에 JPA만 가지고는 어떤 구현 기술을 사용할 수 없다. 
실제로 우리가 사용하는 Repository는 Spring Data JPA로 부터 제공되는 기술이다.
Spring Data JPA는 JPA를 간편하게 사용하도록 만들어 높은 오픈 소스일 뿐이다. <br>
이와 비슷한 기술로  Spring Data Redis, Spring Data MongoDB 등이 존재한다.


### 장점?

* JPA는 query문을 작성할 필요가 없다. 그렇기 때문에 Database를 변경하더라도 소스코드를 수정할 필요가 없다.
* 타입 안정성, 지연 로딩, 쓰기지연, 1차 캐시 등을 제공하여 성능상 이점을 얻을 수 있다.
* 개발자 생산성을 향상시키고 오류를 줄일 수 있다.
* 코드를 줄일 수 있다.
* 컴파일 타임에 오류를 확인할 수 있다.(Java code 이기 때문)


### 단점?
* JPA만을 사용하여 복잡한 쿼리, 동적 쿼리등을 작업하는데 있어서 어려움이 있다. 
  * queryDSL로 해결 가능
* 초기 생산성을 극대화 시킬 수 있지만 점차 사용하다보면 성능상 이슈가 발생할 수 있다.(N+1, FetchType, Proxy, 연관관계 등)


## MyBatis, JPA 둘의 주요한 차이점은?

DB와의 상호 작용 방식의 차이가 있다. <br>
MyBatis는 Database와 상호작용할 때 개발자가 sql query를 직접 작성해서 사용하며, 매핑을 위해 XML 또는 annotation을 사용한다. <br>
반면에 JPA는 객체와 Database 간의 매핑을 제공하며 JPQL(Java Persistence Query Language)을 사용하여 Database와 상호작용한다.

## Reference 
* [마이바티스 위키 백과](https://ko.wikipedia.org/wiki/%EB%A7%88%EC%9D%B4%EB%B0%94%ED%8B%B0%EC%8A%A4)
* [MyBatis와 JPA의 차이, JPA를 선택한 이유는](https://lealea.tistory.com/239)
* [[MyBatis] MyBatis VS JPA/Hibernate](https://dev-coco.tistory.com/77)