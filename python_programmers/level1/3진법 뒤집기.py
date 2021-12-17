# 3진법 뒤집기
# https://programmers.co.kr/learn/courses/30/lessons/68935
# 해결 / 13분 소요 / 21.12.17

# 3진법으로 바꾸고 뒤집혀서 반환되는 함수
def convertThird(n):
    result = ''
    while n >= 3:
        result += str(n % 3)
        n = n // 3
    result += str(n)
    return result

# 10진법으로 변환하는 함수
def convertTen(n):
    i = 0
    ten = 0
    while n != 0:
        ten += (n % 10) * (3 ** i)
        n = n // 10
        i += 1
    return ten

def solution(n):
    answer = int(convertThird(n))
    return convertTen(answer)