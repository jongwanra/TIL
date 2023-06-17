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