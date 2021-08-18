# 개미 전사(220p)

n = int(input())
lst = list(map(int, input().split()))

# 점화식: d(n) = max(d(n-1), d(n-2) + cur)

dp = [0] * n
dp[0] = lst[0]
dp[1] = max(lst[0], lst[1])
for i in range(2, n):
    dp[i] = max(dp[i-1], dp[i-2] + lst[i])

print(dp[n-1])