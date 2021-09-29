# 영화감독 숌(1436)
# https://www.acmicpc.net/problem/1436

n = int(input())

res = []
count = 0
data = 1
while count < n:
    if str(data).count('666') >= 1:
        res.append(data)
        count += 1
    data += 1

print(res[-1])
