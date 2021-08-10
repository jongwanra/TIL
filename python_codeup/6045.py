from sys import base_exec_prefix


a, b, c = map(int, input().split())
sum = a + b + c
avg = round(sum / 3, 3)
print(sum, format(avg, ".2f"))

