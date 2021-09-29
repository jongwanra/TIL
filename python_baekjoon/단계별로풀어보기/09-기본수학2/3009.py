# 네 번째 점(3009)
# https://www.acmicpc.net/problem/3009

x_lst = []
y_lst = []
for _ in range(3):
    x, y = map(int, input().split())
    x_lst.append(x)
    y_lst.append(y)

for e in set(x_lst):
    if x_lst.count(e) == 1:
        print(e, end=" ")

for e in set(y_lst):
    if y_lst.count(e) == 1:
        print(e)
