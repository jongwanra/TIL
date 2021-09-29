# 스택 수열(1874)
# https://www.acmicpc.net/problem/1874
# 품(21.09.10) / 17분 30초

from sys import stdin
if __name__ == '__main__':
    input = stdin.readline
    res = []
    num = 1
    stack = []
    N = int(input())
    for _ in range(N):
        data = int(input())
        
        while num <= data:
            stack.append(num)
            res.append("+")
            num += 1
        
        if stack[-1] == data:
            stack.pop()
            res.append("-")
            
        elif stack[-1] != data:
            print("NO")
            exit()

    for r in res:
        print(r)
        