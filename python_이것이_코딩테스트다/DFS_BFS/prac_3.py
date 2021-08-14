# 음료수 얼려 먹기(149p)

def dfs(arr, r, c):
    # 방문 표시
    arr[r][c] = 1
    
    #left, right, up, down
    dr = [0, 0, -1, 1]
    dc = [-1, 1, 0, 0]

    for idx in range(4):
        rr = r + dr[idx]
        cc = c + dc[idx]

        # 범위를 벗어나는 경우 패스
        if rr < 0 or cc < 0 or rr >= len(arr) or cc >= len(arr[0]):
            continue
        
        # 이미 방문했거나, 칸막이인 경우 패스
        if arr[rr][cc] == 1:
            continue
        
        dfs(arr, rr, cc)
        
row, col = list(map(int, input().split()))
arr = []
for _ in range(row):
    arr.append(list(map(int, list(input()))))

res = 0
for r in range(row):
    for c in range(col):
        if arr[r][c] == 0:
            dfs(arr, r, c)
            res += 1

print(res)