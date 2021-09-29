# 큐 2(18258)
# https://www.acmicpc.net/problem/18258

from sys import stdin
from collections import deque

def back(queue):
    if len(queue) == 0:
            print(-1)
    else:
        print(queue[len(queue) - 1])

def front(queue):
    if len(queue) == 0:
            print(-1)
    else:
        print(queue[0])

def empty(queue):
    if len(queue) == 0:
        print(1)
    else:
        print(0)

def pop(queue):
    if len(queue) == 0:
            print(-1)
    else:
        print(queue.popleft())

n = int(stdin.readline())
queue = deque()
for _ in range(n):
    cmd = stdin.readline().split()
    
    if cmd[0] == "push":
        queue.append(cmd[1])
        
    elif cmd[0] == "pop":
        pop(queue)
        
    elif cmd[0] == "front":
        front(queue)
        
    elif cmd[0] == "back":
        back(queue)
        
    elif cmd[0] == "size":
        print(len(queue))
        
    elif cmd[0] == "empty":
        empty(queue)