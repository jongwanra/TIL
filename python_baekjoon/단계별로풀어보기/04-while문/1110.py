# 더하기 사이클(1110)
# https://www.acmicpc.net/problem/1110

'''
26 
1) 2 + 6 = 8  -> 68
2) 6+ 8 = 14 -> 84
3) 8 + 4 = 12 -> 42
4) 4 + 2 = 6 -> 26
'''

n = int(input())

# n이 10보다 작을 경우 
if n < 10:
    n *= 10

res = -1
cnt = 0
tmp = n
while res != n:
    front = tmp // 10
    back = tmp % 10

    tmp = (back *10) + (front + back) % 10
    res = tmp
    cnt += 1

print(cnt)