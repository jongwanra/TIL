// 나누어 떨어지는 숫자 배열
// https://programmers.co.kr/learn/courses/30/lessons/12910?language=javascript
// 해결 / 5분 이내 / 21.12.23

// 내 풀이
function solution(arr, divisor) {
  const answer = [];
  arr.forEach((value, idx) => {
    if (value % divisor === 0) {
      answer.push(value);
    }
  });

  if (answer.length === 0) {
    return [-1];
  } else {
    answer.sort((a, b) => a - b);
    return answer;
  }
}

// filter method를 이용한 다른 사람 풀이
function solution2(arr, divisor) {
  var answer = arr.filter((v) => v % divisor === 0);
  return answer.length === 0 ? [-1] : answer.sort((a, b) => a - b);
}
