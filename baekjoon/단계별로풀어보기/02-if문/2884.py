# 알람 시계(2884)
# https://www.acmicpc.net/problem/2884

h, m = list(map(int, input().split()))

total = (h * 60) + m - 45 
print(total//60%24, total%60)

# m -= 45
# if m >= 0:
#     print(h, m)
# else:
#     m += 60
#     h -= 1
#     if h < 0:
#         h = 23
#     print(h, m)