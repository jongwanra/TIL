# 자연수 뒤집어 배열로 만들기
# https://programmers.co.kr/learn/courses/30/lessons/12932
# 해결 / 2분 이내 / 21.12.18

def solution(n):
    answer = []
    while n != 0:
        answer.append(n % 10)
        n = n // 10 
    
    return answer