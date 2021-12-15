# 모의고사
# https://programmers.co.kr/learn/courses/30/lessons/42840
# 해결 / 30분 초과 / 21.12.15
'''
person1 ~ 3까지 문제를 맞춘 갯수를 구해야 한다.
1, 2, 3 번 사람의 패턴의 길이를 최소 공배수를 통해서 맞추고, 갯수를 세서 리스트에 저장하자.

- 30분 초과한 이유
처음에 잘못 접근했다.. 최소 공배수로 접근해서 카운팅을 하는 것이 아니라, answer의 길이 만큼 줘서 비교해야 했다.
문제를 잘못 이해한 것이 30분 초과한 원인이다.
'''

from collections import deque
def solution(answers):
    person1 = deque([1,2,3,4,5])
    person2 = deque([2,1,2,3,2,4,2,5])
    person3 = deque([3,3,1,1,2,2,4,4,5,5])
    answers = deque(answers)
    
    cnt1, cnt2, cnt3 = 0, 0, 0
    while answers:
        ans = answers.popleft()
        p1 = person1.popleft()
        p2 = person2.popleft()
        p3 = person3.popleft()
        
        if p1 == ans:
            cnt1 += 1
        if p2 == ans:
            cnt2 += 1
        if p3 == ans:
            cnt3 += 1
        
        person1.append(p1)
        person2.append(p2)
        person3.append(p3)
        
    list = [[1, cnt1], [2, cnt2], [3, cnt3]]
    list.sort(key=lambda x: x[1], reverse=True)
    
    # 내림차순 정렬 후, 처음 인덱스 요소가 제일 클 경우
    if list[0][1] != list[1][1]:
        return [list[0][0]]
    else:
        # 3명다 같은 점수인 경우
        if list[1][1] == list[2][1]:
            return [1, 2, 3]
        else:
            return [list[0][0], list[1][0]]
            

# ------------------------------------------------

def solution(answers):    
    p1 = [1,2,3,4,5]
    p1_i, p1_cnt, p1_size = 0, 0, 5
    p2 = [2,1,2,3,2,4,2,5]
    p2_i, p2_cnt, p2_size = 0, 0, 8
    p3 = [3,3,1,1,2,2,4,4,5,5]
    p3_i, p3_cnt, p3_size = 0, 0, 10
    
    for ans in answers:
        # 정답 범위를 초과했을 경우
        if p1_i >= p1_size:
            p1_i = 0
        if p2_i >= p2_size:
            p2_i = 0
        if p3_i >= p3_size:
            p3_i = 0
        
        if p1[p1_i] == ans:
            p1_cnt += 1
        if p2[p2_i] == ans:
            p2_cnt += 1
        if p3[p3_i] == ans:
            p3_cnt += 1
        p1_i += 1
        p2_i += 1
        p3_i += 1
    print(f"p1: {p1_cnt}")
    print(f"p2: {p2_cnt}")
    print(f"p3: {p3_cnt}")
    
    dic = {
        1: p1_cnt,
        2: p2_cnt,
        3: p3_cnt
    }
    if dic[1] == dic[2] and dic[2] == dic[3]:
        return [1,2,3]
    elif dic[1] == dic[2] and dic[2] != dic[3]:
        if dic[2] > dic[3]:
            return [1,2]
        else:
            return [3]
    elif dic[1] == dic[3] and dic[3] != dic[2]:
        if dic[2] > dic[3]:
            return [2]
        else:
            return [1,3]
        
    elif dic[2] == dic[3] and dic[2] != dic[1]:
        if dic[2] > dic[1]:
            return [2, 3]
        else:
            return [1]
    else:
        max_tmp = max(dic[1], dic[2], dic[3])
        if dic[1] == max_tmp:
            return [1]
        elif dic[2] == max_tmp:
            return [2]
        else:
            return [3]