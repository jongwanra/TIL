# 한수(1056)
# https://www.acmicpc.net/problem/1065 

def func(num):
    lst = [num //100, num // 10 % 10, num % 10]
    if (lst[0] - lst[1]) == (lst[1] - lst[2]):
        return 1
    return 0
        
n = int(input())
# 1 ~ 99
if n < 100:
    print(n)
else:
    # 1000
    if n == 1000:
        print(144)
    # 100 ~ 999
    else:
        res = 99
        for i in range(100, n + 1):
            res += func(i)
        print(res)

    