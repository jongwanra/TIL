from collections import defaultdict

def solution(s):
    answer = []
    counter = defaultdict(int)
    numStartIdx = -1
    for i in range(0, len(s)):
        # 숫자가 처음 나온 경우
        if s[i].isdigit() and int(s[i]) >= 0 and int(s[i]) <= 9 and numStartIdx == -1:
            numStartIdx = i
        elif (s[i] == '}' or s[i] == ',') and numStartIdx != -1:
            counter[s[numStartIdx:i]] += 1
            numStartIdx = -1

    for key in dict(sorted(counter.items(), key=lambda x:x[1], reverse=True)):
        answer.append(int(key))
    return answer