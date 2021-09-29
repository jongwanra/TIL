# 소인수분해(11653)
# https://www.acmicpc.net/problem/11653

n = int(input())
res = []

while n > 1:
    i = 2
    while True:
        if n % i == 0:
            res.append(i)
            n //= i
            break
        i += 1

for r in res:
    print(r)
