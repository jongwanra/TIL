const convertNameArrayToMap = (names, yearnings) => {
    const nameToYearningMap = new Map();

    names.forEach((name, index) => {
        nameToYearningMap.set(name, yearnings[index]);
    });

    return nameToYearningMap;
}

const solution = (name, yearning, photo) => {
    const answer = Array(photo.length).fill(0);

    const nameToYearningMap = convertNameArrayToMap(name, yearning);

    photo.forEach(
        (list, index) => {
            list.forEach((element) => {
                answer[index] += nameToYearningMap?.get(element) || 0;
            });
        });

    return answer;
}