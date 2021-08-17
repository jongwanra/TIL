# 셀프 넘버(4673)
# https://www.acmicpc.net/problem/4673

def d_func(n):
    res = n
    while n > 0:
        res += n % 10
        n = n // 10 
    return res

res = [0] * 10001

for i in range(1, 10001):
    tmp = d_func(i)
    if tmp <= 10000:
        res[tmp] += 1

for i, value in enumerate(res):
    if value == 0 and i != 0:
        print(i) 