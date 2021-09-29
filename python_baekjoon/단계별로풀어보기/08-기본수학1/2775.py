# # 부녀회장이 될테야(2775)
# # https://www.acmicpc.net/problem/2775

dp = [[0] * 14 for _ in range(14)]
for i in range(14):
    dp[0][i] = i + 1

def recur_find(floor, ho):
    if floor == 0:
        return ho
    sum = 0
    for i in range(1, ho + 1):
        if dp[floor-1][i - 1] != 0:
            sum += dp[floor-1][i - 1]
        else:
            dp[floor-1][i - 1] = recur_find(floor - 1, i)
            sum += dp[floor-1][i - 1]
    return sum

n = int(input())
for _ in range(n):
    floor = int(input())
    ho = int(input())
    print(recur_find(floor, ho))


# 다른 사람이 푼 방식(전체 구조를 전부 파악후 값 가져오기.)
"""
import sys

t = int(sys.stdin.readline())
arr = [[-1 for _ in range(15)] for _ in range(15)]
arr[0] = [i for i in range(15)]
for i in range(1, 15):
	for j in range(15):
		arr[i][j] = sum(arr[i-1][:(j+1)])

for _ in range(t):
    k = int(sys.stdin.readline())
    n = int(sys.stdin.readline())
    print(arr)
"""    