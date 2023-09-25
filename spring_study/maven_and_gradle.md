# Maven and Gradle

Maven과 Gradle은 공통적으로 **빌드 자동화 도구**이다. 그러면 빌드 자동화 도구란 무엇일까?

## 빌드 자동화 도구란?

* 소스 코드를 컴파일, 테스트, 정적분석 등을 실행하여 실행 가능한 애플리케이션으로 만들어 준다.
* 프로젝트 정보 관리, 테스트 빌드, 배포 등의 작업 역시 진행해준다.
* 외부 라이브러리를 참조하여 자동으로 다운로드 및 업데이트 관리를 해준다.

## Maven

### Maven이란?

자바의 대표적인 관리 도구였던 'Ant'를 대체하기 위해 개발되었다.<br>
프로젝트의 외부 라이브러리를 쉽게 참조할 수 있게 pom.xml 파일로 명시하여 관리한다.<br>
참조한 외부 라이브러리에 연관된 다른 라이브러리도 자동으로 관리해준다.

아래는 pom.xml 파일을 가져와 보았다.
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>3.1.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.example</groupId>
	<artifactId>demo</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>demo</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```

### 메이븐을 왜 사용해야 할까?
기존에 사용하던 Ant는 빌드의 기능만을 가지고 있다.<br> 
Maven은 위 빌드 기능을 포함해 라이프 사이클을 가지고 있고, pom.xml로 편하게 Dependency를 관리해준다.

## Gradle

### Gradle이란?

Gradle은 Groovy 기반 오픈 소스 빌드 자동화 도구이다.

* 빌드: 소스 코드를 컴파일, 테스트, 정적분석 등을 실행하여 실행 가능한 애플리케이션으로 만들어주는 과정
* Grooby: JVM 상에서 실행되는 스크립트 언어이다. Java와 유사한 문법 구조를 가지며, 호환성이 아주 좋다. 

## 왜 Gradle을 사용해야 할까?
### 1. 간결한 스크립트로 되어있다.

Gradle 이전의 빌드 도구인 Ant와 Maven은 XML 문법으로 스크립트를 작성했다. XML은 여는 태그와 닫는 태그를 넣어야 하기 때문에 복잡한 빌드 스크립트를 작성하기가 어려우며 가독성이 떨어진다.
반면 Gradle은 Groovy 문법으로 간결한 스크립트를 작성할 수 있다.

### 2. 빌드 속도가 빠르다.
프로젝트 규모가 커짐에 따라 빌드 속도 차이가 개발 생산성에 영향을 미치게 된다. Gradle은 캐싱을 하기 때문에 Ant나 Maven 같은 이전 빌드 도구보다 빌드 속도가 빠르다. 
[빌드 캐시를 이용할 경우](https://gradle.org/maven-vs-gradle/) Gradle과 Maven의 빌드 속도가 최대 100배까지 벌어질 수 있다고 한다.

1. Incremental Builds

점진적 빌드는 이미 빌드된 파일들을 모두 다시 빌드하는 것이 아닌 바뀐 파일들만 빌드하는 것을 의미한다.

2. Build Cache

만약 두 개 이상의 빌드가 돌아가고, 하나의 빌드에서 사용되는 파일들이 다른 빌드들에 사용된다면 Gradle은 빌드 캐시를 이용해 이전 빌드의 결과물을 다른 빌드에서 
사용할 수 있다.

3. Gradle Daemon
> A long-lived process that keeps build information "hot" in memory [Gradle Docs](https://gradle.org/maven-vs-gradle/)
 
대몬은 빌드하는데 걸리는 시간을 줄여주는 오랜 수명을 가진 백그라운드 프로세스이다.

### 3. 멀티 프로젝트 빌드에 최적화 되어 설계되어 있다.


## Reference 
* [[10분 테코톡] 루나의 Gradle](https://www.youtube.com/watch?v=ntOH2bWLWQs)
* [자바 빌드 도구 'Gradle'의 특징과 사용 팁](https://yozm.wishket.com/magazine/detail/1700/)
* [Gradle vs Maven Comparison](https://gradle.org/maven-vs-gradle/)