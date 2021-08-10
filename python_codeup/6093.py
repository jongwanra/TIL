answer = [0] * 23
n = int(input())
t_lst = list(map(int, input().split()))
t_lst.reverse()
for i in t_lst:
    print(i, end=" ")
