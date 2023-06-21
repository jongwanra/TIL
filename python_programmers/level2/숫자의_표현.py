import math

# 규칙이 안찾아진다..
# 적어도 반까지만 돌면 숫자가 다 들어와 진다고 판단 + 1

def solution(n):
    list = [i for i in range(1, math.ceil(n / 2) + 1)]
    answer = 1
    startIndex = 0
    endIndex = 0
    length = len(list) - 1
    sum = 1
    # print(list, len(list) - 1)
    while endIndex < length:
        # print("start:", startIndex, "end:", endIndex, "sum:", sum)
        # 합이 n보다 커지면 startIndex++
        # 합이 n보다 작으면 endIndex++
        # 합이 같으면 startIndex++
        if sum == n:
            answer += 1
            sum -= list[startIndex]
            startIndex += 1

        elif sum < n:
            endIndex += 1
            sum += list[endIndex]

        else:
            sum -= list[startIndex]
            startIndex += 1

    while startIndex < length:
        if sum == n:
            answer += 1
        sum -= list[startIndex]
        startIndex += 1
    return answer
