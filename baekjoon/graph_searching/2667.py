# 단지번호 붙이기(2667)
# https://www.acmicpc.net/problem/2667


from sys import stdin

def dfs(matrix, visited, x, y, res, answer):
    # dfs를 호출한 갯수를 세면서 넘버링 한다.
    answer[res] += 1
    visited[x][y] = True
    matrix[x][y] = res
    
    # left, right, up, down
    dx = [0, 0, -1, 1]
    dy = [-1, 1, 0, 0]
    size = len(matrix[0])

    for d in range(4):
        px = x + dx[d]
        py = y + dy[d]
        
        # matrix 범위를 초과한 경우 Pass
        if px >= size or py >= size or px < 0 or py < 0:
            continue

        # 집이 없거나, 이미 방문한 경우
        if matrix[px][py] == 0 or visited[px][py] == True:
            continue

        dfs(matrix, visited, px, py, res, answer)
        
    
n = int(input())

matrix = []
visited = []
answer = dict()

# 입력 받기 및 visited 구성
for _ in range(n):
    tmp = list(map(int, list(stdin.readline().rstrip())))
    matrix.append(tmp)
    visited.append([False] * n)


res = 0
for i in range(n):
    for j in range(n):
        # 집이 존재하면서, 방문하지 않은 경우 dfs 호출 후 완전 탐색을 한다.
        if matrix[i][j] == 1 and visited[i][j] == False:
            # 몇 단지인지를 표현 하기 위한 res
            res += 1
            answer[res] = 0
            dfs(matrix,visited, i, j, res, answer)


print(res)
res_lst = list(answer.values())
res_lst.sort()

for r in res_lst:
    print(r)