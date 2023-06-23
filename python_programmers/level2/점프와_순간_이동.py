# 점프: 점프시 건전지 사용량 N
# 순간이동 (현재까지 온 거리) * 2
def failedSolution(n):
    ans = 0
    energy = 1
    currentDistance = 1

    while n % 2 == 0:
        n = n // 2

    # print('n::', n)
    while currentDistance < n:
        # print(currentDistance)
        if currentDistance * 2 <= n:
            currentDistance = currentDistance * 2
        else:
            energy += 1
            currentDistance += 1

    return energy



# Other Solution
def solution(n):
    energy = 0
    while n > 0:
        if n % 2 == 0:
            n = n // 2
        else:
            energy += 1
            n -= 1
    return energy



# 이 문제를 왜 못풀었나?

# 곱셈으로 해결하려는 관점으로 밖에 생각 하지 못한 내 미스다
# 반대로 나눠서 가면 된다고 왜 생각 못했는지 