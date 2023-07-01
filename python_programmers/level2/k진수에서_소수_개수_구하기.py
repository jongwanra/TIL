
# 이 문제는 '구현' 문제였다.
# 소수를 구할 때 isPrimeNum Function은 외워두는 것도 좋을 듯하다.

import math
def isPrimeNum(num):
    if num == 1:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def convert(num, jinsu):
    result = ""
    while num > 0:
        result = f'{num % jinsu}{result}'
        num = num // jinsu
    return result

def solution(n, k):
    answer = 0

    converted = convert(n, k)
    checkList = converted.split("0")

    for num in checkList:
        if num.strip() == "":
            continue
        if isPrimeNum(int(num)):
            answer += 1
    return answer
