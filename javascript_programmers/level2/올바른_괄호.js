
// 스택 방식으로 구현
const solution1 = (s) => {
    const stackA = s.split("");
    const stackB =  [];

    while(true){
        if(stackA.length === 0){
            break;
        }
        const element = stackA.pop();

        // pop한 요소가 ')'이면 짚어넣기
        if(element === ')'){
            stackB.push(element);
        }else if(element === '('){
            if(stackB.length === 0){
                return false;
            }
            stackB.pop();
        }
    }
    return stackB.length === 0;``
}


// count 방식으로 구현
const solution2 = (s) => {
    let count = 0
    for(element of s){
        if(element === '('){
            count += 1;
        }else {
            count -= 1;
        }
        if(count < 0){
            return false;
        }
    }

    return count === 0;
}