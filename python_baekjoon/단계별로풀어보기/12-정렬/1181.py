# 단어 정렬(1181)
# https://www.acmicpc.net/problem/1181


# 방법 1
'''
from sys import stdin

datas = [[] for _ in range(51)]

n = int(input())
for _ in range(n):
    tmp = stdin.readline().rstrip()
    s_size = len(tmp)
    try:
        a = datas[s_size].index(tmp)
    except:
        datas[s_size].append(tmp)

for i in range(51):
    data_size = len(datas[i])
    if data_size == 0:
        continue

    if data_size == 1:
        print(datas[i][0])
    else:
        datas[i].sort()
        for j in range(0, data_size):
            print(datas[i][j])
'''

# 방법 2

'''
from sys import stdin

num = int(input())
arr = []

for _ in range(num):
    arr.append(stdin.readline().rstrip())

arr = list(set(arr)) # set을 이용해서 중복 제거
arr.sort() # 사전 순 정렬
arr.sort(key=len) # 길이 순 정렬

for word in arr:
    print(word)
'''