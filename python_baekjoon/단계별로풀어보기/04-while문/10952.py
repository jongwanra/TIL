# A+B - 5(10952)
# https://www.acmicpc.net/problem/10952

while True:
    a, b = list(map(int, input().split()))
    if a == 0 and b == 0:
        break
    print(a+b)
