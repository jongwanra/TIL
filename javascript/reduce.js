// const arr = [5, 4, 3, 2, 1];

// arr.reduce(function (acc, value, idx, array) {
//   console.log(`acc: ${acc} / value: ${value} / idx: ${idx}`);
//   return acc + value;
// }, 0);

// console.log(arr);

var a = [1, 2, 3, 4, 5, 6, 7];

// result = a.reduce((acc, cur, i) => {
//   acc.push(cur % 2 ? '홀수' : '짝수');
//   return acc;
// }, []);

// console.log(result);

console.log(
  [1, 4, -1, 2, 6, 10, 4, 5, 6, 7].sort((a, b) => {
    return a - b;
  })
);
