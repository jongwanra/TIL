// 방문 길이
// https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=javascript

// 해결 방법
// 가는 길마다 갔던 장소를 Map에 넣어서 기록한다. [x, y]: true
// 단, 좌표평면의 경계를 넘어가는 명령어는 무시합니다.

// width, height로 풀자

const direction = {
    'R': [1, 0],
    'L': [-1, 0],
    'D': [0, -1],
    'U': [0, 1]
}

const getHashCode = (start, end) => {
    return `${start[0]}/${start[1]}//${end[0]}/${end[1]}`;
}
const solution = (dirs) => {
    let answer = 0;
    let currentLocation = [0, 0];
    const mapper = new Map();

    for(let d of dirs.split("")){

        const [dw, dh] = direction[d];
        const nextLocation = [currentLocation[0] + dw, currentLocation[1] + dh];
        if(nextLocation[0] < -5 || nextLocation[0] > 5 || nextLocation[1] < -5 || nextLocation[1] > 5){
            continue;
        }
        // 새로운 경로?!
        if(!mapper.get(getHashCode(currentLocation, nextLocation))
            && !mapper.get(getHashCode(currentLocation, nextLocation))){
            mapper.set(getHashCode(currentLocation, nextLocation), true);
            mapper.set(getHashCode(nextLocation, currentLocation), true);
            currentLocation = [...nextLocation];
            answer++;
            continue;
        }
        // 이미 존재한 경로
        currentLocation = [...nextLocation];


    }


    return answer;
}
