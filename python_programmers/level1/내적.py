# 내적
# https://programmers.co.kr/learn/courses/30/lessons/70128
# 해결 / 3분 이내 / 21.12.20
def solution(a, b):
    answer = 0
    for i in range(len(a)):
        answer += (a[i] * b[i])
    return answer