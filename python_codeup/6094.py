n = int(input())
t_lst = list(map(int, input().split()))
min = t_lst[0]
for t in t_lst:
    if min > t:
        min = t
print(min)
