# 나머지(3052)
# https://www.acmicpc.net/problem/3052

dic = {}
for _ in range(10):
    n = int(input())
    try:
        dic[n % 42] += 1
    except:
        dic[n % 42] = 1
print(len(dic))