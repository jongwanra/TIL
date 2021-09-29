# 숫자의 개수(2577)
# https://www.acmicpc.net/problem/2577

res =  [0] * 10

num = 1
for _ in range(3):
    num *= int(input())

num = str(num)

for n in num:
    res[int(n)] += 1

for r in res:
    print(r)