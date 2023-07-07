// 스킬트리
// https://school.programmers.co.kr/learn/courses/30/lessons/49993

// 접근 방법
// skill_trees를 돌면서 skill의 위 순서부터 하나씩 비교해 나간다.
// skill_trees요소를 다 돌았을때 skill이 0 index까지 왔다면 answer++


// 접근 방법2
// skill에다가 우선순위를 부여한 Map생성
//

const solution = (skill, skill_trees) => {
    let answer = 0;
    const map = new Map();

    skill.split("").forEach((v, i) => {
        map.set(v, i + 1);
    });

    console.log('map::', map);

    skill_trees.map((values) => {
        let prev = 0;
        const checkList = values.split("");
        let isPass = true;
        for(let i = 0; i < checkList.length; i++){

            // 아예 없는 케이스는 패스
            if(!map.get(checkList[i])){
                continue;
            }

            if(map.get(checkList[i]) !== prev + 1){
                isPass = false;
                break;
            }
            prev++;

        }
        if(isPass){
            answer++;
        }
    });
    return answer;

}