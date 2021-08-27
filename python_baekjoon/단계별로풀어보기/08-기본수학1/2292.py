# 벌집(2292)
# https://www.acmicpc.net/problem/2292

n = int(input())

i = 0
while True:
    n -= (6 * i)
    if n <= 1:
        print(i+1)
        break
    i += 1
