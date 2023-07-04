# [3차] n진수 게임
# https://school.programmers.co.kr/learn/courses/30/lessons/17687


# n: 진법
# t: 미리 구할 숫자의 갯수
# m: 게임 참가 인원
# p: 튜브의 순서


# 해결 방법
# 미리 구할 숫자의 최대 갯수(1000) * 멤버 최대 인원(100) = 100,000개
# 총 10만개의 데이터가 최대이다.
# 진법으로 우선 t * m의 갯수만큼 넘버들을 구한다.
# 그 이후에 일정 반복 나머지로 result를 뽑는다

dic = {
    10: 'A',
    11: 'B',
    12: 'C',
    13: 'D',
    14: 'E',
    15: 'F'
}

def convert(num, n):
    result = ""

    while num > 0:
        a = num % n
        if a >= 10:
            result += dic[a]
        else:
            result += str(a)
        num = num // n
    return result[::-1]

def solution(n, t, m, p):
    maxSize = t * m
    numString = "01"
    answer = ''

    i = 2
    while len(numString) < maxSize:
        numString = numString + convert(i, n)
        i += 1

    for tt in range(0, t):
        startRoundIdx = tt * m
        answer += numString[startRoundIdx + p - 1]

    return answer