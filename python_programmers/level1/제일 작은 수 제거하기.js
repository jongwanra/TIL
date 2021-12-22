// 제일 작은 수 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12935
// 해결 / 12분 소요 / 21.12.22

function solution(arr) {
  // 길이가 1인 경우
  if (arr.length === 1) {
    return [-1];
  }
  let min_idx = 0;
  arr.forEach((value, index) => {
    if (arr[min_idx] > value) {
      min_idx = index;
    }
  });

  arr.splice(min_idx, 1);
  return arr;
}

console.log(solution([4, 1, 2, 4]));
