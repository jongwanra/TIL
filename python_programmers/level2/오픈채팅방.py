# 오픈채팅방
# https://programmers.co.kr/learn/courses/30/lessons/42888
# 해결 / 20분 소요 / 21.12.11

from collections import deque
def solution(records):
    answer = []
    user_info = {}
    queue = deque()
    for record in records:
        list_record = record.split()
        # 들어왔을 경우
        if list_record[0] == 'Enter':
            user_info[list_record[1]] = list_record[2]
            queue.append(['Enter', list_record[1]])
        # 나갔을 경우
        elif list_record[0] == 'Leave':
            queue.append(['Leave', list_record[1]])
        # 이름 변경
        else: 
            user_info[list_record[1]] = list_record[2]
    while queue:
        tmp = queue.popleft()
        if tmp[0] == 'Enter':
            answer.append(f"{user_info[tmp[1]]}님이 들어왔습니다.")
        elif tmp[0] == 'Leave':
            answer.append(f"{user_info[tmp[1]]}님이 나갔습니다.")
    return answer