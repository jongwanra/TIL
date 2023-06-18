const isValidWord = (word, wordToCompare, wordLength) => {
    let diffCount = 0;
    for (let i = 0; i < wordLength; i++) {
        if (word[i] !== wordToCompare[i]) {
            diffCount += 1;
        }
        if (diffCount > 1) {
            return false;
        }
    }
    return true;
}

const solution = (begin, target, words) => {
    const wordLength = target.split("").length;
    const wordMap = new Map();
    words.forEach((word) => {
        wordMap.set(word, false);
    });

    const queue = [];
    queue.push([begin, 0]);

    while (queue.length) {
        const [word, step] = queue.shift();

        /* 이미 방문한 적 있는 word */
        if (wordMap.get(word) === true) {
            continue;
        }

        /* 처음 시작하는 word */
        if (word === begin) {
        } else if (wordMap.get(word) === undefined) {
            continue;
        }

        if (word === target) {
            return step;
        }

        /* 방문 표시 */
        wordMap.set(word, true);


        for (let [key, value] of wordMap.entries()) {
            // 이미 방문한 적이 있는 경우
            if (value === true) {
                continue;
            }

            if (isValidWord(word, key, wordLength)) {
                queue.push([key, step + 1]);
            }
        }
    }
    return 0;
}