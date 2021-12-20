# 음양 더하기
# https://programmers.co.kr/learn/courses/30/lessons/76501
# 해결 / 3분 소요 / 21.12.20
'''
직관적으로 접근하자.
한 번의 포문을통해 초기화 시킨 sum에 추가하면 되겠다.
'''
def solution(absolutes, signs):
    sum = 0
    for i in range(len(signs)):
        if signs[i]:
            sum += absolutes[i]
        else:
            sum += -absolutes[i]
    return sum