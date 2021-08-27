# Fly me to the Alpha Centauri(1011)
# https://www.acmicpc.net/problem/1011

# 못품(21.08.23)
# 1 시간 넘게 걸림(21.08.25)

'''
규칙을 찾아야 했던 문제.
d-> 거리 , cnt -> 최소 이동 횟수
d = 1, cnt = 1
d = 2, cnt = 2
d = 3, cnt = 3
d = 4, cnt = 3
d = 5, cnt = 4
d = 6, cnt = 4
d = 7, cnt = 5
d = 8, cnt = 5
d = 9, cnt = 5
d = 10, cnt = 6
d = 11, cnt = 6
d = 12, cnt = 6
d = 13, cnt = 7
d = 14, cnt = 7
d = 15, cnt = 7
d = 16, cnt = 7
d = 17, cnt = 8
.
.
.
--------------------------
cnt += 1 -> dis += 1
cnt += 1 -> dis += 1
cnt += 1 -> dis += 2
cnt += 1 -> dis += 2
cnt += 1 -> dis += 3
cnt += 1 -> dis += 3
cnt += 1 -> dis += 4
cnt += 1 -> dis += 4
.
.
.

'''
n = int(input())

for _ in range(n):
    start, end = map(int, input().split())
    distance = end - start

    dis = 0
    count = 0
    hana = 1

    while dis < distance:
        # 2번 반복해줌
        for _ in range(2):
            before_dis = dis
            count += 1
            dis += hana
            if distance <= dis and distance > before_dis:
                print(count)
        hana += 1
