# 제로(10773)
# https://www.acmicpc.net/problem/10773
# 해결 / 4분 30초 / 21.12.08
from sys import stdin
input = stdin.readline

n = int(input())
stack = []
for _ in range(n):
    tmp = int(input())
    stack.pop() if tmp == 0 else stack.append(tmp)
print(sum(stack))



# 제로(10773)
# https://www.acmicpc.net/problem/10773

# 스택을 이용한 풀이
stack = []
n = int(input())

for _ in range(n):
    tmp = int(input())
    if tmp == 0:
        stack.pop()
    else:
        stack.append(tmp)

sum = 0
for data in stack:
    sum += data
print(sum)