const directionMap = new Map([
    ['E', [1, 0]],
    ['W', [-1, 0]],
    ['N', [0, -1]],
    ['S', [0, 1]]
]);

const enqueueByDireciton = ([beforeW, beforeH, step], queue, direction) => {
    const [dw, dh] = directionMap.get(direction);
    queue.push([beforeW + dw, beforeH + dh, step + 1]);
}
const solution = (maps) => {
    const [width, height] = [maps[0].length, maps.length];
    const queue = [];

    queue.push([0, 0, 1]);

    while(queue.length) {
        const [w, h, step] = queue.shift();
        if (w < 0 || w >= width ) {
            continue;
        } else if (h < 0 || h >= height) {
            continue;
        } else if (maps[h][w] === 0) {
            continue;
        }

        if (width - 1 === w && height - 1 === h) {
            return step;
        }
        maps[h][w] = 0;
        enqueueByDireciton([w, h, step], queue, 'E');
        enqueueByDireciton([w, h, step], queue, 'W');
        enqueueByDireciton([w, h, step], queue, 'N');
        enqueueByDireciton([w, h, step], queue, 'S');
    }
    return -1;
}
