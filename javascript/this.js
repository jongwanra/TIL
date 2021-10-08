// this란?(node.js)

// this가 무엇인지 알고 싶어서 출력해보면, {} 라고 출력된다.
console.log(this);

// 구글링을 통해서 === 연산자를 통해서 알아보면 된다는 것을 알았다.
console.log(this === 'window'); // false
console.log(this === global); // false
console.log(this === module.exports); // true
console.log(this === exports); // true

// node환경에서 실행했을 때, this의 값은 module 객체 안에 exports로 확인이 된다.


// 그렇다면, 함수 안에서는 어떻까?
function checkThisInFunc() {
  console.log(this === exports); // false
  console.log(this === global); // true
}

checkThisInFunc();

// 전역에서 this는 module.exports or exports
// 함수내부에서의 this는 global

console.log('---------------------------------');
// 다음은 객체안의 메소드를 호출해 보자.

const obj = {
  data: function () {
    console.log(this === exports); // false
    console.log(this === global); // false
    console.log(this === obj); // true
  },
};

obj.data();

// 객체안의 메소드를 호출하는 경우에 this는 해당 객체를 가리킨다.
// 하지만 이런 경우는 어떨까?
console.log('---------------------------------');
const referObj = obj.data;
referObj();
// this === global일 경우, true가 반환되고 나머지는 false로 반환된다.
// 호출할 때, 호출하는 함수가 객체의 메서드인지 그냥 함수인지가 중요하다.
// referObj는 더 이상 obj의 메서드가 아니라, obj의 함수값이 된다.
