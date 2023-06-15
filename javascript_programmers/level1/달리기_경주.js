

const convertArrayToMap = (players) => {
    const map = new Map();
    
    let ranking = 0;
    players.forEach((player) => {
        map.set(player, ranking);
        ranking += 1;
    });
    
    return map;
}

const swapPlayer = (playerToRankingMap, players, currentPlayer) => {
    const currentPlayerLocation = playerToRankingMap.get(currentPlayer);
    const frontPlayer = players[currentPlayerLocation - 1];
    
    
    playerToRankingMap.set(currentPlayer, currentPlayerLocation - 1);
    playerToRankingMap.set(frontPlayer, currentPlayerLocation);

    players[currentPlayerLocation - 1] = currentPlayer;
    players[currentPlayerLocation] = frontPlayer;
}

function solution(players, callings) {
    const playerToRankingMap = convertArrayToMap(players);

    callings.forEach((calling) => {
        swapPlayer(playerToRankingMap, players, calling);
    });

    return players;
}


