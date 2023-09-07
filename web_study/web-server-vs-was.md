# Web Server Vs Web Application Server

## Web Server란 무엇일까?
Web Server는 클라이언트로 부터 요청에 대한 정적 컨텐츠를 제공하는 소프트웨어이다.
하지만 SSR로 JSP와 같이 정적 파일을 전달 하는 방식에 적용되는 부분이지 않을까 생각이 든다.(너무 내가 이 정적 컨텐츠라는 키워드에 사로 잡혀있지 않았을까)

Web Server는 정적 컨텐츠를 제공하는 역할 뿐만 아니라 현재는 훨씬 더 많은 역할을 수행하고 있다.
Web Server라고 하면 대표적으로 Apache, NginX를 얘기 하게 되는데 둘에 대해서 살펴보자.

## Apache 
* 프로세스 기반 멀티스레딩 아키텍쳐를 사용하여 요청 마다 thread/process를 생성하여 처리한다.
* 요청을 처리하기 위해서 멀티 스레드 방식을 따른다.
* 자체적으로 동적 컨텐츠를 처리한다?

## Nginx
* Apache의 C10K문제를 해결하기 위해 만들어졌다.
  * C10K: "Concurrent Connections of 10,000" 10,000개의 동시 접속한 상황을 나타냄
* 이벤트 기반 아키텍쳐를 사용하여 한 개 혹은 고정된 양의 프로세스만 생성하고 여러 개의 Connection을 모두 Event-Handler를 통해 비동기 방식으로 처리한다.
* NginX에는 다양한 특징들이 존재한다. 
  * Reverse Proxy: 사전적 의미로 '대리'의 뜻을 가지고 있다. 네트워크와 WAS 사이에 Web Server를 두어서 다양한 처리를 할 수 있다.
  * Caching, Logging, Load-Balancing, SSL, 보안 등 다양한 기능들을 제공하며 Redirect를 통한 WAS를 외부에 숨길 수 있는 특징을 가지고 있다.


## NginX를 사용한 이유?
1. Apache에 비해 높은 성능과 적은 메모리 사용 때문에 사용하게 되었다.

프로세스 기반 멀티스레딩 아키텍쳐를 사용하는 Apache는 요청 마다 thread 혹은 process 를 생성하여 처리한다.
반면에 NginX는 event-driven-architecture로 비동기 방식으로 요청을 처리한다. 또한 프로세스를 고정적으로 생성하여 활용할 수 있기 때문에 context-switching에 대한 비용이 절대적으로 적게 소모된다.


2. 이 부분은 Apache에서도 동일한 기능을 제공하지만 적어보자면, NginX를 Reverse Proxy(중개자 서버) 로 두었을 때 다양한 이점들이 존재하기 때문이다.
Caching, Load Balancing, Logging, 보안적인 부분, WAS를 외부로 부터 숨길 수 있고  SSL 인증처리, 압축 등의 장점들 때문에 NginX를 사용하게 되었다.


## Web Application Server란 무엇일까?
WAS는 클라이언트의 요청에 따라 동적인 웹 컨텐츠를 생성하고 처리하는 소프트웨어이다.
회원 가입과 같은 경우 클라이언트의 요청을 했을 때 유효한 데이터인지, 그리고 중복 데이터 인지 등을 DB Server와 연계해서 처리하고 저장하게 된다.
이와 같은 동적으로 처리하는 소프트웨어를 WAS라고 한다.
---

updated 23.09.07

## Web Server란?
Web Server는 기본적으로 Serving(제공) 하는 소프트웨어이다.
* Http를 기반으로 동작하는 서버이다.
* 정적 리소스를 제공하고, 기타 부가기능들을 제공한다.
* 정정(파일) HTML, CSS, JS, 이미지, 영상

## WAS란?

* http기반으로 동작한다.
* 웹 서버 기능을 포함 하고 있다.
* 프로그램 코드를 실행해서 애플리케이션 로직을 수행한다.
  * 동적 HTML, HTTP API(JSON)
  * 서블릿, JSP, 스프링 MVC
* 예) Tomcat, Jetty, Undertow

## WebServer와 WAS의 차이?

크게 웹서버는 정적 리소스(파일)를 제공해준다, WAS는 애플리케이션 로직까지 실행할 수 있는 것
하지만 둘의 관계 역시 모호하다. 왜냐하면 웹 서버도 플러그인을 설치한다면 프로그램 실행 로직을 포함할 수 있고, was 역시 웹 서버의 기능을 제공하기 떄문이다.

자바 같은 경우에는, 서블릿 컨테이너 기능을 제공하면 was라고 한다. 
정리하자면, was는 애플리케이션 코드를 실행하는데 더 특화되어 있다고 정리하자.

## web server없이 was와 db server만 가지고 있을 경우?
was가 너무 많은 역할을 담당하기 때문에 서버 과부하가 우려된다. 
가장 비싼 애플리케이션 로직이 정적 리소스 때문에 수행이 안될 수 있다.
그리고, was 장애 시에 오류 화면도 노출이 불가능하다.


## Reference
[Apache Vs NGINX – Which Is The Best Web Server for You?](https://serverguy.com/comparison/apache-vs-nginx/)
[스프링 MVC 1편](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-mvc-1/dashboard)
