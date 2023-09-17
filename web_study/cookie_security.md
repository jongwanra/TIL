# 쿠키 보안 관련

```java
public class TestCookieSecurity {
	public void testCookieSecurity() {
		Cookie cookie = new Cookie("key", "value");
		
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
    }
}
```

## Secure
Cookie Class 에는 setSecure() method가 존재한다.
해당 method는 true로 설정할 경우 https인 경우에만 보낸다는 의미이다. 
default값은 false이기 때문에 https가 적용이 안된 상태에서도 cookie가 함께 전달된다.
그럴 경우에는 해커에게 탈취를 당했을 때 평문 그대로 노출된다는 위험이 존재한다. 
따라서 true로 설정해줘야 한다.

## HttpOnly
Cookie class의 method에는 setHttpOnly() method가 존재한다.
HttpOnly는 XSS공격을 방지하는 옵션이다.

### XSS 공격이란?
XSS(Cross-Site Scripting)란 웹 애플리케이션에서 발생하는 보안 취약점 중 하나이다.

악의적인 사용자가 웹 페이지에 악성 스크립트를 삽입하여 다른 사용자의 브라우저에서 실행 되게 하는 공격을 의미한다.
이러한 공격은 주로 웹 애플리케이션에서 입력 데이터를 적절하게 필터링 하지 않거나 이스케이핑 하지 않을 때 발생한다.

> 예를 들어서, 
> 1. 게시글에 공격자가 Script태그가 달린 댓글을 남긴다. 
> 2. 해당 댓글 내용은 Script 태그를 포함해서 DB에 저장된다. 
> 3. 그 이후에 댓글을 본 다른 사용자의 브라우저에서 스크립트 코드가 실행된다.


### HttpOnly Option의 역할
HttpOnly가 설정되어 있는 쿠키는 브라우저에서 따로 접근을 할 수 없도록 막아준다. 그렇기 때문에 쿠키에 대한 XSS 공격을 방지할 수 있는 효과가 있다.
(Cookie탈취에 대한 문제를 어느 정도 해결 할 수 있을 뿐이다.)

## SameSite

SameSite Option은 서드 파티(타사) 쿠키의 보안적 문제를 해결하기 위해 만들어진 기술이다.
다른 도메인의 사이트(Cross-site)로 전송하는 요청의 경우 SameSite level을 어떻게 설정했는지 여부에 따라 level에 맡게 전송에 제한을 두고 있다.

SameSite는 쿠키의 정책으로 None, Lax, Strict 세 가지 종류를 선택할 수 있다.

* None: 어떤 사이트든 간에 항상 쿠키가 전송된다.
* Strick: 가장 보수적인 정책이다. Strict으로 설정된 쿠키는 Cross-site 요청에 전송 되지 않는다.
* Lax: 동일한 웹사이트의 경우 전송되며, Cross-site인 경우 상위 사이트 이동과 Safety Method의 경우 전송된다.

### Default: Lax
크롬에서는 20.02.04 크롬80 버전 부터 SameSite의 기본 값을 None -> Lax로 변경했다.

### 왜 SameSite의 정책을 변경했을까? (CSRF or XSRF)

CSRF(Crossw Site Request Forgery) 문제 때문이다.
CSRF란 `다른 사이트간 요청 위조`로, 피해자가 사이트 링크를 누르게끔 유도해서 누른 피해자의 쿠키와 같은 개인 정보를 탈취하는 공격을 의미한다.

쿠키는 Chrome 브라우저를 제외한 모든 브라우저에서 따로 설정을 하지 않는다면 
Cross-Site임에도 전송이 기본적으로 된다. 즉 모든 Http요청에 쿠키가 함께 요청된다.

그렇기 때문에 Chrome에서는 해당 공격에 대비하고자 SameSite 정책을 변경했다고 할 수 있다.


## Reference
* [Using HTTP cookies](https://developer.mozilla.org/en-US/docs/Web/HTTP/Cookies)
* [브라우저 쿠키와 SameSite 속성](https://seob.dev/posts/%EB%B8%8C%EB%9D%BC%EC%9A%B0%EC%A0%80-%EC%BF%A0%ED%82%A4%EC%99%80-SameSite-%EC%86%8D%EC%84%B1/)
* [Http Only와 Secure Cookie](https://theheydaze.tistory.com/550)
* [쿠키와 document.cookie](https://ko.javascript.info/cookie)