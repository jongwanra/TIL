# 빠른 A+B(15552)
# https://www.acmicpc.net/problem/15552

from sys import stdin

n = int(input())

for _ in range(n):
    a, b = list(map(int, stdin.readline().rstrip().split()))
    print(a+b)