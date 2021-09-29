# 파보나치 수 2(2748)
# https://www.acmicpc.net/problem/2748

dp = [0] * 91

def fabonacci(n):
    if n == 1 or n == 2:
        return 1
    if dp[n] != 0:
        return dp[n]

    dp[n] = fabonacci(n-1) + fabonacci(n - 2)
    return dp[n]

n = int(input())
print(fabonacci(n))