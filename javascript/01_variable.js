// 1. Use strict
// added in ES5
// use this for Vanila Javascript.
'use strict';

// 2. Variable, rw(read/write)
// let (added in ES6)
// block scope vs global scope
let globalName = 'global name';

{
    let name = 'ellie';
    console.log(name);
    name = 'hello';
    console.log(name);
}
// console.log(name);
console.log(globalName);

// var(don't ever use this!)
// var hoisting (move declaration from bottom to top)
// has no block scope(block을 철저히 무시함)

// {
//     age = 4;
//     var age;
// }
console.log(age);
age = 4;
console.log(age);
var age;

// name = 4;
// let name;

// 3. constants r(read only)
// favor immutable data type always for a few reasons:
//  - security
//  - thread safety -> 동시에 값을 변경한다는 것은 위험하다.
//  - reduce human mistakes

const daysInWeek = 7;
const maxNumber = 5;

// Note!
// Immutable data types: primitive types, frozen objects(i.e. object.freeze())
// Mutable data types: all objects by default are mutable in JS

// 4. Variale types
// primitive, single item: number, string, boolean, null, undefined, symbol -> 값 자체가 메모리에 저장!!
// object, box container -> 객체가 가리키는 곳에는 주소가 담겨져 있고 그 주소가 가리키는 곳에서 변경 가능!!
// function, first-class function -> function도 다른 데이터 타입처럼 변수에 할당이 가능, 함수의 인자로도 전달 가능, 반환도 가능

const count = 17; // integer
const size = 17.1; // decimal(소수) number
console.log(`value: ${count}, type: ${typeof count}`);
console.log(`value: ${size}, type: ${typeof size}`);


// number - special numeric values: infinity, -infinity, NaN
const infinity = 1 / 0;
const negativeInfinity = -1 / 0;
const nAn = 'not a number' / 2;

console.log(infinity);
console.log(negativeInfinity);
console.log(nAn);

// bigInt (fairly new, don't use it yet)
const bigInt = 123456789012345678901234567890n;
console.log(`value: ${bigInt}, type: ${typeof bigInt}`);

// string
const char = 'c';
const brendan = 'brendan';
const greeting = 'hello' + brendan;
console.log(`value: ${greeting}, type: ${typeof greeting}`);
const helloBob = `hi ${brendan}!`; //template literals (string)
console.log(`value: ${helloBob}, type: ${typeof helloBob}`);
console.log('value: ' + helloBob + ' tyle: ' + typeof helloBob);

// boolean
// false: 0, null, undefined, NaN, ''
// true: any other value

const canRead = true;
const test = 3 < 1;
console.log(`valiue: ${canRead}, tyle: ${typeof canRead}`);
console.log(`valiue: ${test}, tyle: ${typeof test}`);


// null
let nothing = null;
console.log(`valiue: ${nothing}, tyle: ${typeof nothing}`);

// undefined(선언은 했지만, 아무것도 값이 들어가 있지 않은 경우)
let x;
console.log(`valiue: ${x}, tyle: ${typeof x}`);

// symbol, create unique identifiers for objects
const symbol1 = Symbol('id');
const symbol2 = Symbol('id');
console.log(symbol1 === symbol2); // false

const gSymbol1 = Symbol.for('id');
const gSymbol2 = Symbol.for('id');
console.log(gSymbol1 === gSymbol2); // true
console.log(`value: ${symbol1.description}, type: ${typeof symbol1}`)

// object, real-life object, data structure
const ellie = { name: 'ellie', age: 20 };
ellie.age = 21;

// 5. Dynamic typing: dynamically typed language <-> Static typing
let text = 'hello';
console.log(text.charAt(0)); // h
console.log(`value: ${text}, type: ${typeof text}`);
text = 1;
console.log(`value: ${text}, type: ${typeof text}`);
text = '7' + 5;
console.log(`value: ${text}, type: ${typeof text}`);
text = '8' / '2';
console.log(`value: ${text}, type: ${typeof text}`);

//console.log(text.charAt(0)); -> dynamic typing의 문제점.
