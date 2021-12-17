def solution(num):
    answer = ''
    # 짝수거나 0인 경우
    if num % 2 == 0 or num == 0:
        answer += "Even"
    # 홀수인 경우
    else:
        answer += "Odd"
    return answer