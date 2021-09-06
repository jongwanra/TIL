from sys import stdin


def get_smallest_node():
    # 노드 중에서 가장 짧은 거리를 가지면서 방문하지 않은 노드 idx를 가져와야 한다.
    min = int(1e9)
    min_idx = 0
    for i in range(1, n + 1):
        if min > distance[i] and not visited[i]:
            min_idx = i
            min = distance[i]
    return min_idx


def dijkstra(start):
    # 시작 노드 거리 0 지정 및 방문 표시
    distance[start] = 0
    visited[start] = True

    # 시작 노드 인접 노드들 거리 갱신
    for node, cost in graph[start]:
        distance[node] = cost

    # 노드의 갯수만큼 반복
    for _ in range(n - 1):
        # 노드 중에서 아직 방문하지 않으면서 가장 거리가 짧은 노드 인덱스를 가져온다.
        # 가져와서 방문했다고 처리
        now = get_smallest_node()
        visited[now] = True

        # 방문처리한 노드의 인접 노드들을 갱신해 준다.
        for adj_node, adj_cost in graph[now]:
            cost = distance[now] + adj_cost
            if cost < distance[adj_node]:
                distance[adj_node] = cost


if __name__ == '__main__':
    input = stdin.readline
    INF = int(1e9)

    n, m = map(int, input().split())

    start = int(input())

    graph = [[] for _ in range(n + 1)]
    visited = [False] * (n + 1)
    distance = [INF] * (n + 1)

    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    dijkstra(start)

    for i in range(1, n + 1):
        if distance[i] == INF:
            print("INF")
        else:
            print(distance[i])
