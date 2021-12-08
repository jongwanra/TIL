# 스택(10828)
# https://www.acmicpc.net/problem/10828
# 해결 / 13분 소요 / 21.12.08

from sys import stdin
stack = []
n = int(input())

for _ in range(n):
    cmd = stdin.readline.rstrip().split()
    if cmd[0] == 'push':
        stack.append(cmd[1])
    elif cmd[0] == 'pop':
        print(-1) if len(stack) == 0 else print(stack.pop())
    elif cmd[0] == 'size':
        print(len(stack))
    elif cmd[0] == 'empty':
        print(1) if len(stack) == 0 else print(0)
    elif cmd[0] == 'top':
        print(-1) if len(stack) == 0 else print(stack[len(stack) - 1])



# 스택(10828)
# https://www.acmicpc.net/problem/10828
# 품(21.09.10) / 5분 이내
from sys import stdin

if __name__ == "__main__":
    input = stdin.readline    
    n = int(input())
    stack = []
    for _ in range(n):
        datas = input().split()
        print(f"datas: {datas}")
        if datas[0] == "push":
            stack.append(datas[1])
        elif datas[0] == "top":
            if len(stack) == 0:
                print(-1)
            else:
                print(stack[len(stack) - 1])
        elif datas[0] == "size":
            print(len(stack))
        elif datas[0] == "empty":
            if len(stack) >= 1:
                print(0)
            else:
                print(1)
        elif datas[0] == "pop":
            if len(stack) == 0:
                print(-1)
            else:
                print(stack.pop())