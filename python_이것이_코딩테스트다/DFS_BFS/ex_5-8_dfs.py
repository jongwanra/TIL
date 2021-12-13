# DFS 메서드 정의(인접리스트)
def dfs_list(graph, v, visited):
    # [False,True,True,False,False,False,True,True,False]
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=" ")
    # 1 2 7 6 
    # 현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for i in graph[v]: # [2, 3, 8] / [ 7] / [ 6, 8] /
        if not visited[i]:
            dfs_list(graph, i, visited)

# DFS 메서드 정의(인접행렬)
def dfs_matrix(matrix, v, visited):
    # 현재 노드를 방문 처리
    visited[v] = True
    print(v, end=" ")
    
    #현재 노드와 연결된 다른 노드를 재귀적으로 방문
    for idx, value in enumerate(matrix[v]):
        if value == 1 and visited[idx] == False:
            dfs_matrix(matrix, idx, visited)

# 각 노드가 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)

# 인접리스트 방식
graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

# 인접 행렬 방식
INF = 99999999

matrix = [
    [INF, INF, INF, INF, INF, INF, INF, INF, INF],  # 0
    [INF, 0, 1, 1, INF, INF, INF, INF, 1],  # 1
    [INF, 1, 0, INF, INF, INF, INF, 1, INF],  # 2
    [INF, 1, INF, 0, 1, 1, INF, INF, INF],  # 3
    [INF, INF, INF, 1, 0, 1, INF, INF, INF],  # 4
    [INF, INF, INF, 1, 1, 0, INF, INF, INF],  # 5
    [INF, INF, INF, INF, INF, INF, 0, 1, INF],  # 6
    [INF, 1, INF, INF, INF, INF, 1, 0, 1],  # 7
    [INF, 1, INF, INF, INF, INF, INF, 1, 0],  # 8
]


# 정의된 DFS 함수 호출
visited = [False] * 9
dfs_list(graph, 1, visited)
print()
visited = [False] * 9
dfs_matrix(matrix, 1, visited)
