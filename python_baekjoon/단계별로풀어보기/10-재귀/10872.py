# 팩토리얼(10872)
# https://www.acmicpc.net/problem/10872

def recur_factorial(n):
    if n <= 1:
        return 1
    return recur_factorial(n - 1) * n


def factorial(n):
    res = 1
    for i in range(1, n+1):
        res *= i
    return res


n = int(input())
print(recur_factorial(n))
# print(factorial(n))
