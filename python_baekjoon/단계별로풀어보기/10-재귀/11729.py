# 하노이의 탑 이동 순서(11729)
# https://www.acmicpc.net/problem/11729


def hanoi(n, start, to, via, ans):
    # hanoi함수 호출 시 마다, 호출한 횟수 증가
    ans[0] += 1

    if n == 1:
        ans.append([start, to])
        return
    # 1.  n - 1개의 원반을 보조기둥으로 옮긴다.
    hanoi(n-1, start, via, to, ans)

    # 제일 큰 원반을 목표 기둥에 옮긴다.
    ans.append([start, to])

    # n-1개의 원반을 보조 기둥에서 목표기둥으로 옮긴다.
    hanoi(n-1, via, to, start, ans)


n = int(input())
ans = [0]  # ans[0] == 호출한 횟수
# 갯수, 시작, 끝, 중간, 답
hanoi(n, 1, 3, 2, ans)

print(ans[0])
for i in range(1, len(ans)):
    print(ans[i][0], ans[i][1])
