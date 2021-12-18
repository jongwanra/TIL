# 시저 암호
# https://programmers.co.kr/learn/courses/30/lessons/12926
# 해결 / 18분 / 21.12.18

'''
들어오는 알파벳을 칸 이동한 만큼 바꾸고 변환하는 함수를 만들자.
1. 공백이 들어올 경우
2. 소문자가 들어올 경우(97 <= x <= 122)
3. 대문자가 들어올 경우(65 <= x <= 90)
4. 순환한 경우
'''
def moveAlphabet(alpha, n):
    # 공백
    if alpha == ' ':
        return ' '
    # 소문자가 들어온 경우
    if alpha >= 'a' and alpha <= 'z':
        tmp = ord(alpha) - 97 + n
        return chr(97 + (tmp % 26))
    # 대문자인 경우
    if alpha >= 'A' and alpha <= 'Z':
        tmp = ord(alpha) - 65 + n
        return chr(65 + (tmp % 26))
    return alpha

def solution(s, n):
    answer = ''
    for alpha in s:
        answer += moveAlphabet(alpha, n)
    return answer