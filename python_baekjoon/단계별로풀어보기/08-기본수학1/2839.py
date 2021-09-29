# 설탕 배달(2839)
# https://www.acmicpc.net/problem/2839

n = int(input())
dp = [-1] * 5001

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

# 다른 사람 1
'''
n = int(input())

m = n % 5

if n == 4 or n == 7:
    print(-1)
    quit()

elif m == 0:
    print(n//5)

elif m == 3 or m == 1:
    print(n//5 + 1)

elif m == 4 or m == 2:
    print(n//5 + 2)
'''


# 다른 사람 2
'''
n = int(input())
result = 0
while True:
    if n % 5 == 0:
        result += n // 5
        break
    n -= 3
    result += 1

    if n < 0:
        result = -1
        break
print(result)

'''
