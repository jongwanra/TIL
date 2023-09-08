# Servlet

## Servlet?
Servlet이란? 비즈니스 로직을 제외한 http 요청과 응답에 대한 처리를 제공해주는 클래스이다.

### Servlet을 
## Servlet Container?
* 톰캣처럼 서블릿을 지원하는 WAS를 서블릿 컨테이너 라고 한다.
* 서블릿 컨테이너는 서블릿 객체를 생성, 초기화, 호출, 종료하는 생명주기를 관리한다.
* 서블릿 객체는 `싱글톤으로 관리`한다.
* JSP역시 서블릿으로 변환 되어서 사용
* `동시 요청을 위한 멀티 쓰레드 처리 지원을 해준다.`

## Servlet은 어떻게 동작할까?

브라우저에서 요청을 하면, WAS는 Http 요청 메시지를 기반으로 request, response객체를 생성한다. 
생성한 request, response객체를 파라미터로 넘겨서 서블릿 객체를 호출한다. 

```java

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet  extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException,
		IOException {
	}

}
```