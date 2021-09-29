# Promise

## QUIZ

- 코드의 출력 순서를 적어보자

```jsx
const condition = true;
const promise = new Promise((resolve, reject) => {
  if (condition) {
    console.log('1');
    resolve('성공');
    console.log('설마?');
  } else {
    console.log('응?');
    reject('실패');
    console.log('설마?');
  }
});
console.log(promise);
console.log('2');
promise
  .then((message) => {
    console.log(message);
  })
  .catch((err) => {
    console.log('error : ', err);
  });

console.log('3');
```

나 역시도 처음에 이 코드를 접했을 때, 오답이었다..

실행순서는,

```jsx
1
설마?
Promise { '성공' }
2
3
성공
```

위의 코드를 통해 다음과 같은 Promise의 특징을 접할 수 있다.

1. new Promise가 생성되는 순간 안에 내부는 동기적으로 실행된다.

```jsx
const promise = new Promise((resolve, reject) => {
	// new Promise가 생성되는 순간 안에 내부는 동기적으로 실행된다.
})
```

출력이 1 → 설마? 순으로 출력되는 것을 통해 알 수 있다.

1. then(), catch()는 비동기적으로 작동한다.

```jsx
console.log('2');
promise
  .then((message) => {
    console.log(message);
  })
  .catch((err) => {
    console.log('error : ', err);
  });

console.log('3');

// 출력이 2가 찍히고 3이 찍힌다음에 '성공'이라는 메세지가 담긴다. 
// 이것을 통해 then(), catch()는 비동기적으로 작동한다는 것을 알 수 있다.
```

1. Promise는 성공했을 경우, 실패했을 경우가 나눠서 동작한다.  변수 condition을 false를 바꿔보면 알 수 있다.

```jsx
응?
설마?
Promise { <rejected> '실패' }
2
3
error :  실패
```

 이 코드를 통해  성공했을 경우, resolve()를 통해 해당 인자가 then()으로 들어가지고, 실패 했을 경우, reject()를 통해 해당 인자가 catch()안으로 들어가진다는 사실을 알 수 있다.

## 정의

node.js 교과서의 저자 조현영이 내린 정의는 다음과 같다. 

> 내용이 실행은 되었지만 결과는 아직 반환하지 않은 객체(ref, zerocho)
> 

그렇다면 결과는 어떻게 받아? 

- resolve(result)  → then(result)
- reject(result) → catch(result)

를 붙여서 결과를 받을 수 있다.