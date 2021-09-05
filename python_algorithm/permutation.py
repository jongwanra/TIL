# back tracking (example: permutation)

A = [1, 2, 3] # set of datas
N = len(A) # length of A
visited = [0] * N # 데이터의 사용 여부 - 데이터의 index visited[1] = 1
arr = [0] * N # 어떤 데이터를 선택했는가(순열 정보 저장) arr[1] = 2

def permutation(level): # 0
    if level >= N:
        print(arr)
        return
    
    for i in range(N):
        if visited[i]:
            continue
        visited[i] = 1
        arr[level] = A[i]
        permutation(level+1)
        arr[level] = 0
        visited[i] = 0

permutation(0)
