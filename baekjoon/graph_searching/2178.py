# 미로 탐색(2178)
# https://www.acmicpc.net/problem/2178
from collections import deque

def bfs(array, visited, x, y):
    queue = deque()
    queue.append([x, y])
    visited[x][y] = True

    # left, right, up, down
    dx = [0, 0, 1, -1]
    dy = [-1, 1, 0, 0]
    
    while queue:
        x, y = queue.popleft()
    
        for i in range(4):
            px = x + dx[i]
            py = y + dy[i]
            
            # 범위 초과하면 pass
            if px < 0 or py < 0 or px >= len(array) or py >= len(array[0]):
                continue

            # 해당 위치가 아직 방문하지 않았으며, 벽이 아닌 경우
            if array[px][py] == 1 and not visited[px][py]:
                queue.append([px, py])
                visited[px][py] = True
                # 이전 위치 + 1 의 값을 저장 
                array[px][py] = array[x][y] + 1
            
    
n, m = map(int, input().split())

array = []

# 방문여부확인을 위한 2차원 배열 초기화
visited = [[False] * m for _ in range(n)]
for _ in range(n):
    array.append(list(map(int,list(input()))))

bfs(array, visited, 0, 0)
print(array[n-1][m-1])