h, w = map(int, input().split())
arr = [[0]*(w+1) for _ in range(h+1)]

# 막대의 개수
n = int(input())
for _ in range(n):
    l, d, x, y = map(int, input().split())
    # 가로의 경우
    if d == 0:
        for i in range(y, y+l):
            arr[x][i] = 1
            
    # 세로의 경우
    else:
        for i in range(x, x+l):
            arr[i][y] = 1
        
    
for i in range(1, h+1):
    for j in range(1, w+1):
        print(arr[i][j], end=" ")
    print()
    
