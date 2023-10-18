# Spring Profile

updated. 23.10.18

**Spring Profiles는 특정 환경에 따라 애플리케이션을 동작시킬 수 있게끔 도와주는 기능이다.**
@Profiles("prod) 와 같은 annotation을 통해서 @Configuration, @Component annotation을 포함한 class에 적용해서  어떤 환경일 때 포함할지를 정할 수 있고
application-dev.yml 파일 과 같이 spring.profiles.active 와 같은 환경 변수를 가지고 다른 환경에서 애플리케이션을 동작 시킬 수 있다.
---

## 📗 Spring Profile이란?

Spring Framework에서 `Spring Profile`은 특정 환경 또는 조건에 따라 애플리케이션의 동작을 설정하는데 사용되는 기능을 의미한다.
즉, 로컬 환경, 테스트 환경, 개발 환경, 운영 환경과 같이 각각의 환경에 따라 애플리케이션을 동작시킬 수 있게끔 도와주는 기능을 의미한다.

## 📗Spring Profile환경을 어떻게 구성할 수 있을까?

우선 환경에 맞게 application.yml file을 만들어 준다.

![spring_profile_03.png](images/spring_profile_03.png)

test를 위해서 -dev.yml, -prod.yml 파일을 생성했다. 
Spring Boot에서는 -{environment} 명을 통해서 환경 정보를 파악할 수 있다.

### build한 jar 파일을 실행 시킬 때 옵션을 추가한다.

build를 시키면 jar 파일이 생성된다.

```shell
./gradle build
```
![spring_profile_01.png](images/spring_profile_01.png)

해당 빌드 파일을 실행시킬 때 아래의 옵션을 추가한다.

```shell
java -jar ./build/libs/outfit-of-the-day-0.0.1-SNAPSHOT.jar --spring.profiles.active=dev
```
그러면, 아래와 같이 실행시킬 수 있다.

![spring_profile_02.png](images/spring_profile_02.png)


### 로컬 환경에서 active Profiles 세팅하기

1. Intellij 상단 탭에 Run -> Edit Configuration을 클릭한다.
2. Active profiles에 원하는 환경 정보를 입력하고 실행한다.

![spring_profile_04.png](images/spring_profile_04.png)


## 참고

* [Part IV. Spring Boot features](https://docs.spring.io/spring-boot/docs/1.2.0.M1/reference/html/boot-features-profiles.html)

