# 주차 요금 계산
# https://school.programmers.co.kr/learn/courses/30/lessons/92341


# records -> 시각 차량번호 내역
# 하루 동안의 입/출차된 기록만 담고 있다. 다음날 출차 X


# 해결 방법
# 1. 사전을 이용해서  차량번호: [차량번호, IN, 누적 시간, 금액]으로 입고 없으면 -1 (분기준으로 기록)
# 2. 금액을 계산해서 네 번째 요소에 넣어준다
# 3. 정렬 후 반환


# 해결.. .소요시간 50분..?!
# Lesson
# 반성이 되는 문제 ㅠ
# 입출력 예시를 따져보는 시간도 필요하다.
# 문제를 좀더 꼼꼼히 읽자

from collections import defaultdict
import math

def changePerMinuite(originTime):
    hours, miniutes = originTime.split(":")
    return int(miniutes) + int(hours) * 60

def solution(fees, records):
    answer = []
    defaultTime, defaultFee, unitTime, unitFee = fees
    parkingDic = defaultdict(list)

    for record in records:
        time, carNumber, type = record.split(" ")
        if not parkingDic[carNumber]:
            parkingDic[carNumber] = [carNumber, -1, 0]

        if type == "IN":
            parkingDic[carNumber][1] = changePerMinuite(time)
            continue

        # 출차되는 경우 누적 타임
        inTime, outTime = parkingDic[carNumber][1], changePerMinuite(time)
        parkingDic[carNumber][1] = -1
        parkingDic[carNumber][2] += outTime - inTime


    for key, values in parkingDic.items():
        if values[1] == -1:
            continue
        outTime = changePerMinuite("23:59")
        totalTime = outTime - values[1]
        parkingDic[key][2] += totalTime

    # 아직 계산 안된 출고시간 입력 안된 케이스
    for key, values in parkingDic.items():
        totalTime = values[2]
        # 기본 시간 보다 적을 경우 기본 요금 적용
        if totalTime <= defaultTime:
            parkingDic[key].append(defaultFee)
            continue
        # 기본 요금 + 단위 시간 마다 단위 요금 청구
        chargedFee = defaultFee + (math.ceil((totalTime - defaultTime) / unitTime) * unitFee)
        parkingDic[key].append(chargedFee)


    for key, values in parkingDic.items():
        answer.append(values)

    answer.sort(key=lambda x:x[0])
    answer2 = []

    for a in answer:
        answer2.append(a[3])
    return answer2