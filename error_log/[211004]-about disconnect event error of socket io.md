# [211004]-about disconnect event error of socket.io

## Occured Error

항해99, nodejs 심화 4주차 과제 중, 같은 목록에 상세페이지를 보고 있는 접속자 수를 실시간으로 보여주는 기능 구현에서 해결을 못하고 있다.

7시간 정도 이유를 찾다가 알게된 부분은  상세페이지에서  다른 페이지로 이동할 때, 'disconnect' 이벤트가 발생하지 않는다. 

혹시나 해서, 튜터님의 코드를 복사 붙혀넣기를 통해 돌려봤는데, 잘 된다. 그러면 내 코드가 문제인데 어디서 막힌거지? 

### 튜터님 코드를 통해서 상세페이지에 들어갔다가 나왔을 경우

```jsx
/*
페이지가 바뀌었대요 /detail.html?goodsId=4 q_C15xgqT9MX9UdKAAAF
{ null: 1, '/detail.html?goodsId=4': 1 }
누군가 연결을 끊었어요!
{ '/detail.html?goodsId=4': 1 }
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
누군가 연결했어요!
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
페이지가 바뀌었대요 /detail.html?goodsId=4 On53T2oh2yIxBk8qAAAH
{ '/detail.html?goodsId=4': 2 }
Executing (default): SELECT `goodsId`, `name`, `thumbnailUrl`, `category`, `price`, `createdAt`, `updatedAt` FROM `Goods` AS `Goods` WHERE `Goods`.`goodsId` = '4';
누군가 연결을 끊었어요!
*/
```

튜터님 코드는 상세페이지로 들어갔다가 나왔을 경우,  "disconnect" 이벤트가 잘 발생 되는 것을 알 수 있다.

### 내가 작성한 코드를 통해서 상세페이지에 들어갔다가 나왔을 경우

```jsx
/*
상세페이지 입장: /detail.html?goodsId=5 UhE-K-xJmaUPyRTJAAAH
{ null: 2, '/detail.html?goodsId=5': 2 }
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
새로운 소켓이 연결됐어요!
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
Executing (default): SELECT `goodsId`, `name`, `thumbnailUrl`, `category`, `price`, `createdAt`, `updatedAt` FROM `Goods` AS `Goods` WHERE `Goods`.`goodsId` = '4';
상세페이지 입장: /detail.html?goodsId=4 LeguUevjdPkO0I6zAAAJ
{ null: 2, '/detail.html?goodsId=5': 2, '/detail.html?goodsId=4': 1 }
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
새로운 소켓이 연결됐어요!
Executing (default): SELECT `userId`, `email`, `nickname`, `password`, `createdAt`, `updatedAt` FROM `Users` AS `User` WHERE `User`.`userId` = 1;
상세페이지 입장: /detail.html?goodsId=4 2Xu1Ec2pF5skrR4TAAAL
{ null: 2, '/detail.html?goodsId=5': 2, '/detail.html?goodsId=4': 2 }
Executing (default): SELECT `goodsId`, `name`, `thumbnailUrl`, `category`, `price`, `createdAt`, `updatedAt` FROM `Goods` AS `Goods` WHERE `Goods`.`goodsId` = '4';
3CDoyBIP11lmZHP-AAAB 연결이 끊어졌다!
{ null: 1, '/detail.html?goodsId=5': 2, '/detail.html?goodsId=4': 2 }
6KWCHJ1AMcODkgKxAAAD 연결이 끊어졌다!
{ '/detail.html?goodsId=5': 2, '/detail.html?goodsId=4': 2 }
RuZ52lpkewMSK9NZAAAF 연결이 끊어졌다!
{ '/detail.html?goodsId=5': 1, '/detail.html?goodsId=4': 2 }
*/
```

메인페이지에서 들어갔을 경우,  상세페이지 입장이 되면서 데이터가 객체에 잘 추가가 되는 것을 알 수 있다.

하지만 뒤로가기 버튼을 눌렀을 경우에 disconnect 이벤트가 제대로 작동하지 않다가, 일정 시간 뒤에 연결이 끊어졌다는 메세지가 나온다. 왜 그런 건지 이유를 알 수가 없다.

### 내 코드

- server.js

```jsx
const http = require('./app');
require('./socket');

http.listen(8080, () => {
  console.log('서버가 요청을 받을 준비가 됐어요');
});
```

- socket.js

```jsx
const socketIo = require('socket.io');

const http = require('./app');
const io = socketIo(http);

const socketIdMap = {};
function initSocket(socket) {
  console.log('새로운 소켓이 연결됐어요!');
  socketIdMap[socket.id] = null;
  // 특정 이벤트가 전달됐는지 감지할 때 사용될 함수
  function watchEvent(event, func) {
    socket.on(event, func);
  }

  // 연결된 모든 클라이언트에 데이터를 보낼때 사용될 함수
  function notifyEveryone(event, data) {
    io.emit(event, data);
  }

  function emitSamePageViewerCount() {
    const countByUrl = Object.values(socketIdMap).reduce((value, url) => {
      return {
        ...value,
        [url]: value[url] ? value[url] + 1 : 1,
      };
    }, {});

    console.log(countByUrl);
    for (const [socketId, url] of Object.entries(socketIdMap)) {
      const count = countByUrl[url];
      io.to(socketId).emit('SAME_PAGE_VIEWER_COUNT', count);
    }
  }

  return {
    // "disconnect" 이벤트가 발생하는 부분
    watchByebye: () => {
      socket.on('disconnect', () => {
        console.log(socket.id, '연결이 끊어졌다!');
        delete socketIdMap[socket.id];
        emitSamePageViewerCount();
      });
    },
    watchBuying: () => {
      watchEvent('BUY', (data) => {
        const emitData = {
          ...data,
          date: new Date().toISOString(),
        };
        notifyEveryone('BUY_GOODS', emitData);
      });
    },

    watchChangedPage: () => {
      watchEvent('CHANGED_PAGE', (detail_url) => {
        console.log('상세페이지 입장:', detail_url, socket.id);
        socketIdMap[socket.id] = detail_url;
        emitSamePageViewerCount();
      });
    },
  };
}

io.on('connection', (socket) => {
  const { watchBuying, watchByebye, watchChangedPage } = initSocket(socket);
  watchBuying();
  watchByebye();
  watchChangedPage();
});
```

- app.js

```jsx
const Http = require('http');
const express = require('express');
const socketIo = require('socket.io');
const jwt = require('jsonwebtoken');
const { User, Goods, Cart } = require('./models');
const { Op } = require('sequelize');
const SECRET_KEY = 'foiqwfiqniopcnqwc09wqehqwunqw9eu0';
const authMiddleware = require('./middlewares/auth-middleware');
const joi = require('joi');

const app = express();
const http = Http.createServer(app);
const io = socketIo(http);
const router = express.Router();

///////////////////////////////////////////////////////////////////////////////////////////
//                            회원 가입 API
//////////////////////////////////////////////////////////////////////////////////////////

const postUserSchema = joi.object({
  nickname: joi.string().required(),
  email: joi
    .string()
    .email({ minDomainSegments: 2, tlds: { allow: ['com', 'net'] } })
    .required(),
  password: joi.string().required(),
  confirmPassword: joi.string().required(),
});

router.post('/users', async (req, res) => {
  try {
    const { nickname, email, password, confirmPassword } =
      await postUserSchema.validateAsync(req.body);

    // 비밀번호, 비밀번호 확인이 다를 경우
    if (password !== confirmPassword) {
      return res.status(400).send({
        errorMessage: '패스워드가 패스워드 확인란과 동일하지 않습니다.',
      });
    }

    // 중복된 이메일, 닉네임일 경우
    const existUsers = await User.findAll({
      where: {
        [Op.or]: [{ nickname }, { email }],
      },
    });
    if (existUsers.length) {
      return res.status(400).send({
        errorMessage: '이미 가입된 이메일 또는 닉네임이 있습니다.',
      });
    }

    // DB에 회원 정보 추가 및 저장.
    const user = await User.create({ email, nickname, password });

    // Created
    res.status(201).send({});
  } catch (error) {
    console.log('뭐야');
    res
      .status(400)
      .send({ errorMessage: '회원가입 형식이 올바르지 않습니다.' });
    console.log(`errorMessage: ${error}`);
  }
});

///////////////////////////////////////////////////////////////////////////////////////////
//                            로그인 API
//////////////////////////////////////////////////////////////////////////////////////////
router.post('/auth', async (req, res) => {
  const { email, password } = req.body;
  const user = await User.findOne({ where: { email, password } });
  // DB에 해당 유저 정보가 없을 경우
  if (!user) {
    // Bad Request
    return res.status(400).send({
      errorMessage: '이메일 또는 패스워드가 잘못됐습니다.',
    });
  }

  // token 생성
  const token = jwt.sign({ userId: user.userId }, SECRET_KEY);
  res.send({
    token,
  });
});

///////////////////////////////////////////////////////////////////////////////////////////
//                            마이페이지 API
//////////////////////////////////////////////////////////////////////////////////////////

router.get('/users/me', authMiddleware, async (req, res) => {
  const { user } = res.locals;
  res.send({
    user,
  });
});

/**
 * 내가 가진 장바구니 목록을 전부 불러온다.
 */
router.get('/goods/cart', authMiddleware, async (req, res) => {
  const { userId } = res.locals.user;

  const cart = await Cart.find({
    userId,
  }).exec();

  const goodsIds = cart.map((c) => c.goodsId);

  // 루프 줄이기 위해 Mapping 가능한 객체로 만든것
  const goodsKeyById = await Goods.findAll({
    where: {
      goodsId: goodsIds,
    },
  }).then((goods) =>
    goods.reduce(
      (prev, g) => ({
        ...prev,
        [g.goodsId]: g,
      }),
      {}
    )
  );

  res.send({
    cart: cart.map((c) => ({
      quantity: c.quantity,
      goods: goodsKeyById[c.goodsId],
    })),
  });
});

/**
 * 장바구니에 상품 담기.
 * 장바구니에 상품이 이미 담겨있으면 갯수만 수정한다.
 */
router.put('/goods/:goodsId/cart', authMiddleware, async (req, res) => {
  const { userId } = res.locals.user;
  const { goodsId } = req.params;
  const { quantity } = req.body;

  const existsCart = await Cart.findOne({
    where: {
      userId,
      goodsId,
    },
  });

  if (existsCart) {
    existsCart.quantity = quantity;
    await existsCart.save();
  } else {
    await Cart.create({
      userId,
      goodsId,
      quantity,
    });
  }

  // NOTE: 성공했을때 응답 값을 클라이언트가 사용하지 않는다.
  res.send({});
});

/**
 * 장바구니 항목 삭제
 */
router.delete('/goods/:goodsId/cart', authMiddleware, async (req, res) => {
  const { userId } = res.locals.user;
  const { goodsId } = req.params;

  const existsCart = await Cart.findOne({
    where: {
      userId,
      goodsId,
    },
  });

  // 있든 말든 신경 안쓴다. 그냥 있으면 지운다.
  if (existsCart) {
    existsCart.delete();
  }

  // NOTE: 성공했을때 딱히 정해진 응답 값이 없다.
  res.send({});
});

/**
 * 모든 상품 가져오기
 * 상품도 몇개 없는 우리에겐 페이지네이션은 사치다.
 * @example
 * /api/goods
 * /api/goods?category=drink
 * /api/goods?category=drink2
 */
//
router.get('/goods', authMiddleware, async (req, res) => {
  const { category } = req.query;
  const goods = await Goods.findAll({
    order: [['goodsId', 'DESC']],
    where: category ? { category } : undefined,
  });

  res.send({ goods });
});

/**
 * 상품 하나만 가져오기
 */
router.get('/goods/:goodsId', authMiddleware, async (req, res) => {
  const { goodsId } = req.params;
  const goods = await Goods.findByPk(goodsId);

  if (!goods) {
    res.status(404).send({});
  } else {
    res.send({ goods });
  }
});

app.use('/api', express.urlencoded({ extended: false }), router);
app.use(express.static('assets'));

module.exports = http;
```

## 멘토님께 받은 조언 이후,

1. app.js 파일 내부에서 goodsId값을 Number()화 시켜주지 않았다.
2. 분리를 안했을 때, 정상적으로 동작하던 기능이 파일들로 따로 나누면서 같은 문제가 생겼다.(server.js 로 따로 분리하면서 바로 발생) 

일단, 다른 과제 진행 이후 이 문제에 대해서 다시 한번 파일들을 기능별로 모듈화를 진행해봐야겠다.

## Solution