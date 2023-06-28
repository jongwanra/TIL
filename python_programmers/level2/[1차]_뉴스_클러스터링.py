import math
from collections import defaultdict

def solution(str1, str2):
    str_set = defaultdict(list)

    for i in range(0, len(str1) - 1):
        if i+1  >= len(str1):
            break
        if not str1[i].isalpha() or not str1[i +1].isalpha():
            continue

        key = f'{str1[i]}{str1[i+1]}'.upper()
        if str_set[key]:
            [a, b] = str_set[key]
            str_set[key] = [a + 1, b]
        else:
            str_set[key] = [1, 0]

    for i in range(0, len(str2) - 1):
        if i+1  >= len(str2):
            break
        if not str2[i].isalpha() or not str2[i +1].isalpha():
            continue

        key = f'{str2[i]}{str2[i+1]}'.upper()
        if str_set[key]:
            [a, b] = str_set[key]
            str_set[key] = [a, b + 1]
        else:
            str_set[key] = [0, 1]

    intersection = 0
    union = 0

    for key, target in str_set.items():
        if len(target) < 2:
            continue

        if target[0] >= 1 and target[1] >= 1:
            intersection += min(target)
            union += max(target)
        else:
            union += max(target)


    if len(str_set) == 0:
        return 65536
    return math.floor((intersection / union) * 65536)