# A+B - 4(10951)
# https://www.acmicpc.net/problem/10951

from sys import stdin

s = stdin.readlines()

while len(s) > 0:
    a, b = map(int, s.pop(0).rstrip().split())
    print(a + b)
    
    