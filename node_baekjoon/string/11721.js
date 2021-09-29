// 열 개씩 끊어서 출력하기 (11721)
// https://www.acmicpc.net/problem/11721
// 품 (21.09.29)

const fs = require('fs');

let input = fs.readFileSync('/dev/stdin').toString();
// let input = fs.readFileSync('./11721.txt').toString();

let j = 0;
for (let i = 10; i < input.length; i += 10) {
  console.log(input.slice(j, i));
  j = i;
}
console.log(input.slice(j));
