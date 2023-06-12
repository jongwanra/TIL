
## Content

* `@NotEmpty` annotation 사용을 하려고 하는데 import가 안됨.

## Cause

* `@NotEmpty` annotation은 javax.validation.constraints package에만 존재
* 해당 패키지는 스프링 부트 2.2 이하에 포함되어 있지만 2.3 이상부터는 의존성 추가가 필요


## Solved
* Dependency 추가 필요
* build.gradle

```gradle
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-validation'
}
```



## Reference 
https://hello-u.tistory.com/entry/spring-boot-NotEmpty-import-%EC%95%88%EB%90%A0-%EB%95%8C