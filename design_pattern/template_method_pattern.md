# 템플릿 메서드 패턴

## 템플릿 메서드 패턴이란?

> 템플릿 메서드 디자인 패턴의 목적은 다음과 같습니다.<br>
> "작업에서 알고리즘의 골격을 정의하고 일부 단계를 하위 클래스로 연기합니다.<br>
> 템플릿 메서드를 사용하면 하위 클래스가 알고리즘의 구조를 변경하지 않고도 알고리즘의 특정 단계를 재정의할 수 있습니다." <br>
> [GOF Design Pattern](https://www.yes24.com/Product/Goods/17525598)

GOF 디자인 패턴에서는 템플릿 메서드 패턴을 위와 같이 정의했다.
<br>

위와 같이 정의하면 아무래도 이해하기가 버겁다. 
<br>

내가 이해한 템플릿 메서드 패턴은 <br>
변경되는 로직과 변경되지 않는 로직을 어떻게 분리하면 좋을까에 대한 문제를 상속과 다형성을 이용해 해결하는 디자인 패턴이다.<br>


하나의 요구사항이 들어왔다고 가정해보자.

> "전체 비즈니스 로직에 대한 처리 시간을 알고 싶어요."

이러한 요구 사항은 어떻게 해결할 수 있을까? <br>
가장 먼저드는 생각은 각 비즈니스 로직에다가 처리 시간을 재는 코드를 추가하면 된다.

ServiceA, ServiceB, ServiceC를 준비 했고 각각 비즈니스 로직의 처리 시간을 측정하기 위해서 공통 로직을 포함 시켰다.

```java
public class ServiceA {
	void execute() {
		long startTime = System.currentTimeMillis();
		System.out.println("execute serviceA business logic");
		long endTime = System.currentTimeMillis();

		long result = (endTime - startTime);
		System.out.println("처리 시간: " + result + "ms");
	}
}
```

```java
public class ServiceB {
	void execute() {
		long startTime = System.currentTimeMillis();
		System.out.println("execute serviceB business logic");
		long endTime = System.currentTimeMillis();

		long result = endTime - startTime;
		System.out.println("처리 시간: " + result + "ms");
	}
}
```


```java
public class ServiceC {
	void execute() {
		long startTime = System.currentTimeMillis();
		System.out.println("execute serviceC business logic");
		long endTime = System.currentTimeMillis();

		long result = endTime - startTime;
		System.out.println("처리 시간: " + result + "ms");
	}
}

```

```java

public class TemplateMethodTest {
	@Test
	void 각_서비스에_공통_로직을_추가한다() {
		ServiceA serviceA = new ServiceA();
		ServiceB serviceB = new ServiceB();
		ServiceC serviceC = new ServiceC();

		serviceA.execute();
		serviceB.execute();
		serviceC.execute();
	}
}
```

이러한 간단한 방식에 문제는 무엇일까? <br>
문제는 `변경`시에 일어난다. 각 요청에 'ms'를 없애달라고 요청을 한다면? Service가 3개 밖에 없다면 문제가 없겠지만, 실무에서는 전혀 다른 규모일 것이다. 10,000군데 이상을 바꿔야 한다면?

<br>
그리고 SRP에 대해서도 생각해보자. 

> 하나의 클래스를 변경하는 이유는 오직 하나 뿐이어야 한다.

SRP의 관점으로 봤을 떄 시간 측정은 다른 역할이다. 그렇기 때문에 SRP 원칙을 위배한다고도 볼 수 있다.

그러면 위에서 말했던 템플릿 메서드 패턴을 적용해 보자. <br>

우선 공통 로직을 담을 상위 클래스 즉, 템플릿을 추상 클래스로 정의한 이후에 공통 로직을 수행할 메서드를 만들자. 그리고 변경되는 로직은 하위 클래스에서 구현할 수 추상 메서드로 정의하자.

```java

public abstract class TimeTemplate {
	void execute() {
		long startTime = System.currentTimeMillis();
		call();
		long endTime = System.currentTimeMillis();

		long result = (endTime - startTime);
		System.out.println("처리 시간: " + result + "ms");
	}


	protected abstract void call();
}
```

이렇게 추상 클래스로 정의한 상위 클래스를 ServiceA, ServiceB, ServiceC에서는 상속을 받아서 call() method를 구현하자.

```java
public class ServiceA extends TimeTemplate {
	@Override
	protected void call() {
		System.out.println("execute serviceA business logic");
	}
}
```

```java
public class ServiceB extends TimeTemplate{

	@Override
	protected void call() {
		System.out.println("execute serviceB business logic");
	}
}
```


```java
public class ServiceC extends TimeTemplate{
	@Override
	protected void call() {
		System.out.println("execute serviceC business logic");
	}
}
```


```java
public class TemplateMethodTest {
	@Test
	void 템플릿_메서드_패턴을_활요해서_변화되지_않는_로직을_분리한다() {

		TimeTemplate serviceA = new ServiceA();
		TimeTemplate serviceB = new ServiceB();
		TimeTemplate serviceC = new ServiceC();

		serviceA.execute();
		serviceB.execute();
		serviceC.execute();
	}
}
```

위에 테스트 코드와 같이 실행하면 동일한 결과를 얻을 수 있다. <br>
이제 요구사항이 변경이 일어났을 떄 전체 Service를 변경하는 것이 아닌 Template으로 지정한 상위 추상 클래스에서만 변경해주면 한 번에 변경할 수 있고 SRP 원칙도 지킬 수 있게 되었다.
<br>

위에서 다시 정의를 상기해 보자. <br>

**변경되는 로직과 변경되지 않는 로직을 분리하는 문제를 상속과 다형성으로 해결하는 디자인 패턴.**

하지만 이렇게 템플릿 메서드 패턴을 이용해서 분리하게 된다면 상속의 문제점을 고스란히 가져가게 된다. <br>
상속을 했을 경우, 강한 결합으로 인해서 상위 클래스에서의 변화가 상속 받은 하위 클래스에 영향을 미칠 수 있다. 이 것은 상당한 위험을 지니고 있다.


## Spring에서 Template Method Pattern은 어떻게 적용되어 있을까?

FrameworkServlet class와 DispathcerServlet Class에서 확인할 수 있다.<br>
잠시 구조를 보자.<br>

![img_1.png](template_method1.png)

<br>
FrameworkServlet에서는 doService() method를 따로 하위 클래스에서 구현하도록 위임했다. 그리고 DispatcherServlet에서는 doService() method를 구현했다.
FrameworkServlet과  DispatcherServlet은 변경되는 로직과 변경되지 않은 로직을 분리하는 작업을 탬플릿 메서드 패턴을 이용하 것으로 확인할 수 있다.

```java
public abstract class FrameworkServlet extends HttpServletBean implements ApplicationContextAware {
	// ...
	protected final void processRequest(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		long startTime = System.currentTimeMillis();
		Throwable failureCause = null;

		LocaleContext previousLocaleContext = LocaleContextHolder.getLocaleContext();
		LocaleContext localeContext = buildLocaleContext(request);

		RequestAttributes previousAttributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes requestAttributes = buildRequestAttributes(request, response, previousAttributes);

		WebAsyncManager asyncManager = WebAsyncUtils.getAsyncManager(request);
		asyncManager.registerCallableInterceptor(FrameworkServlet.class.getName(), new RequestBindingInterceptor());

		initContextHolders(request, localeContext, requestAttributes);

		try {
			// 변경되는 로직 하위 클래스로 위임
            // --------------------
			doService(request, response);
			// --------------------
		}
		catch (ServletException | IOException ex) {
			failureCause = ex;
			throw ex;
		}
		catch (Throwable ex) {
			failureCause = ex;
			throw new ServletException("Request processing failed: " + ex, ex);
		}

		finally {
			resetContextHolders(request, previousLocaleContext, previousAttributes);
			if (requestAttributes != null) {
				requestAttributes.requestCompleted();
			}
			logResult(request, response, failureCause, asyncManager);
			publishRequestHandledEvent(request, response, startTime, failureCause);
		}
	}
    
	// 하위 클래스로 위임한 doService() method
	protected abstract void doService(HttpServletRequest request, HttpServletResponse response)
		throws Exception;

}
```


```java
public class DispatcherServlet extends FrameworkServlet {
    // FrameworkServlet에서 위임한 doService() method를 하위 클래스인 DispatcherServlet에서 재정의 했다.
	@Override
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//...
	}
}
```






