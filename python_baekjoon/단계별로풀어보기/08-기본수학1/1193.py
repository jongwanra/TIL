# 분수찾기(1193)
# https://www.acmicpc.net/problem/1193

n = int(input())
i = 1
while True:
    n -= i
    if n <= 0:
        if i % 2 == 1:
            print(f"{abs(n) + 1}/{i + n}")
        else:
            print(f"{i + n}/{abs(n) + 1}")
        break
    i += 1
    
