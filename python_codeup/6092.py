answer = [0] * 23
n = int(input())
t_lst = list(map(int, input().split()))
for t in t_lst:
    answer[t-1] += 1

for a in answer:
    print(a, end=" ")
