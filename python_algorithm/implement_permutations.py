A = [1, 2, 3, 4, 5, 6]
N = len(A)
visited = [False] * N
arr = [0] * N

def permutation(level):
    # 종료 조건
    if level >= N:
        print(arr)
        return
    
    for i in range(N):
        if visited[i]: # 방문한 공간일 경우, 패스
            continue
        
        visited[i] = True
        arr[level] = A[i]
        permutation(level+1)
        arr[level] = 0
        visited[i] = False
        
        

permutation(0)