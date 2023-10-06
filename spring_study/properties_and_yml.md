# .properties Vs .yml

## application.yml/ application.properties 파일이란?

application.yml/ application.properties 파일은 Spring Boot 프레임 워크에서 사용하는 설정 파일이다. 이 파일은 애플리케이션의 구성을 정의하고 설정하는데 사용된다.
해당 파일을 이용해서 다양한 환경(test, local, dev, prod)에서 서로 다른 설정을 할 수 있고, 로깅, DB 연결 정보, 서버 포트 등을 정의할 수 있다.
해당 파일은 스프링 부트를 구동할 떄 자동으로 로딩된다.

## 어떤 차이가 있을까?

동일한 설정을 yml과 properties를 통해 보자.

### yml
```yaml

spring:
  h2:
    console:
      enabled: true
      path: /h2-console
  datasource:
    driver-class-name: org.h2.Driver
    url: jdbc:h2:tcp://localhost/~/test
    username: sa
  #    password:

  jpa:
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        show_sql: true
        format_sql: true
        default_batch_fetch_size: 100



```

### properties

```properties
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.username=sa

spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.default_batch_fetch_size=100
```

스프링 부트에서 사용되는 설정 파일의 두 가지 형식으로 같은 목적으로 사용되지만 **구문과 표현 방식에 차이**가 있다.

### 계층 구조 및 복잡성
yml 파일은 YAML 형식을 사용하여 계층 구조로 표현한다. 따라서 복잡한 설정을 더 간결하게 작성이 가능하다. 반면에 properties 파일은 평면적인 key value형식으로 설정을 표현한다.

### 데이터 유형
yml 파일은 YAML이 제공하는 리스트, 맵 등의 데이터 유형을 사용할 수 있다. 반면에 properties는 기본적으로 문자열 형태의 값만 표현이 가능하다.

```yaml
# list 표현
myapp:
  users:
    - name: Alice
      age: 30
      roles:
        - USER
        - ADMIN
    - name: Bob
      age: 25
      roles:
        - USER
```
위와 같이 '-'을 통해서 리스트를 표현 가능하다. 

```properties
# properties
myapp.users[0].name=Alice
myapp.users[0].age=30
myapp.users[0].roles[0]=USER
myapp.users[0].roles[1]=ADMIN

myapp.users[1].name=Bob
myapp.users[1].age=25
myapp.users[1].roles[0]=USER
```
반면에 properties는 리스트를 문자열 형식으로 표현한다.

### 대/소문자 구분
properties 는 대/소문자가 다르면 다른 속성으로 취급한다. 반면에 yml 파일은 대/소문자가 다르더라도 같은 속성으로 취급한다.

## 📗 참고
* [개발 환경 분리](https://bigpel66.oopy.io/5c650fcd-a600-465c-915e-b5b729d16ef1)
* [[Spring Boot] application.properties와 application.yml의 차이점](https://colabear754.tistory.com/90)
* [https://www.w3schools.io/file/yaml-vs-properties/](https://www.w3schools.io/file/yaml-vs-properties/)