# 골드바흐의 추측(9020)
# https://www.acmicpc.net/problem/9020

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


n = int(input())

lst = eratosthenes(10000)

for _ in range(n):
    # tmp 입력 받기
    tmp = int(input())

    t_lst = []
    for i in range(tmp):
        # 해당 i가 소수이면서, tmp-i가 소수인 경우, t_lst 추가
        if lst[i] is True and lst[tmp-i] is True:
            t_lst.append((i, tmp-i))

    # 그 안에 소수 묶음이 1개인 경우, 출력
    if len(t_lst) <= 1:
        print(f"{t_lst[0][0]} {t_lst[0][1]}")
    # 2개 이상인 경우, 두 소수의 차이가 최소인 경우를 찾아서 출력
    else:
        res = []
        for p1, p2 in t_lst:
            # 빈 리스트에 t_lst안에 요소들의 차를 새로운 res에 추가
            res.append(abs(p1-p2))
        # 최소값을 가지고 있는 index를 가지고 옴
        min_p_idx = res.index(min(res))
        print(f"{t_lst[min_p_idx][0]} {t_lst[min_p_idx][1]}")
