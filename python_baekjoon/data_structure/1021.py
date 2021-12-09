# 회전하는 큐(1021)
# https://www.acmicpc.net/problem/1021
# 해결 / 18분 소요 / 21.12.09

from sys import stdin
from collections import deque
n, m = map(int, stdin.readline().rstrip().split())
datas = list(map(int, stdin.readline().rstrip().split()))
queue = deque([i for i in range(1, n + 1)])
min_cnt = 0
for i in range(m):
    mid = len(queue) // 2;
    data = datas[i]
    data_index = queue.index(data)
    
    # 중간 지점 보다 왼쪽에 있을 경우(2번의 연산 수행)
    if  mid >= data_index:
        while True:
            if queue[0] == data:
                queue.popleft()
                break
            else:
                tmp = queue.popleft()
                queue.append(tmp)
                min_cnt += 1
    # 중간 지점 보다 오른쪽에 있을 경우(3번의 연산 수행)
    else:
        while True:
            if queue[0] == data:
                queue.popleft()
                break
            else:
                tmp = queue.pop()
                queue.appendleft(tmp)
                min_cnt += 1
print(min_cnt)
    

    