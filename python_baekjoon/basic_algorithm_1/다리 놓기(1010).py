# 다리 놓기(1010)
# https://www.acmicpc.net/problem/1010
# 해결 / 18분 소요 / 21.12.11(168ms)
'''
- 시간 제한 
0.5초 

파이썬 조합 공식
nCr =  n! / r!(n-r)!
'''
from math import factorial
for _ in range(int(input())):
    r, n = map(int, input().split())
    print(factorial(n) // (factorial(r) * factorial(n-r)))