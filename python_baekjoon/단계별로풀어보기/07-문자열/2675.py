# 문자열 반복(2675)
# https://www.acmicpc.net/problem/2675

n = int(input())
for _ in range(n):
    num, words = input().split()
    num = int(num)
    for word in words:
        print(word * num, end="")
    print()