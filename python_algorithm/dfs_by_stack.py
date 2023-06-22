
def dfs(graph, v):
    path = []
    stack = []
    stack.append(v)

    while len(stack):
        top = stack[-1]

        if len(graph[top]) == 0 :
            path.append(stack.pop())
        else:
            target = graph[top][-1]
            stack.append(target)
            graph[top] = graph[top][:-1]
            graph[target].remove(top)

        print("stack:", stack)
        print("graph:", graph)
        print("-------")
    return path

graph = [
    [],
    [2, 3],
    [1, 7],
    [1, 4],
    [3, 5],
    [4],
    [7],
    [2, 6, 8],
    [7]
]

# visited = [False] * 9

path = dfs(graph, 1)
print(path[::-1])