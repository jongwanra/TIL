# 타겟 넘버
# https://programmers.co.kr/learn/courses/30/lessons/43165
# 해결 / 21.12.15
'''
- 접근
처음 초기값을  0으로 설정한 후에  주어진 배열의 요소를  더할 경우, 뺄 경우를 다 구해서 타겟인 경우를 찾으면 되겠다.
'''
def solution(numbers, target):
    # 초기값은 0으로 설정
    arr = [[0]]
    arr_idx = 0
    answer = 0
    # 주어진 수들 만큼 반복
    for number in numbers: 
        tmp = []
        for arr_data in arr[arr_idx]:
            # 지금의 number값을 가지고 +, - 한 경우를 다 추가
            plus = arr_data + number
            minus = arr_data - number
            tmp.append(plus)
            tmp.append(minus)
        arr.append(tmp)
        arr_idx += 1
    
    return arr[-1].count(target)



# 그 전에 풀 타겟 넘버
def solution(numbers, target):
    q = [0]
    for n in numbers:
        s = []
        while q:
            tmp = q.pop()
            s.append(tmp + n)
            s.append(tmp + (-n))
        q = s.copy()
    return q.count(target)