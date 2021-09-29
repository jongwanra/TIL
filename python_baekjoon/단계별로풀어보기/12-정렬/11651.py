# 좌표 정렬하기 2(11651)
# https://www.acmicpc.net/problem/11651

from sys import stdin
n = int(input())

datas = []
for _ in range(n):
    x, y = map(int, stdin.readline().split())
    datas.append((x, y))

datas.sort(key = lambda x: x[0])
datas.sort(key = lambda x: x[1])

for data in datas:
    print(data[0], data[1])
