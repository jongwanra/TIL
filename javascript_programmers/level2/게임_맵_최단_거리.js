// 게임 맵 최단 거리
// https://school.programmers.co.kr/learn/courses/30/lessons/1844

const solution = (maps) => {

    const dx = [1, -1, 0, 0];
    const dy = [0, 0, 1, -1];

    let answer = 0;
    const [limitX, limitY] = [maps[0].length , maps.length];

    const queue = [[0, 0]];

    while(queue.length > 0) {
        const [x, y] = queue.shift();

        if(x === limitX - 1 && y === limitY - 1){
            return maps[y][x];
        }

        for(let i = 0; i < 4; i++){
            const [nextX, nextY] = [x + dx[i], y + dy[i]];
            // 너지금 범위 넘었니 ?
            if(nextX < 0 || nextX >= limitX || nextY < 0 || nextY >= limitY ){
                continue;
            }

            // 너 지금 벽이니 ? 이 미 방문 한장소니?
            if(maps[nextY][nextX] === 0 || maps[nextY][nextX] > 1){
                continue
            }
            queue.push([nextX, nextY]);
            maps[nextY][nextX] = maps[y][x] + 1;
        }
        console.log(maps);
        console.log("------");
    }


    return -1;
}