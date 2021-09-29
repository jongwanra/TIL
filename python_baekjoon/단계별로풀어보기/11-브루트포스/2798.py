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
