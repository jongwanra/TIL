# 합(8393)
# https://www.acmicpc.net/problem/8393


'''
재귀식 문제 풀이 -> 런타임 에러

def recursion(n):
    if n == 1:
        return 1
    return recursion(n-1) + n

print(recursion(int(input())))
'''

n = int(input())
res = 0
for i in range(n, 0, -1):
    res += i
print(res)