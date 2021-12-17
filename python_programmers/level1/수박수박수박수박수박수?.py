# 수박수박수박수박수박수?
# https://programmers.co.kr/learn/courses/30/lessons/12922
# 해결 / 2분 소요 / 21.12.15
def solution(n):
    answer = '수박' * (n // 2)
    if n % 2 == 1:
        answer += '수'
    return answer