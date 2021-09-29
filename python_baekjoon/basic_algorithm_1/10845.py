# 큐(10845)
# https://www.acmicpc.net/problem/10845
# Solved(21.09.12) / 08:40

from collections import deque
from sys import stdin
if __name__ == "__main__":
    input = stdin.readline
    queue = deque()
    size = 0
    N = int(input())
    for _ in range(N):
        cmd  = input().split()
        if cmd[0] == "push":
            queue.append(cmd[1])
            size += 1
        elif cmd[0] == "pop":
            if size == 0:
                print(-1)
                continue
            print(queue.popleft())
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
                print(queue[len(queue) - 1])
        