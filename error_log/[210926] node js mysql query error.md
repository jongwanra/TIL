# [210926] node.js mysql.query error

## Occured Error

```jsx
const sql = 'select * from car_info order by ? ? limit 5';
```

해당 쿼리문 '?' 에 값을 넣어주면 계속 에러가 발생.

## Solution

[Make MySQL's ORDER BY dynamic in node.js](https://stackoverflow.com/questions/39625688/make-mysqls-order-by-dynamic-in-node-js)

위의 글을 참조해서 에러의 이유를 확인했다.

```jsx
//This does not work:
SELECT foo FROM bar ORDER BY 'baz';

//This dose work:
ELECT foo FROM bar ORDER BY baz;
```

내가 ?에 값을 넣어줄 때 문자열을 넣어주면 '' 인용문구가 같이 들어가기 때문.

```jsx
const sql = `SELECT * FROM car_info ORDER BY ${escapeQuotes(
        connection,
        sortType
      )} ${escapeQuotes(connection, orderType)} LIMIT ${pageNum}`;

const escapeQuotes = (connection, data) => {
  return connection.escape(data).match(/^'(\w+)'$/)[1];
};
```

 

escapeQuotes() 함수를 이용해서  '' 인용문구를 제거 후 정상 동작을 확인.