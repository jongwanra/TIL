// async & await
// clear style of using promise :)

// 1. async  async를 앞에 붙이면 형식을 비동기식 promise 형태로 바꾸어 준다.
async function fetchUser(){
    // 동기적으로 받아오면 너무 오래 기다릴 수 있음
    // do network request in 10 secs ... 
    return 'ellie';
    
    // return new Promise((resolve, reject) => {
    //     //do network reqeust in 10 secs...
    //     resolve('ellie');
    // })
    
}

const user = fetchUser();
user.then(console.log);
console.log(user);

// 2. await🔥
function delay(ms){
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple(){
    await delay(1000);
    return '🍎';
}

async function getBanana(){
    await delay(1000);
    return '🍌';
}

async function pickFruits(){
    // 1초만에 병렬적으로 실행하기
    const applePromise = getApple();
    const bananaPromise = getBanana();
    const apple = await applePromise;
    const banana = await bananaPromise;
    return `${apple} + ${banana}`;
}

pickFruits().then(console.log);

// 3. useful Promise APIs
function pickAllFruits(){
    return Promise.all([getApple(), getBanana()])
    .then(fruits => fruits.join(' + '));
}

pickFruits().then(console.log);

function pickOnlyOne(){
    return Promise.race([getApple(), getBanana()]);
}

pickOnlyOne().then(console.log);
