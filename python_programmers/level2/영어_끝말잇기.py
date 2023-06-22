#  이전에 등장했던 단어를 사용하면 탈락
# 가장 먼저 탈락하는 사람의 번호, 몇 번째 차례에서 탈락하는지

from collections import defaultdict
def solution(n, words):
    dict = defaultdict(int)
    dict[words[0]] += 1

    for i in range(1, len(words)):
        dict[words[i]] += 1
        beforeWord, currentWord = words[i - 1], words[i]

        if (i + 1) % n == 0:
            personNum, cycleNum = n, (i + 1) // n
        else:
            personNum, cycleNum = (i + 1) % n,  (i + 1) // n + 1

        # 끝말 잇기 떨어진 케이스
        if beforeWord[-1] != currentWord[0]:
            return [personNum, cycleNum]
        # 중복 케이스
        if dict.get(words[i]) >= 2:
            return [personNum, cycleNum]

    return [0, 0]