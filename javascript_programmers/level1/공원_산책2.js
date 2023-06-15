// 230616
// 다른 사람 풀이 보고 다시 풀기!



// (h, w)
const getDirectionMap = () => {
    return new Map([
        ['E', [0, 1]],
        ['W', [0, -1]],
        ['N', [-1, 0]],
        ['S', [1, 0]]
    ]);
}
const getStartLocation = (park) => {
    for(let h = 0; h < park.length; h++){
        if(park[h].includes('S')){
            return [h, park[h].indexOf('S')];
        }
    }
    return [0, 0];
}
const solution = (park, routes) => {
    const directionMap = getDirectionMap();
    let [originH, originW] = getStartLocation(park);
    const maxH = park.length;
    const maxW = park[0].length;


    routes.forEach((route) => {
        const [direction, distance] = route.split(" ");
        let [tempH, tempW] = [originH, originW];
        let movable = true;
        for(let d = 1; d <= distance; d++){
            const [nh, nw] = directionMap.get(direction);

            // 범위를 벗어났을 때
            if(tempH + nh >= maxH || tempH + nh < 0 || tempW + nw >= maxW || tempW + nw < 0 ){
                movable = false;
                break;
            }

            // 장애물
            if(park[tempH + nh][tempW + nw] === 'X'){
                movable = false;
                break;
            }

            [tempH, tempW] = [tempH + nh, tempW + nw];
        }

        if(movable){
            [originH, originW] = [tempH, tempW];
        }
    });

    return [originH, originW];
}