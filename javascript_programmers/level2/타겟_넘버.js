const solution = (numbers, target) => {
    const rows = [[0]];

    numbers.forEach((number, idx) => {
        const list = [];
        rows[idx].forEach((v) => {
            const plus = v + number;
            const minus = v - number;
            list.push(plus);
            list.push(minus);
        });
        rows.push(list);
    });


    return rows[rows.length - 1].reduce((acc, cur) => cur === target ? acc + 1 : acc, 0);
}