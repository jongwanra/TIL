# 두 정수 사이의 합
# https://programmers.co.kr/learn/courses/30/lessons/12912
# 해결 / 15분 소요 / 21.12.19
'''
-10,000,000 <= a, b <= 10,000,000
'''
def solution(a, b):
    answer = 0
    if(a == b):
        return a
    if (a > b):
        a, b = b, a
    for i in range(a, b+1):
            answer += i
        
    return answer