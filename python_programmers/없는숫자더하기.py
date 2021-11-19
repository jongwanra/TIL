# [211119] 없는 숫자 더하기
# 5분 소요

def solution(numbers):
    total = 45
    for n in numbers:
        total -= n
    return total