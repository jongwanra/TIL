# 정수 제곱근 판별
# https://programmers.co.kr/learn/courses/30/lessons/12934
# 해결 / 20분 소요 / 21.12.20
from math import sqrt
def checkSqrt(n):
    n1 = int(sqrt(n))
    n2 = n1 ** 2 
    if n2 == float(n):
        return (int(n1) + 1) ** 2
    return -1
    
def solution(n):
    return checkSqrt(n)