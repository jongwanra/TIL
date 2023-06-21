
def dfs(graph, v, visited):
    stack = []
    stack.append(v)

    print(stack)
    while len(stack):
        popped = stack.pop()
        if visited[popped]:
            continue
        print("pop:", popped)
        visited[popped] = True
        for node in sorted(graph[popped], reverse=True):
            if not visited[node]:
                stack.append(node)


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

visited = [False] * 9

dfs(graph, 1, visited)