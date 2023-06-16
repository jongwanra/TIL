const convertDecimalToBinary = (num) => {
    let binary = "";
    let tempNum = num;
    while(tempNum > 0){
        binary = tempNum % 2 === 1 ? "1" + binary :  "0" + binary;
        tempNum =  Math.floor(tempNum / 2);
    }
    return binary;
}

const solution = (s) => {
    let totalCount = 0;
    let totalZeroCount = 0;
    while (s !== "1"){
        const zeroCount = s.split("").reduce((acc, cur, idx) => {
            return cur === "0" ? acc + 1 : acc;
        }, 0);

        totalZeroCount += zeroCount;
        totalCount += 1;

        // 0전부 제거
        s = s.split("0").join("");
        s = convertDecimalToBinary(s.length);
    }

    return [totalCount, totalZeroCount];
}