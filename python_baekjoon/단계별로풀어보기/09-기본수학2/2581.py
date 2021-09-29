# 소수(2581)
# https://www.acmicpc.net/problem/2581

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

m = int(input())
n = int(input())

res = []
for num in range(m, n+1):
    if check_prime_num(num) == 1:
        res.append(num)

if len(res) == 0:
    print(-1)    
else:
    print(sum(res))
    print(min(res))

