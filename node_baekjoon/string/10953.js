'use strict';
// A + B - 6(10953)
// https://www.acmicpc.net/problem/10953

const fs = require('fs');
const input = fs.readFileSync('./input.txt').toString().split('\n');

for (let i = 1; i <= input[0]; i++) {
  let arr = input[i].split(',');
  console.log(Number(arr[0]) + Number(arr[1]));
}
