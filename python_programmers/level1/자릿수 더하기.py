# 자릿수 더하기
# https://programmers.co.kr/learn/courses/30/lessons/12931
# 해결 / 3분 소요/ 21.12.20
def solution(n):
    return sum(list(map(int, list(str(n)))))