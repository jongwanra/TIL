# [BaekJoon(백준) Python3(파이썬3)] 1158번  요세푸스 문제
# 문제 링크: https://www.acmicpc.net/problem/1158

from sys import stdin
N, K = map(int, stdin.readline().split())

lst = list(range(1, N+1))
idx = 0

print("<", end="")
while len(lst) >= 1:
    idx += (K - 1)
    if idx >= len(lst):
        idx = idx % len(lst)
    print(lst[idx], end="")

    if len(lst) == 1:
        break
    print(", ", end="")
    del(lst[idx])    
    
print(">")