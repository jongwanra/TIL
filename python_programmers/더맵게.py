from heapq import heapify, heappop, heappush
def solution(scoville, K):
    answer = 0
    heapify(scoville)
    while len(scoville) >= 2:
        
        if scoville[0] >= K:
            return answer
        
        answer += 1
        res = heappop(scoville) + (heappop(scoville) * 2)
        heappush(scoville, res)

    if len(scoville) == 1 and scoville[0] >= K:
        return answer
    return -1
'''
처음에 heapify 를 반복문 안에서 사용했었다. 그랬더니, 효율성문제를 전부 맞추지 못했다.
성능을 위해서는 heapify 함수를 최대한 적게 사용하도록 해며 대신 heappush와 heappop을 이용하면
될듯 하다.
--------------
처음 푼 코드
'''

'''

from heapq import heapify, heappop

def solution(scoville, K):
    answer = 0
    while len(scoville) >= 2:
        heapify(scoville)

        if scoville[0] >= K:
            return answer

        else:
            answer += 1
            res = heappop(scoville)
            scoville[0] += (scoville[0] + res)
            
    if len(scoville) == 1 and scoville[0] >= K:
        return answer
    return -1
'''