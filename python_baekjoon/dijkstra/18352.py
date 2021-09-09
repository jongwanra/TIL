# 특정 거리의 도시 찾기(18352)
# https://www.acmicpc.net/problem/18352
from sys import stdin
from heapq import heappush, heappop

def dijkstra(K):
    distance[K] = 0;
    queue = [(distance[K], K)] # 해당 정점의 거리값과, 정점 번호

    while queue:
        cur_distance, cur_node = heappop(queue)
        if cur_distance > distance[cur_node]:
            continue
        for adj_vertex, adj_cost in graph[cur_node]:
            cost = distance[cur_node] + adj_cost
            if cost < distance[adj_vertex]:
                distance[adj_vertex] = cost
                heappush(queue, (distance[adj_vertex], adj_vertex))    
        
if __name__ == "__main__":
    input = stdin.readline
    INF = int(1e9)
    # 정점 vertex, 간선 edge, 거리 정보 K, 출발 정점 X
    vertex, edge, K, X = map(int, input().split())
    distance = [INF] * (vertex + 1)
    graph = [[] for _ in range(vertex + 1)]
    
    for _ in range(edge):
        start, end = map(int, input().split())
        graph[start].append((end, 1))

    dijkstra(X)
    
    cnt = 0
    for idx in range(1, len(distance)):
        if distance[idx] == K:
            print(idx)
            cnt += 1
    if cnt == 0:
        print(-1)    
