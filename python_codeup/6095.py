array = [[0]* 19 for _ in range(19)]
n = int(input())
for _ in range(n):
    x, y = map(int, input().split())
    array[x-1][y-1] = 1
for i in range(19):
    for j in range(19):
        print(array[i][j], end=" ")
    print()
