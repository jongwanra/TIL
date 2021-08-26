# 택시 기하학(3053)
# https://www.acmicpc.net/problem/3053

import math
r = int(input())
# 유클리드 기하학(r^2 * 원주율)
print("{:.6f}".format(r** 2 * math.pi))
# 택시 기하학(r^2 * 2)
print("{:.6f}".format(r**2 * 2))