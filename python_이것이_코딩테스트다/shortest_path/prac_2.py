# 미래 도시(259p)
# 못품(21.08.25)

INF = int(1e9) # 무한대 설정

# 정점, 간선의 갯수 입력받기
n, m = map(int, input().split())

# 행렬 초기화
matrix = [[INF] * (n + 1) for _ in range(n + 1)]

# 자기 자신과 자기 자신이 있는 거리는 0으로 초기화
for i in range(1, n + 1):
    for j in range(1, n + 1):
        if i == j:
            matrix[i][j] = 0


for _ in range(m):
    # 연결된 회사들 입력 받기
    a, b = map(int, input().split())
    
    # matrix에 추가(무방향 간선 이므로 양쪽 다 추가)
    matrix[a][b] = 1
    matrix[b][a] = 1

# 회사, 미팅 장소 
x, k = map(int, input().split())

# Floyd Algorithm
# d ab = min(d ab, d ak + d kb)
for a in range(1, n + 1):
    for b in range(1, n + 1):
        for k in range(1, n + 1):
                matrix[a][b] = min(matrix[a][b], matrix[a][k] + matrix[k][b])

for a in range(1, n + 1):
    for b in range(1, n + 1):
        # 도달할 수 없는 경우, 무한(INFINITY) 출력
        if matrix[a][b] == INF:
            print("INF", end=" ")
        # 도달할 수 있는 경우 거리를 출력
        else:
            print(matrix[a][b], end=" ")
    print()


distance = matrix[1][x] + matrix[x][k]

if distance >= INF:
    print("-1")
else:
    print(distance)

    
    
