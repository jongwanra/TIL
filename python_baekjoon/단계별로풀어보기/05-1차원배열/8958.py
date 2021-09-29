# OX퀴즈(8958)
# https://www.acmicpc.net/problem/8958

n = int(input())

for _ in range(n):
    s = input()
    cnt = 0
    res = 0
    for quiz in s:
        if quiz == 'X':
            cnt = 0
        else:
           cnt += 1
           res += cnt
    print(res) 
