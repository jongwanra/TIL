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
XSS(Cross-Site Scripting)는 가장 널리 알려진 웹 보안 취약점 중 하나로..