# 수 정렬하기 3(10989)
# https://www.acmicpc.net/problem/10989

from sys import stdin
datas = [0] * 10001

n = int(input())

for i in range(n):
    tmp = int(stdin.readline())
    datas[tmp] += 1

for i in range(len(datas)):
    while datas[i] >= 1:
        print(i)
        datas[i] -= 1