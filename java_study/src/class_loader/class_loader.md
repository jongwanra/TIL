# ClassLoader

![class-loader-system](./image/class-loader-system.png)

## Class Loader란?
* Class loaders are responsible for loading Java classes dynamically to the JVM (Java Virtual Machine) during runtime.
  * 클래스 로더는 런타임 동안에 JVM에 Java Class를 load하는 역할을 한다(역할을 하는 모듈이다).

## Class Loader의 종류
* Bootstrap ClassLoader
  * java.* 을 의미하는 *.class file을 load하는 역할
* Extension ClassLoader
  * 외부 라이브러리, 플러그인을 load하는 역할
* System/Application ClassLoader
  * 사용자 코드를 load하는 역할


## Class Loader의 동작 방식

### Loading
* 제일 먼저 method area에서 로드된 클래스가 있는지 여부를 파악한다.
* 없을 경우 System Class Loader -> Extension Class Loader -> Bootstrap Class Loader 순으로 위임된다. (recursivley 위임이 진행됨.)
* Bootstrap Class Loader -> Extension Class Loader -> System Class Loader 순으로 찾고자 하는 class가 있는지 여부를 체크 하며 내려 온다. 찾을 경우 해당 class가 load된다.
* 끝까지 찾지 못할 경우 ClassNotFoundException이 발생한다.

### Linking
* Linking은 3가지 단계로 동작한다.
* Verification(검증): 클레스 파일인지 유효한지 검증하는 단계이다.
* Preparation(준비): static field들을 위한 메모리 공간을 할당하고 초기 값으로 채우는 단계이다.(초기 값은 기본 값을 말한다.)
* Resolving(해결): class file을 요청한 class에서의 symbolic reference값을 실제 메모리 주소 값으로 변경하는 단계이다.


### Initialization
* static field들을 초기화 하고, static initialization block을 실행하는 단계 





## Reference
* https://velog.io/@jifrozen/JVM-%EA%B5%AC%EC%84%B1%EC%9A%94%EC%86%8C-1-%ED%81%B4%EB%9E%98%EC%8A%A4-%EB%A1%9C%EB%8D%94

