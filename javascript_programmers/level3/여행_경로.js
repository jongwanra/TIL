/*
    테스트 케이스는 성공
    제출 케이스는 1,2 번 실패
*/

const dfs = (graphMap, visitedMap, department, arrival, answers) => {

    // 방문 처리
    visitedMap.set(`${department}-${arrival}`, visitedMap.get(`${department}-${arrival}`) - 1);

    answers.push(arrival);

    const arrivals = graphMap.get(arrival) || [];
    for(let nextFlight of arrivals){
        const check = visitedMap.get(`${arrival}-${nextFlight}`);
        if(check >= 1){
            dfs(graphMap, visitedMap, arrival, nextFlight, answers);
        }
    }
}

const solution = (tickets) => {
    const answers = ['ICN'];
    const visitedMap = new Map();
    const graphMap = new Map();

    // 방문 맵, Graph 맵 셋팅
    tickets.forEach((ticket) => {
        const [departure, arrival] = ticket;
        const isDuplicated = visitedMap.get(`${departure}-${arrival}`);
        visitedMap.set(`${departure}-${arrival}`, isDuplicated ? isDulicated + 1 : 1);
        graphMap.set(departure, [...graphMap.get(departure) || [], arrival].sort());
    });
    const departments = graphMap.get('ICN');
    dfs(graphMap, visitedMap, 'ICN', departments[0], answers);

    return answers;
}