# 나이순 정렬(10814)
# https://www.acmicpc.net/problem/10814

from sys import stdin
n = int(input())

datas = []
for _ in range(n):
    age, name = stdin.readline().split()
    datas.append((int(age), name))
    
datas.sort(key=lambda x:x[0])

for data in datas:
    print(data[0], data[1])