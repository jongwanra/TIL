# 터렛(1002)
# https://www.acmicpc.net/problem/1002
# 해결 / 30분 소요 / 21.12.07
from math import sqrt
# x1, y1, r1, x2, y2, r2
n = int(input())
for _ in range(n):
    x1, y1, r1, x2, y2, r2 = map(int, input().split())

    # 두 점 사이의 거리
    distance = sqrt(abs(x1 - x2) ** 2 + abs(y1 - y2) ** 2)
    # 두 반지름의 차
    diff = abs(r2 - r1)
    # 두 반지름의 합
    sum = abs(r1 + r2)

    # 동심원인 경우
    if x1 == x2 and y1 == y2 and r1 == r2:
        print(-1)
    # 한 점에서 만나는 경우(r + r' = distance)
    elif sum == distance or diff == distance:
        print(1)
    # 두 점에서 만나는 경우(r' - r < distance < r + r')
    elif diff < distance and sum > distance:
        print(2)
    # 접점이 없는 경우
    else:
        print(0)
