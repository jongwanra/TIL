# (solved) Post Request Error_Node

## Occured Error

![Untitled]((solved)%20Post%20Request%20Error_Node%20d519899543df40ac855a26a563fb5b0a/Untitled.png)

상품을 추가하는 것을 Json형식으로 볼 수 있도록 Insomnia 를 설치했고 Post method, json 형식으로 정확히 데이터를 보냈지만, 에러가 발생했다.

## Solution

```jsx
app.use(express.urlencoded({ extended: false }));
app.use(express.json());
app.use(express.static('public'));

const goodsRouter = require('./routers/goods');
app.use('/api', [goodsRouter]);

app.use((req, res, next) => {
  //   console.log(req);
  next();
});
```

app.use(express.json()); 이 부분에서 문제가 생겼다

app.use(express.json()); 이게 먼저 선언 되어야 하고, 그 이후에 

const goodsRouter = require('./routers/goods');
app.use('/api', [goodsRouter]);
해당 부분을 처리해야 에러없이 Post 메소드를 처리할 수 있다.