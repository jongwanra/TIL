# 카펫
# https://school.programmers.co.kr/learn/courses/30/lessons/42842

# 접근 방법
# brown = (yellow's 세로 * 2) + (yellow's 가로 * 2) + 4의 공식을 만족하면?! 풀수 있지 않을까

import math

def solution(brown, yellow):
    # x = yellow's 가로 +  yellow's 세로
    x = math.floor((brown - 4) / 2)

    # 전체 가로와 전체 세로의 케이스 찾기
    for i in range(1, x):
        # 전체 가로 = yellow's 가로 + 2
        tempWidth = i + 2
        # 전체 세로 = yellow's 세로 + 2
        tempHeight = x - i + 2

        # print("tempWidth:", tempWidth, "tempHeight:", tempHeight)
        if tempWidth * tempHeight == brown + yellow:
            return [max(tempWidth, tempHeight), min(tempWidth, tempHeight)]

