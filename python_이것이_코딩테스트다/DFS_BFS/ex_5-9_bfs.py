from collections import deque

# BFS 메서드 정의(인접리스트)
def bfs_list(graph, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])

    # 현재 노드를 방문 처리
    visited[start] = True
    
    # 큐가 빌 때까지 반복
    while queue:
        #큐에서 하나의 원소를 뽑아 출력
        v = queue.popleft()
        print(v, end=" ")
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True

# BFS 메서드 정의(인접행렬)
def bfs_matrix(matrix, start, visited):
    # 큐(Queue) 구현을 위해 deque 라이브러리 사용
    queue = deque([start])
    
    # 현재 노드를 방문 처리
    visited[start] = True
    
    # 큐가 빌 때까지 반복
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        # 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
        for idx, value in enumerate(matrix[v]):
            if value == 1 and visited[idx] is False:
                queue.append(idx)
                visited[idx] = True
    
# 각 노드와 연결된 정보를 리스트 자료형으로 표현(2차원 리스트)
# 인접 리스트 방식
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

visited = [False] * 9
bfs_list(graph, 1, visited)

print()

visited = [False] * 9
bfs_matrix(matrix, 1, visited)
