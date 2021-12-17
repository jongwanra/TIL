# 위장
# https://programmers.co.kr/learn/courses/30/lessons/42578
# 미해결 / 30분 초과 / 21.12.17
# 
'''
1개만 고를 경우
2개만 고를 경우
.
.

n개 고를 경우를 생각해야 한다.

우선 사전형으로 종류별 갯수를 생각하자.

구현력 부족 ㅠㅠ 경우의 수 문제인데 어떻게 접근했어야 했을까 .
'''
from math import factorial
from itertools import combinations
def solution(clothes):
    answer = 0
    dic = {}
    for cloth in clothes:
        try:
            dic[cloth[1]] += 1
        except:
            dic[cloth[1]] = 1
            
    # 하나씩만 입는 경우
    answer += len(clothes)
    i = 2
    while i <= len(dic):
        result = list(combinations(dic, i))
        for r in result:
            answer += (dic[r[0]] * dic[r[1]])
        # print(f"i: {i}, {result}")
        # 종류의 갯수 중 i개를 고르기 * (종류의 갯수 a, b, c.. )
        i += 1
    return answer