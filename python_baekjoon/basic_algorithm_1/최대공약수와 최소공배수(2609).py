# 최대공약수와 최소공배수(2609)
# https://www.acmicpc.net/problem/2609
# 해결 / 5분 소요/ 21.12.10

from math import gcd

x, y = map(int, input().split())
gcd = gcd(x, y)
print(gcd)
print(x * y//gcd)
