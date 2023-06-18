const mySolution = (spell, dic) => {
    const sameCounts = Array(dic.length).fill(0);
    for(let sp of spell){
        for(let i = 0; i < dic.length; i++){
            if(dic[i].includes(sp)){
                if(++sameCounts[i] === spell.length){
                    return 1;
                }
            }
        }
    }
    return 2;
}


// 다른 사람 풀이
const otherSolution = (spell, dic) => {
    return dic.filter(
        (word) => spell.every(
            (sp) => word.includes(sp)
        )).length ? 1 : 2;
}