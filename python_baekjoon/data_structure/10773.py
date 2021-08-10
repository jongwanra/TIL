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