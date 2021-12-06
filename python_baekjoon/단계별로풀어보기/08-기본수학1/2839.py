# 설탕 배달(2839)
# https://www.acmicpc.net/problem/2839

n = int(input())
dp = [-1] * (n+3)

# 초기화
dp[3] = 1
dp[5] = 1

# n이 5보다 작을 경우
if n <= 5:
    print(dp[n])
    exit()

for i in range(6, n + 1):
    # 3으로 빼지는 경우
    if dp[i - 3] != -1:
        dp[i] = dp[i-3] + 1
    # 5로 빼지는 경우
    if dp[i - 5] != -1:
        if dp[i] != -1:  # 3으로 뺀 값이 들어가 있는 경우,
            dp[i] = min(dp[i], dp[i-5] + 1)
        else:
            dp[i] = dp[i - 5] + 1

print(dp[n])

# 설탕 배달(2839)
# https://www.acmicpc.net/problem/2839
# 못품 (21.12.06) 50분 소요

def recursive(cnt, origin, n):
    if origin > n:
        return
    dp[origin + 3] = cnt
    dp[origin + 5] = cnt
    
    recursive(cnt+1, origin + 3, n)     
    recursive(cnt+1, origin + 5, n)
    
# 설탕 kg입력
n = int(input())
dp = [0] * (n + 9)

cnt = 1
origin = 0
recursive(cnt, origin, n)

if dp[n] == 0:
    print(-1)
else:
    print(dp[n])    

