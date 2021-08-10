from collections import deque
def solution(progresses, speeds):
    answer = []
    queue = deque(progresses)
    speed_queue = deque(speeds)
    
    while len(queue) > 0:
        for idx in range(len(queue)):
            queue[idx] += speed_queue[idx]
        cnt = 0
        while len(queue) > 0 and queue[0] >= 100:
            cnt+= 1
            tmp = queue.popleft()
            tmp = speed_queue.popleft()
        if cnt > 0:
            answer.append(cnt)
    
    return answer