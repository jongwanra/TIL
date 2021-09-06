# 최단경로(1753)
# https://www.acmicpc.net/problem/1753
from sys import stdin
from heapq import heappush, heappop


# 다익스트라 최단경로 알고리즘
def dijkstra(start):
    queue = []
    heappush(queue, (0, start))
    distance[start] = 0

    while queue:
        # 거리가 가장 짧은 노드의 거리와, 노드를 꺼낸다.
        dis, cur_node = heappop(queue)
        # 기존 노드의 거리가 더 작을 경우 방문 했음으로 간주하고 무시
        if dis > distance[cur_node]:
            continue

        # 현재 노드의 인접노드들과 가중치를 가져온다.
        for adj_node, adj_cost in graph[cur_node]:
            cost = distance[cur_node] + adj_cost
            if distance[adj_node] > cost:
                distance[adj_node] = cost
                heappush(queue, (distance[adj_node], adj_node))


# main
if __name__ == '__main__':
    input = stdin.readline
    INF = int(1e9)
    # 정점, 간선 입력
    V, E = map(int, input().split())
    start = int(input())  # 시작 정점 입력

    distance = [INF] * (V + 1)
    graph = [[] for _ in range(V + 1)]

    # u에서 v로 가는 가중치 w인 간선 입력
    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))

    dijkstra(start)

    for i in range(1, V + 1):
        if distance[i] == INF:
            print('INF')
        else:
            print(distance[i])
