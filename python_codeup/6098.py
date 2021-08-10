arr = []
for i in range(10):
    t_lst = list(map(int, input().split()))
    arr.append(t_lst)
# 0 -> 갈 수 있는 곳
# 1 -> 갈 수 없는 곳
# 2 -> 먹이가 있는 곳

row = 1
col = 1
while True:
    # 개미집에 위치한 경우,
    if row == 1 and col == 1:
        arr[row][col] = 9
    # 있는 위치가 0인 경우
    elif  arr[row][col] == 0:
        arr[row][col] = 9
    # 있는 위치에 먹이가 존재하는 겨우
    elif arr[row][col] == 2:
         arr[row][col] = 9
         break
    
    # 다음 곳 이동 경로
    # 오른쪽으로 이동하는 경우
    if arr[row][col+1] == 0 or arr[row][col+1] == 2:
        col += 1
    # 아래로 이동하는 경우
    elif arr[row+1][col] == 0 or arr[row+1][col] == 2:
        row += 1
    else:
        break
        
for i in range(10):
    for j in range(10):
        print(arr[i][j], end=" ")
    print()
        
     
