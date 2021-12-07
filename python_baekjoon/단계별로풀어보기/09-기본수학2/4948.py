# 베르트랑 공준(4948)
# https://www.acmicpc.net/problem/4948
# 해결 / 15분 소요 / 21.12.07
# 소수 이면 True 아니면 False 인 데이터

def eratostenes():
    # 제한: 1 ≤ n ≤ 123,456
    size = 123456 * 2 + 1
    datas = [True] * size
    # 0, 1 은 소수가 아님
    datas[0] = False
    datas[1] = False
    
    for i in range(2, int((size + 1) ** 0.5) + 1):
        if datas[i]:
            for j in range(i+i, size+1, i):
                datas[j] = False 
    return datas

datas = eratostenes()
while True:
    tmp = int(input())
    # 종료 조건
    if tmp == 0:
        break
    cnt = 0
    for i in range(tmp+1, tmp*2 + 1):
        if datas[i]:
            cnt += 1
    print(cnt)



# 베르트랑 공준(4948)
# https://www.acmicpc.net/problem/4948

from math import sqrt


def eratosthenes(num):
    lst = [True] * (num+1)
    lst[1] = False

    for i in range(2, int(sqrt(num)) + 1):
        if lst[i]:
            j = 2
            while i * j <= num:
                lst[i * j] = False
                j += 1
    return lst


lst = eratosthenes(123456 * 2)
while True:
    n = int(input())
    if n == 0:
        break

    cnt = 0
    for i in range(n+1, n * 2 + 1):
        if lst[i]:
            cnt += 1
    print(cnt)
