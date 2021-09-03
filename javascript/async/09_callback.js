'use strict';

// Callback 함수란 도대체 무엇인가?
// A callback function is a function which is:
// - passed as an argument to another function, and, (다른 함수의 인자로서 이용되는 함수)
// - is invoked after some kind of event (어떤 이벤트에 의해 호출되어지는 함수)

// JavaScript is synchronous. (자바스크립트는 동기적으로 순서대로 실행된다.)
// Execute the code block in order after hoisting.
// hoisting: var, function declaration 자동적으로 선언들이 제일 위로 올라가는 것

// 비동기: 언제 코드가 실행될지 예측할 수 없는 것
console.log('1');
// 브라우저 api는 무조건 브라우저에게 요청을 보내게 됨. (전달해준 함수를 나중에 불러줘 라는 개념: callback)
setTimeout(()=> console.log('2'), 1000);
for (let i = 0; i < 1000; i++){
    console.log(i);
}

//콜백은 두 가지로 나뉜다.
// Synchronous callback (즉각, 동기적으로 실행하는)
function printImmediately(print) {
    print();
}

printImmediately(() => console.log('hello'));

// Asynchronous callback(언제 실행될지 예측할 수 없는)
function printWithDelay(print, timeout){
    setTimeout(print, timeout);
}
printWithDelay(() => console.log('async callback'), 2000);

// Callback Hell example
class UserStorage {
    loginUser(id, password, onSuccess, onError){
        setTimeout(()=> {
            if(
                (id === 'ellie' && password === 'dream') ||
                (id === 'coder' && password === 'academy')
            ) {
                onSuccess(id);
            }else{
                onError(new Error('not found'));
            }
        }, 2000);
    }

    getRoles(user, onSuccess, onError){
        setTimeout(() => {
            if(user === 'ellie'){
                onSuccess({name: 'ellie', role: 'admin'});
            }else {
                onError(new Error('no access'));
            }
        }, 1000);
    }
}

// 가독성이 너무 떨어짐(한 눈에 이해하기 너무 어려움)
// 에러 혹은 디버깅 할 때, 굉장히 어려움.(길어질수록)
// 유지 및 보수도 어렵다.

const userStorage = new UserStorage();
const id = prompt('enter your id');
const password = prompt('enter your password');
userStorage.loginUser(
    id,
    password,
    user => {userStorage.getRoles(user, userWithRole => { 
        alert(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
    },
    error => console.log(error)
    );    
},
error => console.log(error)
);

