# 작업(2056)
# https://www.acmicpc.net/problem/2056
# 못품(21.09.09)

# from sys import stdin
# from collections import deque

# def topology_sort():
#     result = []
#     q = deque()

#     for i in range(1, N + 1):
#         if indegree[i] == 0:
#             q.append(i)
#     while q:
#         now = q.popleft()
#         # 동시에 작업을 실행할 경우
#         if len(q) >= 1:
#             for idx in q:
#                 time[idx] = time[idx] - time[now] 
#                 if time[idx] < 0:
#                     time[idx] = 0                    
#         result.append(time[now])
        
#         for i in graph[now]:
#             indegree[i] -= 1
            
#             if indegree[i] == 0:
#                 q.append(i)
#     return result

# if __name__ == '__main__':
#     input = stdin.readline
#     N = int(input())
#     res = 0
#     indegree = [0] * (N + 1)
#     graph = [[] for _ in range(N + 1)]
#     time = [0] * (N + 1)

#     for i in range(1, N + 1):
#         # 걸리는 시간, 선행 작업들 개수, 선행 관계에 있는 작업들 번호        
#         lst = list(map(int, input().split()))
#         time[i] = lst[0]
#         if lst[1] >= 1:
#             # 진입 차수 만들기
#             indegree[i] += lst[1]
#             tmps = lst[2:]
#             for tmp in tmps:
#                 # 그래프 만들기(목적지와, 걸리는 시간) 
#                 graph[tmp].append(i)
#     print(sum(topology_sort()))

import sys
input = sys.stdin.readline

if __name__ == '__main__':
    N = int(input())
    costs = [0]*(N+1)

    for i in range(1, N+1):
        cur_input = list(map(int, input().split()))

        prev_max_time = 0
        for j in range(2, 2 + cur_input[1]):
            prev_max_time = max(prev_max_time, costs[cur_input[j]])

        costs[i] = prev_max_time + cur_input[0]

    print(max(costs))