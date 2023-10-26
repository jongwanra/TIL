# Spring Rest Docs

## 📗 Spring Rest Docs란?

* 테스트 코드를 통한 API 문서 자동화 도구이다.
* API 명세를 문서로 만들고 외부에 제공함으로써 협업을 원활하게 한다.
* 기본적으로 AsciiDoc을 사용하여 문서를 작성한다.

## 📗 Rest Docs vs. Swagger

### Rest Docs
* 장점
  * 테스트를 통과해야 문서가 만들어진다. (신뢰도가 높다.)
  * 프로덕션 코드에서 자유롭다.
* 단점
  * 코드 양이 많다.
  * 설정이 어렵다.

### Swagger 
* 장점
  * 적용이 쉽다.
  * 문서에서 바로 API 호출을 수행해볼 수 있다.
* 단점
  * 프로덕션 코드에 침투적이다.
  * 테스트와 무관하기 떄문에 신뢰도가 떨어진다.


## 📗 설정 방법

### build.gradle setting

```groovy
plugins {
  // ...
  id "org.asciidoctor.jvm.convert" version "3.3.2" // (1)
}

configurations {
  // ...
  asciidoctorExt // (2) asciidoctor extension에 대한 설정을 넣어준다.
}

dependencies {
  // ...
  asciidoctorExt 'org.springframework.restdocs:spring-restdocs-asciidoctor' // (3)
  testImplementation 'org.springframework.restdocs:spring-restdocs-mockmvc' // (4)
}

tasks.named('test') {
  useJUnitPlatform()
}

ext {
  // (5) 전역 변수에 스니펫을 저장할 directory를 설정한다.
  snippetsDir = file('build/generated-snippets')
}

// (6) test가 끝난 결과물을 snippetsDir에 저장한다.
test {
  outputs.dir snippetsDir
}

// (7)
asciidoctor {
  inputs.dir snippetsDir
  configurations 'asciidoctorExt'

  sources { // 특정 파일만 html로 만든다.
    include("**/index.adoc")
  }
  baseDirFollowsSourceFile() // 다른 adoc 파일을 include할 때 경로를 baseDir로 맞춘다.
  dependsOn test // test가 수행된 이후에 asciidoctor가 수행된다.
}

// bootJar: 실행 가능한 .jar 파일을 만드는 역할을 수행한다.
bootJar {
  // (8) test -> asciidoctor 단계를 거친 이후에 bootJar를 수행한다.
  dependsOn asciidoctor
  // 생성된 문서를 static/docs 내부에 넣어준다.
  from("${asciidoctor.outputDir}") {
    into 'static/docs'
  }
}


```



