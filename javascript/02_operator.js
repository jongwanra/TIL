function print(data) {
    return console.log(data);
}

// 1. String concatenation(연쇄)

console.log('my' + 'cat');
console.log('1' + 2);
console.log(`string literals: 1 + 2

'''
= ${1 + 2}`);

// 2. Numeric operators
print(1 + 1); // add
print(1 - 1); // substract
print(1 / 1); // devide
print(1 * 1); // multiply
print(5 % 2); // remainder
print(2 ** 3); // exponentiation


// 3. Increment and decrement operators
let counter = 2;
const preIncrement = ++counter;
print(preIncrement);
const postIncrement = counter++;
print(postIncrement);

// 4. Assignment operators
let x = 3;
let y = 6;
x += y;
x -= y;
x *= y;
x /= y;

// 5. Comparison operators
print(10 < 6);
print(10 <= 6);
print(10 > 6);
print(10 >= 6);

// 6. Logical operators: || (or), &&(and), !(not)
const value1 = false;
const value2 = 4 < 2;

// ||(or), finds the first truthy value
// 정말 중요! 앞에 value1이 True면 더이상 확인하지 않고 멈춘다. 함수 같은 heavy 한 것은 뒤에 둔다.
console.log(`or: ${(value1 || value2 || check())}`);

// &&(and), finds the first false value
console.log(`and: ${(value1 && value2 && check())}`);

// often used to compress long if-statement
// nullableObject && nullableObject.something

// ! (not)
print(!value1);

function check() {
    for (let i = 0; i < 10; i++) {
        // wasting time
        console.log('😀');
    }
    return true;
}

// 7. Equality
const stringFive = '5';
const numberFive = 5;
print("----------------------");
// == loose equality, with type conversion
print(stringFive == numberFive);
print(stringFive != numberFive);

// === strict equality, no type conversion
print(stringFive === numberFive);
print(stringFive !== numberFive);

print("----------------------");

// object equality by reference (important!)
const ellie1 = { name: 'ellie' };
const ellie2 = { name: 'ellie' };
const ellie3 = ellie1;

print(ellie1 == ellie2); // false
print(ellie1 === ellie2); // false
print(ellie1 === ellie3); // true
print("----------------------");
// equality - puzzler
print(0 == false); // true
print(0 === false); // false
print('' == false); // true
print('' === false); // false
print(null == undefined); // true
print(null === undefined); // false


// 8. Conditional operator: if
// if, else if, else

const name = 'ellie';
if (name === 'ellie') {
    print('Welcome, Ellie! ');
} else if (name === 'coder') {
    print('You are amazing coder');
} else {
    print('unknown');
}

// 9. Ternary operator: ?
// condition ? value1 : value2;
// when this code is simple! 
print(name === 'ellie' ? 'yes' : 'no');


// 10. Switch statement
// use for multiple if checks
// use for enum-like value check
// use for multiple type checks in TS

const browser = 'Firefox';
switch (browser) {
    case 'IE':
        print('go away!');
        break;
    case 'Chrome':
    case 'Firefox':
        print('love you!');
        break;
    default:
        print('same all!');
        break;
}

// 11. Loops
// while loop, while the condition is truthy,
// body code is executed
let i = 3;
while (i > 0) {
    print(`while: ${i}`);
    i--;
}
print(`i -> ${i}`);
// do while loop, body code is executed first,
// then check the condition.

do {
    print(`do while: ${i}`);
    i--;
} while (i > 0);

// for loop, for(begin; conditionl step)

for (i = 3; i > 0; i--) {
    print(`for: ${i}`);
}

for (let i = 3; i > 0; i = i - 2) {
    //inline variable declaration
    print(`inline variable for: ${i}`);
}

// nested loops
for (let i = 0; i < 10; i++) {
    for (let j = 0; j < 10; j++) {
        print(`i: ${i}, j: ${j}`);
    }
}

// break, continue
// Q1. iterate from 0 to 10 and print only even numbers (use continue)
for (let i = 0; i <= 10; i++) {
    if (i % 2 == 0) {
        console.log(`i: ${i}`);
    } else {
        continue;
    }
}

// Q2. iterate from 0 to 10 and print numbers until reaching 8 (use break)
for (let i = 0; i <= 10; i++) {
    if (i > 8) {
        break;
    }
    print(`i: ${i}`);
}