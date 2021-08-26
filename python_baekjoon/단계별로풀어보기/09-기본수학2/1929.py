# 소수 구하기(1929)
# https://www.acmicpc.net/problem/1929

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
