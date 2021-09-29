# 최댓값(2562)
# https://www.acmicpc.net/problem/2562

lst = []
for _ in range(9):
    lst.append(int(input()))

max_num = max(lst)
print(max_num)
print(lst.index(max_num) + 1) 
