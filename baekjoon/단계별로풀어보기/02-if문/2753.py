# 윤년(2753)
# https://www.acmicpc.net/problem/2753

def check_leap_year(year):
    # 윤년인 경우: 4의 배수 and 100의 배수가 아닐 때 또는 400의 배수일 때
    if year % 4 == 0:
        if year % 100 != 0 or year % 400 == 0:
            return 1
    return 0

# 연도 입력
year = int(input())

print(check_leap_year(year))


