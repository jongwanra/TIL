# @AutoConfiguration

일반적으로 자주 사용하는 수 많은 빈들을 자동으로 등록해주는 기능이다.
`Jdbc Template`, `DataSource`, `TransactionManager` 모두 스프링 부트가 자동 구성을 제공해서 자동으로 스프링 빈으로 등록된다.
스프링 부트는 `spring-boot-autoconfigure`라는 프로젝트 안에서 수 많은 자동 구성을 제공한다.
Auto Configuation - 자동 설정, 자동 구성, 자동 배치
@Conditinal: 특정 조건이 맞을 때 설정이 동작하도록 한다.
@AutoConfiguration: 자동 구성이 어떻게 동작하는지 내부 원리 이해 필요
스프링 부트는 다음 경로에 있는 파일을 읽어서 스프링 부트 자동 구성으로 사용한다.
`resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports`

## 동작 순서

1. `@SpringBootApplication`
2. `@EnableAutoConfiguration` => AutoConfiguration을 활성화 하는 기능
3. `@Import(AutoConfigurationImportSelector.class)`
4.  `resources/META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports` 파일을 열어서 설정 정보 선택
5. 해당 파일의 설정 정보가 스프링 컨테이너에 등록되고 사용된다.

## ImportSelector
`@Import`에 설정 정보를 추가하는 방법은 2가지가 있다.
* 정적인 방법: `@Import` 클래스는 정적이다. 코드에 대상이 딱 박혀 있다. 설정으로 사용할 대상을 동적으로 변경할 수 없다.
* 동적인 방법: `@Import('ImportSelector')` 코드로 프로그래밍해서 설정으로 사용할 대상을 동적으로 선택할 수 있다.