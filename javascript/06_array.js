'use strict';

// Array

// 1. Declaration
const arr1 = new Array();
const arr2 = [1, 2];

// 2. Index position
const fruits = ['🔥', '😀'];
console.log(fruits);
console.log(fruits.length);
console.log(fruits[2]); // undefined

console.clear();
// 3. Looping over an array
// print all fruits
// a. for
for(let i = 0; i < fruits.length; i++){
    console.log(fruits[i]);
}

// b. for of
for (let fruit of fruits){
    console.log(fruit);
}

// c. forEach
fruits.forEach((fruit, index) => console.log(fruit, index));

// 4. Addition, deletion, copy
// push: add an item to the end
fruits.push('banana', 'grape');
console.log(fruits);

// pop: remove an item from the end
fruits.pop();
fruits.pop();
console.log(fruits);

// 내일 여기서 부터 듣자!! 18:00
// unshift: add an item to the begining


fruits.unshift(fruits);
console.log(fruits);

console.clear();
// shift: remove an item from the begining
fruits.shift();
fruits.shift();
console.log(fruits);

// note!! shift, unshift are slower than pop, push
// できれば、　popとpushを　使う方がいい。
// splice: remove an item by index position
fruits.push('stawberry', 'peach', 'lemon');
console.log(fruits);
fruits.splice(1,1, 'apple', 'watermelon'); // 지정한 index 부터 ~ 까지 지움
console.log(fruits);

// combine two arrays
const fruits2 = ['carrot', 'pear']
const newFruits = fruits.concat(fruits2);
console.log(newFruits);

// 5. Searching
// indexOf: find the index

console.clear();
console.log(fruits);
console.log(fruits.indexOf('apple'));
console.log(fruits.indexOf('watermelon'));

// includes
console.log(fruits.includes('apple')); // return true or false 

// lastIndexOf
console.clear();
fruits.push('apple');
console.log(fruits);
console.log(fruits.lastIndexOf('apple'));
console.log(fruits);

// Example
console.log(fruits.toString());
console.log(fruits.toLocaleString());











