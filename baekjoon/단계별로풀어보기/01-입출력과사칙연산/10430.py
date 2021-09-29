# 나머지(10430)
# https://www.acmicpc.net/problem/10430

a, b, c = list(map(int, input().split()))

print((a+b)%c, ((a%c)+(b%c))%c, (a*b)%c, ((a%c)*(b%c))%c, sep="\n")