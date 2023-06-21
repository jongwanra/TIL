def getBitOneCount(num):
    binary = bin(num)
    return binary.count('1')

def solution(n):
    originBinaryCount = getBitOneCount(n)

    num = n + 1
    while getBitOneCount(num) != originBinaryCount:
        num += 1

    return num