# 소수 찾기(1978)
# https://www.acmicpc.net/problem/1978

def check_prime_num(num):
    '''
    소수 판별 함수.
    소수이면 1 소수가 아니면 0 반환.
    '''
    if num == 1:
        return 0
    if num == 2:
        return 1

    for i in range(2, num):
        if num % i == 0:
            return 0
    return 1

n = int(input())
lst = list(map(int, input().split()))

res = 0
for num in lst:
    res += check_prime_num(num)
print(res)
    