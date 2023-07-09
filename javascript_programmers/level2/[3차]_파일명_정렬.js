// [3차] 파일명 정렬
// https://school.programmers.co.kr/learn/courses/30/lessons/17686

const findNumberStartIndex = (body) => {
    return [...body].findIndex((v) => {
        return v >= "0" && v <= "9";
    });
}
const solution = (files) => {
    const newFiles = files.map((v) => {
        const [body, tail] = v.split(".");
        const numStartIndex = findNumberStartIndex(body);
        const header = body.slice(0, numStartIndex);
        const numBody = body.slice(numStartIndex);
        return [header, numBody.split(" ")[0], v];
    });

    return newFiles
        .sort((a, b) => parseInt(a[1]) - parseInt(b[1]))
        .sort((a, b) => a[0].toUpperCase() < b[0].toUpperCase() ? -1 : 1)
        .map((v) => v[2]);
}