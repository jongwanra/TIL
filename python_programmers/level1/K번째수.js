// K번째수
// https://programmers.co.kr/learn/courses/30/lessons/42748?language=javascript
// 해결 / 10분 소요 / 21.12.23

function solution(array, commands) {
  const answer = [];
  for (let command of commands) {
    let [i, j, k] = command;
    i--;
    j--;
    k--;
    const tmp = array.slice(i, j + 1).sort((a, b) => a - b)[k];
    if (tmp) {
      answer.push(tmp);
    }
  }
  return answer;
}

const array = [1, 5, 2, 6, 3, 7, 4];
const commands = [
  [2, 5, 3],
  [4, 4, 1],
  [1, 7, 3],
];
console.log(solution(array, commands));
