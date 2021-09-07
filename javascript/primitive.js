// 자바스크립트 안에는 8가지 자료형이 존재한다.
// 0. 자바스크립트 자료형 구분
// - 원시값(primitive) 
// 원시값은 객체가 아니다.
// -> string, number, bigint, boolean, null, undefined, symbol 총 7 가지 
// - 객체(위 7가지를 제외한 나머지는 다 객체이다.)
// 프로퍼티에 다양한 종류의 값을 저장 가능하다.
// {name : "John", age: 30}와 같이 중괄호를 사용해 만들 수 있다. 
// 자바 스크립트에는 여러 종류의 객체가 있는데 함수도 객체의 일종이다.

// 1. 숫자형(Number)
const integer = 3;
const float = 3.3;
const INF = Infinity;
const minus_INF = -Infinity;
const nan = NaN;

console.log(`
Integer: ${typeof integer}, 
Float: ${typeof float}, 
INF: ${typeof INF}, 
minus_INF: ${typeof minus_INF}, 
NaN: ${typeof nan}`); // Nan => Not a Number

// 2. BigInt(bigint)
// BigInt형 값은 정수 리터럴 끝에 n을 붙이면 만들 수 있다.


const bigInt = 1n;
console.log(`bigInt: ${typeof bigInt}`);

// 3. 문자형(string)
// 문자형은 한 글자여도 JavaScript에서는 type이 string이다.

const str = "Hello";
const char = "c";
console.log(`string : ${typeof str}, char: ${typeof char}`);

// 4. 불린형(boolean)
const trueBoolean = true;
const falseBoolean = false;
console.log(`true: ${typeof trueBoolean}, false: ${typeof falseBoolean}`);

// 5. null(object) -> null은 객체가 아니지만 하위 호환성을 유지하기 위해 오류를 수정하지 않고 남겨둔 상황이다.
// 존재하지 않는 값, 비어 있는 값, 알 수 없는 값을 나타내는 데 사용.
const nullType = null;
console.log(`nullType: ${typeof nullType}`);

// 6. undefined(undefined)
// 값이 할당되지 않은 상태를 나타냄.
// 변수 선언만 한 경우, undefined이 나타남.
// undefined를 직접 할당하는 것은 권장x, 비어있거나 알 수 없는 상태일 경우 null을 사용하자.
const undefinedType = undefined;
console.log(`undefined: ${undefinedType}`);


// 7. Symbol(symbol)
// 객체의 고유 식별자를 만들 때 사용한다.
const symbol = Symbol("id");
console.log(`symbol: ${typeof symbol}`);
