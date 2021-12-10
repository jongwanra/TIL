# 블랙잭(2798)
# https://www.acmicpc.net/problem/2798
# 해결 / 20분 소요 / 21.12.10
'''
접근 방법 1:
내림차순 정렬 후에 작은 카드를 한장 씩 바꾸는 순으로 해서 3장을 가져가기

접근 방법 2:
접근 방법 1로는 정확하게 접근하기 어려웠다.
m 보다 크거나 같은 수들의 경우 따로 max라는 변수에 비교 후 기존 값보다 큰 경우 집어 넣어줬다.

'''

from sys import stdin
from itertools import permutations

n, m = map(int, stdin.readline().rstrip().split())
nums = list(map(int, stdin.readline().rstrip().split()))
answer = []
max = -1 

for datas in list(permutations(nums, 3)):
    if sum(datas) > m:
        continue
    else:
        tmp = sum(datas)
        if max < tmp:
            max = tmp

print(max)
exit()


# 블랙잭(2798)
# https://www.acmicpc.net/problem/2798

def find_num(cards):
    max_num = -1
    for i in range(0, len(cards)):
        for j in range(i+1, len(cards)):
            for k in range(j+1, len(cards)):
                tmp = cards[i] + cards[j] + cards[k]
                if tmp <= call_num:
                    if max_num < tmp:
                        max_num = tmp
    return max_num


# n장의 카드, 딜러가 부른 숫자
card_num, call_num = map(int, input().split())
cards = list(map(int, input().split()))
print(find_num(cards))
