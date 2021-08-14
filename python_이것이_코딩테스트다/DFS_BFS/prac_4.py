# 미로 탈출(152p)

from collections import deque

def bfs(arr, start_r, start_c):
    queue = deque([(start_r, start_c)])
    
    # left, right, up, down
    dr = [0, 0, -1, 1]
    dc = [-1, 1, 0, 0]

    while queue:
        
        tmp = queue.popleft()

        for idx in range(4):
            rr = tmp[0] + dr[idx]
            cc = tmp[1] + dc[idx]

            # 범위 밖을 벗어나 있을 경우 패스
            if rr < 0 or cc < 0 or rr >= len(arr) or cc >= len(arr[0]):
                continue
            
            # 괴물 있는 곳 패스
            if arr[rr][cc] == 0:
                continue
            
            if arr[rr][cc] == 1:
                arr[rr][cc] = arr[tmp[0]][tmp[1]] + 1
                queue.append((rr, cc))

            
row, col = list(map(int, input().split()))

arr = []
for _ in range(row):
    arr.append(list(map(int, input())))

bfs(arr, 0, 0)
print(arr[row-1][col-1])

'''
5 6
101010
111111
000001
111111
111111
'''