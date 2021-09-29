# 상수(2908)
# https://www.acmicpc.net/problem/2908

a, b = input().split()
a = int(a[::-1])
b = int(b[::-1])
if a < b:
    print(b)
else:
    print(a)