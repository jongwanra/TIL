// 1 => 1
// 2 => 2
// 3 => 3
// 4 => 5
// 5 => 8
// 6 => 13

const solution = (n) => {
    const memory = [0, 1, 2];
    for(let i = 3; i <= n; i++){
        memory.push((memory[i - 1] + memory[i - 2]) % 1234567);
    }
    // console.log(":: memory::", memory);
    return memory[n];
}



// solution Top - Bottom

let memory = [];
const topBottomCase = (x) => {
    if(x === 1){
        return 1;
    }
    if(x === 2) {
        return 2;
    }

    const x1 = memory?.[x - 1] || topBottomCase(x - 1);
    const x2 = memory?.[x - 2] || topBottomCase(x - 2);
    const result = (x1 +  x2) % 1234567;
    if(!memory[x]){
        memory[x] = result;
    }
    return result;
}


const solution = (n) => {
    memory = Array(n).fill(null);
    return topBottomCase(n);
}