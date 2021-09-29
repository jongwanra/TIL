# 별 찍기 - 1(2438)
# https://www.acmicpc.net/problem/2438

n = int(input())

for i in range(1, n+1):
    for _ in range(i):
        print("*", end="")
    print()