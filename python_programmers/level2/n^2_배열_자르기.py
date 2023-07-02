# n^2 배열 자르기
# https://school.programmers.co.kr/learn/courses/30/lessons/87390

# 접근 방법
# 우선 right 숫자가 존재하는 갯수 까지 1차원 배열로 만들자
# 여기서 만들어지는 규칙은 row -> 1이면 1개, row2면 2가 2개
# 시간 초과가 뜬다.
# 필요한 열만 구해보자
# 소요 시간 26분

import math
def solution(n, left, right):
    lst = []
    width, height = n, n
    leftHeight = math.floor(left / n) + 1
    rightHeight = math.floor(right / n) + 1

    while leftHeight <= rightHeight:
        w = leftHeight
        for i in range(0, w):
            lst.append(w)
        w += 1
        while w <= width:
            lst.append(w)
            w += 1
        leftHeight += 1

    startIdx = left % n
    lastIdx = startIdx + right - left
    return lst[startIdx:lastIdx + 1]



# 다른 사람 풀이
# n * n 배열의 요소는 몫과 나머지로 알 수가 있다..
def otherSolution(n, left, right):
    answer = []
    for i in range(left,right+1):
        answer.append(max(i//n,i%n)+1)
    return answer

