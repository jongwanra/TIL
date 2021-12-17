def dfs(n,computers, idx, visited):
    # 방문 표시
    visited[idx] = True
    
    for i in range(n):
        if i != idx and computers[idx][i] == 1:
            if not visited[i]:
                dfs(n,computers,i, visited)
    

def solution(n, computers):
    answer = 0
    visited = [False] * n
    
    for i in range(n):
        if not visited[i]:
            dfs(n, computers, i, visited)
            answer += 1
            
    return answer