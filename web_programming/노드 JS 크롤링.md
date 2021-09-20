# 노드 JS  크롤링

1. $npm install axios cheerio iconv-lite

    → 필요한 패키지 다운

1. 크롤링 기본 골격

```jsx
const express = require("express");

const cheerio = require("cheerio");
const axios = require("axios");
const iconv = require("iconv-lite");
const url =
  "http://www.yes24.com/24/Category/BestSeller";

const router = express.Router();

router.get("/goods/add/crawling", async (req, res) => {

  try {
    await axios({
      url: url,
      method: "GET",
      responseType: "arraybuffer",
    }).then(async (html) => {

    });
    res.send({ result: "success", message: "크롤링이 완료 되었습니다." });
    
  } catch (error) {
    console.log(error)
    res.send({ result: "fail", message: "크롤링에 문제가 발생했습니다", error:error });
  }
  
});
```

axios 라이브러리

[axios](https://www.npmjs.com/package/axios)

1. 한글 깨짐 방지 코드 넣기

```jsx
const content = iconv.decode(html.data, "EUC-KR").toString();
```

1. example code

```jsx
const express = require('express');
const cheerio = require('cheerio');
const axios = require('axios');
const iconv = require('iconv-lite');
const url = 'http://www.yes24.com/24/Category/BestSeller';

router.get('/goods/add/crawling', async (req, res) => {
  try {
    //크롤링 대상 웹사이트 HTML 가져오기
    await axios({
      url: url,
      method: 'GET',
      responseType: 'arraybuffer',
    }).then(async (html) => {
      //크롤링 코드
      const content = iconv.decode(html.data, 'EUC-KR').toString();
      const $ = cheerio.load(content);
      const list = $('ol li');

      await list.each(async (i, tag) => {
        let desc = $(tag).find('p.copy a').text();
        let image = $(tag).find('p.image a img').attr('src');
        let title = $(tag).find('p.image a img').attr('alt');
        let price = $(tag).find('p.price strong').text();

        if (desc && image && title && price) {
          price = price.slice(0, -1).replace(/(,)/g, '');
          let date = new Date();
          let goodsId = date.getTime();
          await Goods.create({
            goodsId: goodsId,
            name: title,
            thumbnailUrl: image,
            category: '도서',
            price: price,
          });
        }
      });
    });
    res.send({ result: 'success', message: '크롤링이 완료 되었습니다.' });
  } catch (error) {
    //실패 할 경우 코드
    res.send({
      result: 'fail',
      message: '크롤링에 문제가 발생했습니다',
      error: error,
    });
  }
});

router.get('/cart', async (req, res) => {
  const cart = await Cart.find({});
  const goodsId = cart.map((cart) => cart.goodsId);

  goodsInCart = await Goods.find().where('goodsId').in(goodsId);

  concatCart = cart.map((c) => {
    for (let i = 0; i < goodsInCart.length; i++) {
      if (goodsInCart[i].goodsId == c.goodsId) {
        return { quantity: c.quantity, goods: goodsInCart[i] };
      }
    }
  });

  res.json({
    cart: concatCart,
  });
});
```