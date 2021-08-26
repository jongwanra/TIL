# 소수 구하기(1929)
# https://www.acmicpc.net/problem/1929

# 방법 1

import math
def check_prime_num(num):
    '''
    소수 판별 함수.
    소수이면 1 소수가 아니면 0 반환.
    '''
    if num == 1:
        return 0
    if num == 2:
        return 1

    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return 0
    return 1

m, n = map(int, input().split())

for num in range(m, n+1):
    if check_prime_num(num) == 1:
        print(num)



# 방법 2(에라토스테네스의 체)

import math
def eratosthenes(num):
    lst = [True] * (num+1)
    lst[1] = False 
    
    for i in range(2, int(math.sqrt(num)) + 1):
        if lst[i]:
            j = 2
            while i * j <= num:
                lst[i * j] = False
                j += 1
    return lst

m, n = map(int, input().split())
res = eratosthenes(n)
for i in range(m, n + 1):
    if res[i]:
        print(i)
