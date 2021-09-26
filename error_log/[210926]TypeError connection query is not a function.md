# [210926]TypeError: connection.query is not a function

## Occured Error

> TypeError: connection.query is not a function

해당 에러가 발생했다. 

node.js 환경에서 mysql에 접속할때 발생한 에러.

```jsx
const express = require('express');
const app = express();
const mysql = require('mysql2');
const carInfo = require('./models/carInfo');
require('dotenv').config();
const port = process.env.PORT || 5005;

//클라이언트 정보 기입
module.exports = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DATABASE,
});

// body parser를 위해서 꼭 넣어줘야 하는 부분.
app.use(express.urlencoded({ extended: false }));
app.use(express.json());

const usersRouter = require('./routes/user');
app.use('/api/user', [usersRouter]);

const carRouter = require('./routes/car');
app.use('/api/car', [carRouter]);

app.set('views', __dirname + '/views');
app.set('view engine', 'ejs');

// 홈으로 이동
app.get('/', (req, res) => res.send('Hello Firstcar Server'));

// 회원가입 뷰로 이동
app.get('/register', (req, res) => res.render('register'));

// 로그인 뷰로 이동
app.get('/login', (req, res) => res.render('login'));

// 차량 리스트 뷰로 이동
app.get('/car/list', async (req, res) => {
  // default 출시순 order by desc
});

app.listen(port, () => {
  console.log(`Server Listening on ${port}`);
});
```

```jsx
//carInfo.js
const connection = require('../app');

console.log('carInfo: ', connection.query);
//let url = '/api/car-list?page=1&order='+type;

const getCarList = (pageNum, sortType, orderType) => {
  return new Promise((resolve, reject) => {
    // parameter값으로 아무것도 들어오지 않은 경우, default 값으로 준다.
    try {
      pageNum = typeof pageNum != 'undefined' ? pageNum : 1;
      sortType = typeof sortType != 'undefined' ? sortType : 'car_release_date';
      orderType = typeof orderType != 'undefined' ? orderType : 'DESC';

      console.log(pageNum, sortType, orderType);

      let payload = { success: false, Msg: '안잡히는 중..', carList: [] };
      const params = [sortType, orderType];
      const sql = 'SELECT * FROM car_info ORDER BY ? ?';

      connection.query(sql, params, (error, rows, fields) => {
        console.log('---------------------');
        if (error) {
          console.log(`Msg: rase Error in getCarList => ${error}`);
          payload = { success: false, Msg: `SQL문 에러`, carList: [] };
          reject(payload);
        } else if (rows.length == 0) {
          payload = {
            success: false,
            Msg: 'query문에서 가져온 데이터가 없습니다.',
            carList: [],
          };
          reject(payload);
        } else {
          payload = {
            success: true,
            Msg: '데이터를 가져오는데 성공하였습니다.',
            carList: rows,
          };
          resolve(payload);
        }

        reject(payload);
      });
    } catch (error) {
      console.log(error);
    }
  });
};

module.exports = {
  getCarList,
};
```

이미 로그인, 회원가입 기능을 구현하면서, mysql 접속에 문제가 없다는 것을 알고 있었다.

똑같이 비교하면서 만들었는데  왜 해당 Error가???

## Solved

app.js에서 

```jsx
const carInfo = require('./models/carInfo');
```

해당 부분을 제거해 주니 해결 가능했다.

## 왜 지우니까 해결 됐지?

왜 그런지 생각해보니, 코드가 읽히는 순서가 위에서 아래이다.

그런데 carInfo 같은 경우 아직 밑에 존재하는

```jsx
module.exports = mysql.createPool({
  host: process.env.DB_HOST,
  user: process.env.DB_USER,
  password: process.env.DB_PASSWORD,
  database: process.env.DATABASE,
});
```

mysql 연결 정보부분을 만나지 않은 상태에서 요청을 했기 때문에 발생한 에러.

따라서, 해당 내용을 지웠더니 정상적으로 작동한다.