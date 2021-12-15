# Closure(클로저)

## 클로저란?

- 클로저는 함수와 그 함수가 선언된 렉시컬 환경과의 조합이다 - MDN
- 외부 함수보다 중첩 함수가 더 오래 유지되는 경우 중첩 함수는 이미 생명 주기가 종료한 외부 함수의 변수를 참조할 수 있다. 이러한 **중첩 함수**를 클로저라고 부른다. - 딥다이브
- 어떤 함수 A에서 선언한 변수 a를 참조하는 내부함수 B를 외부로 전달할 경우 A의 실행 컨텍스트가 종료된 이후에도 변수 a가 사라지지 않는 현상을 말한다. - 코어 자바스크립트

```js
function foo() {
  const x = 1;
  const y = 2;

  function bar() {
    debugger;
    console.log(x);
  }
  return bar;
}
const bar = foo();
bar();
```

## 클로저를 사용하는 이유

- **클로저는 상태를 안전하게 변경하고 유지하기 위해 사용한다.** 다시 말해, 상태가 의도치 않게 변경되지 않도록 상태를 안전하게 은닉하고 특정 함수에게만 상태 변경을 허용하기 위해 사용한다.

- 오류를 발생시킬 가능성을 가진 좋지 않은 코드

```js
let num = 0;

const increase = function () {
  return ++num;
};

console.log(increase()); // 1
console.log(increase()); // 2
console.log(increase()); // 3
```

카운트 상태는 전역 변수를 통해 관리되고 있기 때문에 언제든 누구나 접근 및 변경 할 수 있다(암묵적 결합). 이는 의도치 않게 상태가 변경될 수 있다는 것을 의미한다. 따라서 안전하게 변경 및 유지 하기 위해서는 increase 함수만이 num을 참조하고 변경할 수 있게 하는 것이 바람직 하다. 이를 위해서 지역 변수로 num을 옮겨도 다시 선언되고 0으로 초기화되기 때문에 출력 결과는 언제나 1이 된다. 즉, 이전 상태를 유지하지 못한다. 이전 상태를 유지할 수 있도록 클로저를 사용해 보자.

```js
const increase = (function () {
  let num = 0;
  return function closure() {
    return ++num;
  };
})();

console.log(increase); // [Function: closure]
console.log(increase()); // 1
console.log(increase()); // 2
console.log(increase()); // 3
```

## Reference

- 코어 자바스크립트(정재남 지음)
- 모던 자바스크립트 Deep Dive(이웅모 지음)
