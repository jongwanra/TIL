# Async/await

## QUIZ

```jsx
function getResult() {
  return new Promise((resolve, reject) => {
    console.log('설마?');
    const condition = true;
    if (condition) {
      resolve('결과값: true');
    } else {
      reject('결과값: false');
    }
      console.log('가즈아!');
    }
  });
}

console.log('1');
async function main() {
  console.log('3');
  const result = await getResult();
  console.log(result);
  console.log('4');
}
console.log('2');
main();
console.log('7');
```

위 내용의 출력이 어떻게 될지 생각해보자.

```jsx
1
2
3
설마?
가즈아!
7
결과값: true
4
```

1 → 2가 출력 되는 것은 이해가될 것이라고 생각한다. **중요한 부분은 main 함수가 호출되었을 때 부터이다.**

원래 함수의 흐름대로 3이 출력 되고 나서 getResult()를 호출한다.  여기서,

```jsx
const result = await getResult(); 
```

해당 코드를 오른쪽 부터 getResult() → Promise 객체를 반환하고 await은 then()으로 여기자. result는 resolve()의 인자가 될 것이다.  결국 이 말 뜻은 getResult는 Promise객체를 반환하기 때문에 동기적으로 실행된다. 그리고 await 으로 왼쪽부터는 then()으로 취급하기 때문에 비동기적으로 접근해야 한다. 따라서 해당 밑에 부분은 task queue에 쌓이고 main()에서 나와서 7이 출력 되는 것을 알 수있다. 7이 출력되고 나서 코드를 전부 읽고 나서 부터 결과값: true → 4가 순서적으로 출력된다.

결국 async/await은 promise를 변형한 것이다. 따라서 위에 해석하는 방법으로 따라서 의미를 이해하면 좋겠다.