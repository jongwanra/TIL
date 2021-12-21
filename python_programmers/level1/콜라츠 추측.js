// 콜라츠 추측
// https://programmers.co.kr/learn/courses/30/lessons/12943
// 해결 / 3분 소요 / 21.12.21
// 구현력을 물어보는 문제, 주어진 조건대로 풀자

function solution(num) {
  let cnt = 0;
  while (num != 1) {
    // 500번 반복해도 1이 나오지 않을 경우
    if (cnt >= 500) {
      return -1;
    }
    // 짝수 or 홀수일 경우
    num = num % 2 === 0 ? num / 2 : num * 3 + 1;
    cnt++;
  }
  return cnt;
}
