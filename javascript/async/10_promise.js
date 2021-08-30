'use strict';

// Promise is a JavaScript object for asynchronous operation
// State: pending -> fulfilled or rejected
// Producer vs Consumer 

// 1. Producer
// when new Promise is created, the executor runs automatically.
const promise = new Promise((resolve, reject) => {
    // dofing some heavy work(network, read files)
    console.log('doing something...');
    setTimeout(()=> {
        //resolve('ellie');
        reject(new Error('no network'));
    }, 2000);
});

// 2. Consumers: then, catch, finally
// then: promise가 정상적으로 수행되면, resolve 함수로 들어오는 결과가 value 로 들어간다.
promise.then((value) => {
    console.log(value);
})
.catch(error => {
    console.log(error);
})
.finally(()=>{
    console.log('finally');
});

// 3. Promise chaning
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => resolve(1), 1000);
});

fetchNumber
.then(num => num * 2)
.then(num => num * 3)
.then(num => {
    return new Promise((resolve, reject) => {
        setTimeout(() => resolve(num - 1), 1000);
    });
})
.then(num => console.log(num));

console.clear();
// 4. Error Handling
const getHen = () =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve('🐓'), 1000);
    });

const getEgg = hen =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${hen} => 🥚`), 1000);
    });

const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} => 🍳`), 1000);
    });

getHen()
.then(hen => getEgg(hen))
.then(egg => cook(egg))
.then(meal => console.log(meal));
