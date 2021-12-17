# 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 반환하기
from collections import deque

# 현재 값보다 중요도가 더 높은 요소가 있는지 확인
# 있으면 True 없으면 False
def checkPriority(cur_priority, print_info, queue):
    for q in queue:
        if print_info[q] > cur_priority:
            return True
    return False

def solution(priorities, location):
    queue = deque([])
    answer = 0
    answer_value = chr(ord('A') + location) # 알고 싶은 값
    print_info = {}
    for i in range(len(priorities)):
        key = chr(ord('A') + i)
        print_info[key] = priorities[i]
        queue.append(key)

    cnt = 0
    while queue:
        tmp = queue.popleft()
        tmp_priority = print_info[tmp]
        # 더 높은 중요도를 가진 요소가 있을 경우
        if checkPriority(tmp_priority, print_info, queue):
            queue.append(tmp)
            continue
        else:
            cnt += 1
            # 내가 찾던 요소가 나온 경우 
            if tmp == answer_value:
                break
    return cnt