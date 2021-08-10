lst = list(map(int, input().split()))

num = 2
while True:
    cnt = 0
    for i in lst:
        if num % i == 0:
            cnt += 1
    if cnt == 3:
        print(num)
        break
    num += 1

