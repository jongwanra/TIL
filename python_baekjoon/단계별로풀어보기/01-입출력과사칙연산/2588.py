# 곱셈(2588)
# https://www.acmicpc.net/problem/2588

n1 = int(input())
n2 = int(input())

i = 1
while i <= 100:
    print(n1 * (n2 // i % 10))
    i *= 10
print(n1*n2)

