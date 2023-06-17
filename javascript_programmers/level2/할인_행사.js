
const solution = (want, number, discount)=> {
    let answer = 0;

    const originMap = {};
    want.forEach((v, index) => {
        originMap[v] = number[index];
    });

    const discountSize = discount.length;
    for(let i = 0; i <= discountSize - 10; i++){
        const tempMap = { ...originMap };

        for(let j = i; j <= i + 10; j++){
            const target = discount[j];
            if(!tempMap[target]){
                break;
            }
            tempMap[target] -= 1;

            if(tempMap[target] === 0) {
                delete tempMap[target];
            }
        }

        if(Object.keys(tempMap).length === 0){
            answer += 1;
        }

    }

    return answer;
}
