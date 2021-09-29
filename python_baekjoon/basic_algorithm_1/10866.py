# 덱(10866)
# https://www.acmicpc.net/problem/10866
# Solved(21.09.13) / 09:10

from collections import deque
from sys import stdin
if __name__ == "__main__":
    input = stdin.readline
    queue = deque()
    N = int(input())
    size = 0
    for _ in range(N):
        cmd = list(input().split())
        if cmd[0] == "push_front":
            queue.appendleft(cmd[1])
            size +=1
        elif cmd[0] == "push_back":
            queue.append(cmd[1])
            size += 1
        elif cmd[0] == "pop_front":
            if size == 0:
                print(-1)
            else:
                print(queue.popleft())
                size -= 1
        elif cmd[0] == "pop_back":
            if size == 0:
                print(-1)
            else:
                print(queue.pop())
                size -= 1
        elif cmd[0] == "size":
            print(size)
        elif cmd[0] == "empty":
            if size == 0:
                print(1)
            else:
                print(0)
        elif cmd[0] == "front":
            if size == 0:
                print(-1)
            else:
                print(queue[0])
        elif cmd[0] == "back":
            if size == 0:
                print(-1)
            else:
                print(queue[size - 1])