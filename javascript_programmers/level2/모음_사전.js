// 모음 사전
// https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=javascript

// 문제 접근
// 이건 완전 탐색 문제이다.
// A, E, I, O, U 각각 DFS를 통해 적절 result를 구하면 될 것 같다


let idx = 0;

const dfs = (dict, vowels, words, length) => {
    // 종료 조건
    if(length > vowels.length){
        return;
    }

    dict[words] = idx++;
    vowels.forEach((vowel) => {
        dfs(dict, vowels, words + vowel, length + 1);
    });
}
const solution =(word) => {
    const dict = {};
    const vowels = ['A', 'E', 'I', 'O', 'U'];
    dfs(dict, vowels, "", 0);
    // console.log('dict::', dict);
    return dict[word];
}



solution("AAAAE");