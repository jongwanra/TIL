# https://school.programmers.co.kr/learn/courses/30/lessons/12951?language=python3
def solution(s):
    stringList = s.split(" ")
    answer = ""

    for str in stringList:
        # 공백문자 연속으로 나올 경우
        if len(str) == 0:
            answer += " "
            continue

        # 첫 단어시 공백 추가 X
        if str != stringList[0]:
            answer += " "

        if str[0].isdigit():
            answer += f'{str[0]}{str[1:].lower()}'
        else:
            answer += f'{str[0].upper()}{str[1:].lower()}'

    return answer