# 스택 수열(1874)
# https://www.acmicpc.net/problem/1874
# 해결 / 22분 / 21.12.08
from sys import stdin
input = stdin.readline

n = int(input())
stack = []
answer = []
cnt = 1
for _ in range(n):
    num = int(input())
    # stack에 그 수가 찰 때까지 넣어준다.
    while cnt <= num:
        stack.append(cnt)
        answer.append('+')
        cnt += 1
    # stack에 제일 위에 있는 수가 입력받은 수와 같을 경우에는 pop
    if stack[-1] == num:
        stack.pop()
        answer.append('-')
    # 그렇지 않은 경우에는 스택으로 구성할 수 없다고 간주
    else:
        print('NO')
        exit()

for data in answer:
    print(data)


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
        