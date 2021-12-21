// 소수 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12977?language=javascript
// 미해결 / 30분 초과

// 어디서 틀린지 모르겠다.

const aristenes = () => {
  const dp = [];
  for (let i = 0; i < 1001; i++) {
    dp.push(true);
  }
  dp[0] = false;
  dp[1] = false;

  for (let i = 2; i < Number(dp.length / 2) + 1; i++) {
    if (dp[i] === true) {
      for (let j = i + i; j < dp.length; j += i) {
        if (dp[j] == true) {
          dp[j] = false;
        }
      }
    }
  }
  return dp;
};

const combinations = (nums) => {
  const lst = [];
  for (let i = 0; i < nums.length - 2; i++) {
    for (let j = i + 1; j < nums.length - 1; j++) {
      for (let k = j + 1; k < nums.length; k++) {
        lst.push(nums[i] + nums[j] + nums[k]);
      }
    }
  }
  return lst;
};

function solution(nums) {
  let answer = 0;
  const lst = combinations(nums);
  const dp = aristenes();
  for (let i = 0; i < lst.length; i++) {
    if (dp[lst[i]] === true) {
      answer += 1;
    }
  }
  return answer;
}
