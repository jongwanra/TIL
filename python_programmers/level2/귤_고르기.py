def solution(k, tangerine):
    answer = 0
    total = 0
    list = [0 for i in range(1, 10000002)]

    # 크기별 갯수 저장
    for t in tangerine:
        list[t] += 1

    list.sort(reverse=True)

    for count in list:
        answer += 1
        total += count
        if total >= k:
            break

    return answer
