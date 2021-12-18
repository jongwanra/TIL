# 부족한 금액 계산하기
# https://programmers.co.kr/learn/courses/30/lessons/82612
# 해결 / 8분 소요 / 21.12.18
'''
3 * 1
3 * 2
3 * 3
3 * 4
'''
def solution(price, money, count):
    # 총 곱해지는 횟수 구하기
    total_count = (count * (count + 1) // 2) 
    total_price = total_count * price
    
    if total_price - money <= 0:
        return 0
    return total_price - money