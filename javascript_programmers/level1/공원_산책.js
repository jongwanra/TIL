// 230616
const getCurrentLocation = (matrix) => {
    let location = [0,0];
    matrix.forEach((list, y) => {
        list.forEach((element, x) => {
            if(element === 'S') {
                location = [x, y];
            }
        });
    });
    return location;
}

const movable = (matrix, x, y, direction, distance) => {


    for(let i = 1; i <= distance; i++ ){
        if(direction === 'E'){
            if(x + i >=  matrix[0].length){
                return false;
            }
            if(matrix[y][x + i] === 'X' ){
                return false;
            }
        }else if(direction === 'W'){
            if(x - i < 0){
                return false;
            }
            if( matrix[y][x - i] === 'X'){
                return false;
            }
        }else if(direction === 'S'){
            if(y + i === matrix.length){
                return false;
            }
            if( matrix[y + i][x] === 'X'){
                return false;
            }

        }else if(direction === 'N'){
            if(y - i < 0){
                return false;
            }
            if( matrix[y - i][x] === 'X'){
                return false;
            }

        }
    }

    return true;

}
const solution = (park, routes) => {
    const matrix = park.map((list) => list.split(""));

    routes.forEach((route) => {
        const [direction, stringDistance] = route.split(" ");
        const [x, y] = getCurrentLocation(matrix);
        const distance = Number(stringDistance);
        // 가지는지 체크!
        if(movable(matrix, x, y, direction, distance)){
            matrix[y][x] = 'O';

            switch(direction){
                case 'E':
                    matrix[y][x + distance] = 'S';
                    break;
                case 'W':
                    matrix[y][x - distance] = 'S';
                    break;
                case 'N':
                    matrix[y - distance][x] = 'S';
                    break;
                case 'S':
                    matrix[y + distance][x] = 'S';
                    break;
                default:
                    break;
            }
        }
    });

    const cur = getCurrentLocation(matrix);
    return [cur[1], cur[0]];
}