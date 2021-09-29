# 덩치(7568)
# https://www.acmicpc.net/problem/7568
# 못 품(21.09.01)

from sys import stdin

n = int(input())

people = []
for _ in range(n):
    people.append(list(map(int, stdin.readline().split())))

for target in people:
    rank = 1
    for sub in people:
        if target[0] < sub[0] and target[1] < sub[1]:
            rank += 1
    print(rank, end=" ")
