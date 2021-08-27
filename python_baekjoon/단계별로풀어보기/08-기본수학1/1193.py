# 분수찾기(1193)
# https://www.acmicpc.net/problem/1193


'''
01 02 06 07 15 16 28 29 ...
03 05 08 14 17 27
04 09 13 18 26
10 12 19 25
11 20 24
21 23
22
'''

n = int(input())
i = 1

while True:
    n -= i
    if n <= 0:
        if i % 2 == 1:
            print(f"{abs(n) + 1}/{i + n}")
        else:
            print(f"{i + n}/{abs(n) + 1}")
        break
    i += 1
