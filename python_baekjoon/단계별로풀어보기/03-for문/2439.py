# 별 찍기 - 2(2439)
# https://www.acmicpc.net/problem/2439

n = int(input()) 

for i in range(1, n+1):
    print(" " * (n-i) + "*" * i)
