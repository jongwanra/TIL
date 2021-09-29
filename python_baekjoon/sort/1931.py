# 회의실 배정(1931)
# https://www.acmicpc.net/problem/1931

from sys import stdin

n = int(input())

meeting = []
for _ in range(n):
    start, end = list(map(int, stdin.readline().split()))
    meeting.append([start, end])

# 시작 시간을 기준으로 정렬 후 끝 시간을 기준으로 한번 더 정렬을 한다.
meeting.sort(key=lambda x: x[0])
meeting.sort(key=lambda x: x[1])

# 최댓값 출력을 위한 res
res = 0
final_time = 0
for start, end in meeting:
    if start >= final_time:
        final_time = end
        res += 1

print(res)