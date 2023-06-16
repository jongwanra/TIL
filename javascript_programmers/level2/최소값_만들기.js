const solution = (A,B) => {
    var answer = 0;

    A.sort((a, b) => b - a);
    B.sort((a, b) => a - b);

    return A.reduce((acc, cur, index) => {
        return acc += (cur * B[index]);
    }, 0);

}