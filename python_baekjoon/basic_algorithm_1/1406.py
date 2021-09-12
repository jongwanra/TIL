# 에디터(1406)
# https://www.acmicpc.net/problem/1406
# 못 품(2021. 09. 11) / 시간 초과 뜸 / 28분 50초
# 다음에 풀어볼 때, 더블 스택을 이용해서 풀어보자! 

'''
from sys import stdin
from collections import deque
if __name__ == "__main__":
    input = stdin.readline
    lst = deque(input().rstrip())
    N = int(input())
    cursor = len(lst)
    for _ in range(N):
        cmd = input().split()
        
        if cmd[0] == "P":
            lst.insert(cursor, cmd[1])
            cursor += 1
        elif cmd[0] == "L":
            if cursor == 0:
                continue
            cursor -= 1
        elif cmd[0] == "D":
            if cursor >= len(lst):
                continue
            cursor += 1
        elif cmd[0] == "B":
            if cursor == 0:
                continue
            del lst[cursor - 1]
            cursor -= 1
    print("".join(lst))
'''

# Solved!! (21.09.12) / 14:04
'''
from sys import stdin
from collections import deque
if __name__ == "__main__":
    input = stdin.readline
    lst_left = deque(input().rstrip())
    lst_right = deque()

    N = int(input())
    for _ in range(N):
        cmd = input().split()
        
        if cmd[0] == "P":
            lst_left.append(cmd[1])
        elif cmd[0] == "L":
            if len(lst_left) == 0:
                continue
            lst_right.appendleft(lst_left.pop())

        elif cmd[0] == "D":
            if len(lst_right) == 0:
                continue
            lst_left.append(lst_right.popleft())
        elif cmd[0] == "B":
            if len(lst_left) == 0:
                continue
            lst_left.pop()
        # print(f"left: {lst_left}, right: {lst_right}")
    print("".join(list(lst_left) + list(lst_right)))
'''