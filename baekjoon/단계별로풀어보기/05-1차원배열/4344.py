# 평균은 넘겠지(4344)
# https://www.acmicpc.net/problem/4344

n = int(input())

for _ in range(n):
    lst = list(map(int, input().split()))
    stu_num = lst[0]
    lst = lst[1:]
    
    avg = sum(lst) / stu_num
    
    cnt = 0
    for score in lst:
        if avg < score:
            cnt += 1
    print("{:.3f}%".format(cnt/stu_num * 100))
    
