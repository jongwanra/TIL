# 최소비용 구하기(1916)
# https://www.acmicpc.net/problem/1916

from sys import stdin
from heapq import heappush, heappop


def dijkstra(start):
    queue = []
    distance[start] = 0  # 시작 정점 비용 0
    heappush(queue, (distance[start], start))

    while queue:
        dis, node = heappop(queue)

        if distance[node] < dis:
            continue

        for adj_node, adj_cost in graph[node]:
            cost = distance[node] + adj_cost

            if distance[adj_node] > cost:
                distance[adj_node] = cost
                heappush(queue, (distance[adj_node], adj_node))


if __name__ == '__main__':
    input = stdin.readline
    INF = int(1e9)

    N = int(input())  # 도시의 개수(정점)
    M = int(input())  # 버스의 개수(간선)

    graph = [[] for _ in range(N + 1)]
    distance = [INF] * (N + 1)
    for _ in range(M):
        # 출발 정점 a에서 b 정점으로 가는 비용 c
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    start, end = map(int, input().split())

    dijkstra(start)
    print(distance[end])
