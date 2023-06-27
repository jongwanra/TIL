from collections import defaultdict

def solution(clothes):

    answer = 1
    categoryMap = defaultdict(int)

    for cloth in clothes:
        [clothName, category] = cloth
        categoryMap[category] += 1


    for category in categoryMap:
        answer *= categoryMap[category] + 1

    return answer - 1