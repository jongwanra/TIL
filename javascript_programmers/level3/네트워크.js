const dfs = (computers, v, visited) => {
    // 방문 처리
    visited[v] = true;

    computers[v].forEach((computer, index) => {
        if(computer === 1 && visited[index] === false){
            dfs(computers, index, visited);
        }
    });

}

const solution = (n, computers) => {
    let networkCount = 0;
    const visited = Array(n).fill(false);

    visited.forEach((v, index) => {
        if(v === false){
            networkCount += 1;
            dfs(computers, index, visited);
        }
    });

    return networkCount;

}