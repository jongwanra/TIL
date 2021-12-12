# 동전 0(11047)
# https://www.acmicpc.net/problem/11047
# 해결 / 10분 소요 / 21.12.13

'''
stack 자료구조를 이용해서 하나씩 pop() 하면서, 
몫이 존재할 경우 빼는 방식! 
'''
from sys import stdin
coins = []
n, k = map(int, stdin.readline().rstrip().split())

# 코인들을 추가(stack)
for _ in range(n):
    coins.append(int(stdin.readline().rstrip()))
res = 0
# 코인들을 빼면서 몫이 존재할 경우 빼기
while k > 0:
    target = coins.pop()
    divider = k // target
    if divider >= 1:
        k -= (target * divider)
        res += divider     
print(res) 