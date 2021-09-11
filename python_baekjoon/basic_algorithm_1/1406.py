# 에디터(1406)
# https://www.acmicpc.net/problem/1406
# 못 품(2021. 09. 11) / 시간 초과 뜸 / 28분 50초
# 다음에 풀어볼 때, 더블 스택을 이용해서 풀어보자! 
# 링크드리스트로도 풀어보자!


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

        