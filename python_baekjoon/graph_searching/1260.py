# DFS와 BFS(1260)
# https://www.acmicpc.net/problem/1260 

from collections import deque

def dfs(graph, visited, v):
    visited[v] = True
    print(v, end=" ")
    
    for idx in graph[v]:
        if not visited[idx]:
            dfs(graph, visited, idx)

def bfs(graph, visited, v):
    queue = deque([v])
    visited[v] = True
    
    while queue:
        res = queue.popleft()
        print(res, end=" ")
        
        for idx in graph[res]:
            if not visited[idx]:
                queue.append(idx)
                visited[idx] = True
    
    
n, m, v = map(int, input().split())

graph = [[] for _ in range(n+1)]
for _ in range(m):
    v1, v2 = map(int, input().split())
    graph[v1].append(v2)
    graph[v2].append(v1)

for i in range(1, n+1):
    graph[i].sort()

visited = [False] * (n+1)
dfs(graph, visited, v)
print()
visited = [False] * (n+1)
bfs(graph, visited, v)