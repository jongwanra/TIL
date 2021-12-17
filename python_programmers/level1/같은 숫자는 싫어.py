# 같은 숫자는 싫어
# https://programmers.co.kr/learn/courses/30/lessons/12906
# 해결 / 4분 소요 / 21.12.15

'''
스택을 이용해서 접근하자.
연속적인 경우를 판단해서 연속적일 때는 무시하고, 그렇지 않은 경우에는 집어넣자.
'''

def solution(arr):
    stack = []
    for data in arr:
        # 스택이 빈 경우
        if stack == []:
            stack.append(data)
        # 연속 같은 데이터인 경우 패스
        elif stack[-1] == data:
            continue
        else:
            stack.append(data)        
        
    return stack