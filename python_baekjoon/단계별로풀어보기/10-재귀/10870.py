# 피보나치 수 5(10870)
# https://www.acmicpc.net/problem/10870

def fibo(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1

    return fibo(n-1) + fibo(n - 2)


print(fibo(int(input())))
