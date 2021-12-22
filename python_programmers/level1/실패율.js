// 실패율
// https://programmers.co.kr/learn/courses/30/lessons/42889
// 미해결 / 30분 초과 / 21.12.22(문법에 적응을 못하고 있음)

/* 
실패율 = 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
- 
실패율이 높은 스테이지부터 내림차순으로 정렬하기

- 접근
- 각 스테이지에 있는 유저들의 인원 수 카운팅
- 
*/
function solution(N, stages) {
  const failRates = [];
  const answer = [];
  const nums = stages.length;
  // 배열 초기화
  for (let i = 0; i <= N + 1; i++) {
    failRates.push(0);
  }

  stages.forEach((element) => {
    failRates[element]++;
  });

  // 아직 클리어하지 못한 플레이어의 수
  const result = failRates.reduce(function (acc, value, index, array) {
    console.log(`acc: ${acc}, value: ${value}, 'index: ${index}`);
    if (acc.length >= 1) {
      acc.push(array[index - 1] + value);
    } else {
      acc.push(value);
    }
    return acc;
  }, []);
  console.log(result);
  return answer;
}

const stages = [2, 1, 2, 6, 2, 4, 3, 3];
const N = 5;
console.log(solution(N, stages));
