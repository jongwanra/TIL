# A+B - 7(11021)
# https://www.acmicpc.net/problem/11021

n = int(input())
for i in range(1, n+1):
    a, b = list(map(int, input().split()))
    print(f"Case #{i}: {a+b}")