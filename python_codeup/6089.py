start, value, n = map(int, input().split())
for i in range(n-1):
    start = start * value
    
print(start)

