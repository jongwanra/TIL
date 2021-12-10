# 요세푸스 문제 0(10866)
# https://www.acmicpc.net/problem/10866
# 해결 / 15분 / 21.12.10
from collections import deque
from sys import stdin

# 출력 형식에 맞게 출력
def printAnswer(answer):
    print("<", end="")        
    for i in range(len(answer)): 
        if len(answer) - 1 == i:
            print(f"{answer[i]}>")         
        else:
            print(f"{answer[i]},", end=" ")
    
n, k = map(int, stdin.readline().rstrip().split())
queue = deque([i for i in range(1, n+1)])
answer = []

# queue안에 존재하는 동안
while queue:
    # k번 돌리고, k번째에서 answer에 넣어준다.
    for i in range(1, k + 1):
        if i == k:
            answer.append(queue.popleft())
        else:
            queue.append(queue.popleft())
printAnswer(answer)
exit()

# 요세푸스 문제 0(10866)
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