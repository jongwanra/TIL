# 1로 만들기(217p)
# 못품(21.08.16)
# 품(21.08.18)

n = int(input())

d = [0] * 30001

# initializing
d[2] = 1

for i in range(3, n+1):
    # case: minus 1
    d[i] = d[i - 1] + 1
    
    # case: % 5
    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5]+ 1)
    # case: % 3
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3]+ 1)
    # case: % 2
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2]+ 1)

print(d[n])
