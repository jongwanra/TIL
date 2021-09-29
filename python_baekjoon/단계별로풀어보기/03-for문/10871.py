# X보다 작은 수(10871)
# https://www.acmicpc.net/problem/10871


n, x = list(map(int, input().split()))
lst = list(map(int, input().split()))

for i, e in enumerate(lst):
    if e < x:
        print(i, e)