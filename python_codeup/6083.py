r, g, b = map(int, input().split())
cnt = 0
for c1 in range(r):
    for c2 in range(g):
        for c3 in range(b):
            print(c1, c2, c3)
            cnt += 1
print(cnt)
