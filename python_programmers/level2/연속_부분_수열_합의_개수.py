from collections import defaultdict

def solution(elements):
    dict = defaultdict(int)
    length = 1
    size = len(elements)
    doubleElements = elements + elements

    while length <= size:
        for startIndex in range(0, size):
            total = sum(doubleElements[startIndex: startIndex + length])
            dict[total] += 1
        length += 1

    return len(dict)