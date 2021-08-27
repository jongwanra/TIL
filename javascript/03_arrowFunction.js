"use strict";
// Function
// - fundamental building block in the program
// - subprogram can be used multiple times (여러 번 재사용 가능)
// - performs a task or calculates a value

// 1. Function declaration
// function name(param1, param2){ body ... return;}
// one function === one thing
// naming: doSomething, command, verb (동사 형태로 이름 지정)
// e.g. createCardAndPoint -> createCard, createPoint
// functon is object in JS
function printHello() {
    console.log('Hello');
}
printHello();

function log(message) {
    console.log(message);
}
log('Hello');

// 2. Parameters
// premitive parameters: passed by value
// object parameters: passed by reference
function changeName(obj) {
    obj.name = 'coder';
}
const ellie = { name: 'ellie' };
changeName(ellie);
console.log(ellie);

//3. Default parameters (added in ES6)
function showMessage(message, from = 'unknown') {
    // 인자로 넘어오지 않는 경우, default 값을 넣어줌. 여기에선 'unknown'
    console.log(`${message} by ${from}`);
}
showMessage('Hi!'); //Hi! by undefined


//4. Rest parameters(added in ES6)
// ...args라고 하면 배열형태로 값을 전달 받게 됨. 즉, args는 배열이다.
function printAll(...args) {
    console.log(`type: ${typeof args}`);
    for (let i = 0; i < args.length; i++) {
        console.log(args[i]);
    }

    for (const arg of args) {
        console.log(arg);
    }
}

printAll('dream', 'coding', 'ellie');

// 5. Local scope
let globalMessage = 'global' //global variable
function printMessage() {
    let message = 'hello';
    console.log(message); //local variable
    console.log(globalMessage);
}
printMessage();

// 6. Return a value
function sum(a, b) {
    return a + b;
}
const result = sum(1, 2);
console.log(`sum: ${sum(1, 2)}`);

// 7. Early return, early exit
// bad
function upgradeUser(user) {
    if (user.point > 10) {
        // long upgrade logic..
    }
}

// good
function upgradeUser(user) {
    if (user.point <= 10) {
        return;
    }

    // long upgrade logic...
}

// First-class function
// functions are treated like any other variable
// can be assigned as a value to variable
// can be passed as an argument to other functions
// can be returned by another function

// 1. Function expression
// a function declaration can be called earlier than it is defined. (hoisted)
// a function expression is created when the execution reaches it.

const print = function () { //annoymous function
    console.log('print');
}
print();
const printAgain = print;
printAgain();
const sumAgain = sum;
console.log(sumAgain(1, 3));


// 2. Callback function using function expression
function randomQuiz(answer, printYes, printNo) {
    if (answer === 'love you') {
        printYes();
    } else {
        printNo();
    }
}

// annoymous function
const printYes = function () {
    console.log('yes!');
}

// named function
// better debugging in debugger's stack traces
// 디버깅을 할 때, 함수 이름이 나오게 하기 위해서 사용.
// recursions
const printNo = function print() {
    console.log('No!');
}
randomQuiz('wrong', printYes, printNo);
randomQuiz('love you', printYes, printNo);

// Arrow function
// always annoymous function
const simplePrint = () => console.log('simplePrint!');
const add = (a, b) => a + b;
const simpleMultiply = (a, b) => {
    //do something more
    // Arrow function에서 2줄 이상일 경우, return 키워드 명시 필요
    return a * b;
}

//IIFE = Immediately Invoked Function Expression
(function hello() {
    console.log('IIFE');
})();

// Fun quiz time
// function calculate(command, a, b)
// command: add, substract, divide, multiply, remainder

const cal = function (cmd, a, b) {
    let res = 0;
    switch (cmd) {
        case "add":
            res = a + b;
            break;
        case "substract":
            res = a - b;
            break;
        case "divide":
            res = a / b;
            break;
        case "multiply":
            res = a * b;
            break;
        default:
            res = a % b;
            break;
    }
    return res;
}

console.log(cal("add", 3, 10));