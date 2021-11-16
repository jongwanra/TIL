# 월을 일수로 변환해주는 함수
def convertMonthToDay(m):
    month = [0, 31,29,31,30,31, 30, 31, 31, 30, 31, 30, 31]
    res = 0
    for i in range(1, m):
        res += month[i]
    return res

# 총 일수를 요일로 반환시켜주는 함수
def convertTotalToDate(total):
    dic = {
        1: "FRI",
        2: "SAT",
        3: "SUN",
        4: "MON",
        5: "TUE",
        6: "WED",
        0: "THU"
    }
    return dic[total%7]

def solution(a, b):
    # 총 일수 계산
    total_day= convertMonthToDay(a) + b;
    return convertTotalToDate(total_day)

