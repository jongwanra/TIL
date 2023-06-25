#  유클리드 호제법 gcd
def gcd(a, b):
    [numA, numB] = [a, b] if a >= b else [b, a]

    while numB != 0:
        numR = numA % numB
        numA = numB
        numB = numR

    return numA

def lcm(a, b):
    return  a * b / gcd(a, b)

def solution(arr):
    lcmNum = arr[0]
    for i in range(1, len(arr)):
        lcmNum = lcm(lcmNum, arr[i])
    return lcmNum
