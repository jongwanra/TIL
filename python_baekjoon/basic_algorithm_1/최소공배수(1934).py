# 최소공배수(1934)
# https://www.acmicpc.net/problem/1934
# 해결 / 5분 / 21.12.10
'''
- 접근 방법 1
파이썬 모듈 사용

'''

from math import gcd 

for i in range(int(input())):
    n1, n2 = map(int, input().split())
    print(n1 * n2 // gcd(n1, n2))

'''
- 접근 방법2
유클리드 호제법으로 접근

x와 y의 최대공약수는 (x를 y로 나눈 나머지)와 y의 최대공약수와 같다.
'''

def gcd(x, y):
    while y != 0:
        x, y = y, x % y
    return x

for i in range(int(input())):
    n1, n2 = map(int, input().split())
    print(n1 * n2 //gcd(n1, n2))
    
