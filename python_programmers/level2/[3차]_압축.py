# [3차] 압축
# https://school.programmers.co.kr/learn/courses/30/lessons/17684

# 해결 방법
# 1. alphabet 사전을 만든다.
# 2. 그 뒤로 존재하면 계속 right 쪽으로 이동하며 search
# 3. 존재 하지 않다면, 출력 후 등록

from collections import defaultdict
def solution(msg):
    left = 0
    right = 0
    lastIdx = 26
    lzw_dict = defaultdict(int)
    answer = []
    # 1. alphabet  사전 만들기
    for i in range(0, 26):
        lzw_dict[chr(65 + i)] = i + 1

    while left < len(msg):
        right = left + 1

        while right <= len(msg):
            targetWord = msg[left:right]
            if not lzw_dict[targetWord]:
                lastIdx += 1
                lzw_dict[targetWord] = lastIdx
                answer.append(lzw_dict[msg[left:right - 1]])
                left = right - 1
                break
            right += 1

        if right >= len(msg):
            break

    targetWord = msg[left:right]
    if not lzw_dict[targetWord]:
        lastIdx += 1
        lzw_dict[targetWord] = lastIdx
    else:
        answer.append(lzw_dict[msg[left:right]])

    return answer