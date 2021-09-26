# [210927] REST API

## REST란?

- REpresentational State Transfer의 약자.
- HTTP를 기반으로 클라이언트가 서버의 리소스에 접근하는 방식을 규정한 아키텍처
- REST API는 REST를 기반으로 서비스 API를 구현한 것을 의미

## REST API의 구성

- 자원(Resource) → 자원
- 행위(verb) → 자원에 대한 행위
- 표현(representations) → 자원에 대한 행위의 구체적 내용

## REST API 설계 원칙

가장 중요한 기본적인 원칙은 2가지.

1. URI(Uniform Resource Identifier, 인터넷 자원을 나타내는 고유 식별자)는 리소스를 표현해야 한다.
    1. URI는 리소스를 표현하는 데 중점을 두어야 한다. 리소스를 식별할 수 있는 이름은 동사보다는 명사를 사용한다.

1. 리소스에 대한 행위(verb)는 HTTP 요청 메소드로 표현한다.

![Untitled](%5B210927%5D%20REST%20API%2095535427f317406599bcbb48b275ca0f/Untitled.png)

## Reference

- 모던 자바스크립트 Deep Dive : 자바스크립트의 기본 개념과 동작 원리, 이웅모 지음