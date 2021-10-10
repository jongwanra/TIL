# [211010] Middleware

![Untitled](./%5B211010%5D%20Middleware%20/Untitled.png)

request-response cycle

## Middleware란?

- 미들웨어에 대한 공식 문서
    
    > "Middleware functions are functions that have access to the request object (req), the response object (res), and the next function in the application’s request-response cycle."
    > 
    
    직역해 보면, 미들웨어는 req(요청) 객체, res(응답) 객체, 그리고 어플리케이션 요청-응답 사이클 도중 그 다음의 미들웨어 함수에 대한 접근 권한을 갖는 함수이다.
    

- [What is Express Middleware?](https://developer.okta.com/blog/2018/09/13/build-and-understand-express-middleware-through-examples) 에서의 미들웨어

> Middleware literally means anything you put in the middle of one layer of the software and another. Express middleware are functions that execute during the lifecycle of a request to the Express server. Each middleware has access to the HTTP request and response for each route (or path) it’s attached to. In fact, Express itself is compromised wholly of middleware functions.
> 

미들웨어는 말 그대로 소프트웨어의 한 계층과 다른 계층의 중간에 배치하는 모든 것을 의미한다. Express 미들웨어는 Express 서버에 대한 요청의 수명 주기 동안 실행되는 함수들이다. 각 미들웨어는 연결된 각 경로(또는 경로)에 대한 HTTP 요청 및 응답에 접근할 수 있다. 실제로 Express 자체는 미들웨어 함수들이라고 말할 수 있다.

## Middleware 업무 4가지

> - Execute any code.  
- Make changes to the request and the response objects.
- End the request-response cycle.
- Call the next middleware function in the stack.
> 

- 어떤 코드든지 실행 가능하다.
- request나 response객체를 변경할 수 있다.
- request-response cycle을 끝낼 수 있다.
- 스택에 있는 다음 Middleware를 호출할 수 있다.

## Middleware 유형 5가지

- **Application level**
    - app으로 시작되는 모든 것(app.use(), app.set(), app.get() ... etc)
    - use, method(get, post, put, patch, delete 등) 메서드로 미들웨어를 등록할 수 있다.
    
    ```jsx
    const express = require('express');
    const app = express();
    
    app.get('/', (req, res, next) => {
      res.send('Welcome Home');
    });
    
    app.listen(3000);
    ```
    
    ```jsx
    const express = require('express');
    const app = express();
    
    app.use((req, res, next) => {
      console.log(req);
      next();
    });
    
    app.get('/', (req, res, next) => {
      res.send('Welcome Home');
    });
    
    app.listen(3000);
    ```
    
- **Router level**
    - router로 시작되는 모든것(router.get(), router.post() ... etc)
    - Router()의 인스턴스에 바인딩 된다는 점을 제외하면 어플리케이션 수준 미들웨어와 동일하게 동작한다.
    
- **Error handling**
    - 오류 처리 미들웨어는 항상 4개의 인수를 가져야한다. (err, req, res, next)
    - 하나라도 생략되면 '일반 미들웨어'로 인식해버리므로 꼭 4개를 넣어주어야 한다.
    
    ```jsx
    app.get('/my-other-thing', (req, res, next) => {
      next(new Error('I am passing you an error!'));
    });
    
    app.use((err, req, res, next) => {
      console.log(err);    
      if(!res.headersSent){
        res.status(500).send(err.message);
      }
    });
    ```
    
- **Built-in**
    - Express가 내장한 미들웨어들을 의미한다.
    - Express팀이 만든 미들웨어
    
    ```jsx
    var express = require('express')
    var app = express()
    
    // load built-in middleware(express팀에서 만든 미들웨어)
    app.use(express.urlencoded({ extended: false }));
    app.use(express.json());
    ```
    
- **Third-party Middleware**
    - 누군가에 의해 만들어진 미들웨어
    - Express팀이 아닌 제 3자가 만든 미들웨어
    
    ```jsx
    var express = require('express')
    var app = express()
    var cookieParser = require('cookie-parser')
    
    // load the cookie-parsing middleware(express팀에서가 아닌 제 3자가 만든 미들웨어)
    app.use(cookieParser())
    ```
    

## Reference

- [What is Express Middleware?](https://developer.okta.com/blog/2018/09/13/build-and-understand-express-middleware-through-examples)
