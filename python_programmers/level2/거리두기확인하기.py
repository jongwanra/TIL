# 맨헤튼 거리는 (r1, c1), (r2, c2) 에 위치
# |r1 - r2| + |c1 - c2| > 2
from collections import deque

def bfs(place, visited, r, c):
    queue = deque()
    visited[r][c] = True
    queue.append((r,c))
    
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    
    while queue:
        loc = queue.popleft()
        for idx  in range(4):
            px = loc[0] + dx[idx]
            py = loc[1] + dy[idx]
            
            # 범위를 초과한 경우
            if px < 0 or py < 0 or px >= 5 or py >= 5:
                continue
            # 파티션 인경우
            if place[px][py] == "X":
                visited[px][py] = True
                continue
            # 맨헤튼 거리를 초과했을 경우
            if abs(r - px) + abs(c - py) > 2:
                visited[px][py] = True
                continue
            # 먼저 방문한 경우
            if visited[px][py] == True:
                continue
            # 거리두기 안에 P가 있는 경우
            if place[px][py] == "P":
                return 0
            queue.append((px,py))
            visited[px][py] = True
    return 1
        
def solution(places):
    answer = []
    
    for place in places:
        flag = True
        for r in range(5):
            for c in range(5):
                if place[r][c] == "P":                    
                    visited = [[False] * 5 for _ in range(5)]
                    res = bfs(place, visited, r, c)
                    if res == False:
                        flag = False
                        break
            if flag == False:
                break
        if flag == True:
            answer.append(1)
        else:
            answer.append(0)
    print(answer)
    return answer