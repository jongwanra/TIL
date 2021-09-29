# 베르트랑 공준(4948)
# https://www.acmicpc.net/problem/4948

from math import sqrt


def eratosthenes(num):
    lst = [True] * (num+1)
    lst[1] = False

    for i in range(2, int(sqrt(num)) + 1):
        if lst[i]:
            j = 2
            while i * j <= num:
                lst[i * j] = False
                j += 1
    return lst


lst = eratosthenes(123456 * 2)
while True:
    n = int(input())
    if n == 0:
        break

    cnt = 0
    for i in range(n+1, n * 2 + 1):
        if lst[i]:
            cnt += 1
    print(cnt)
