# 1로 만들기(1463)
# https://www.acmicpc.net/problem/1463


def func(dp, x):
    dp[2] = 1
    
    for n in range(3, x+1):    
        # 1을 뺴는 경우
        dp[n] = (dp[n-1] + 1)
        # 3으로 나누어 떨어지는 경우
        if n % 3 == 0:        
            dp[n] = min(dp[n], dp[n // 3] + 1)
        # 2로 나누어 떨어지는 경우
        if n % 2 == 0:
            dp[n] = min(dp[n], dp[n // 2] + 1)
            
    return dp[x]

dp = [0] * 1000001
print(func(dp, int(input())))