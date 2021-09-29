# 평균(1546)
# https://www.acmicpc.net/problem/1546

n = int(input())
lst = list(map(int, input().split()))
avg = 0
max_score = max(lst)

for score in lst:
    avg += (score / max_score) * 100

print(avg / n)