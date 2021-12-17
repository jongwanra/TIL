# 이상한 문자 만들기
# https://programmers.co.kr/learn/courses/30/lessons/12930
# 해결 / 30분 초과 / 21.12.17

'''
짝수는 index로 계산해야하다 보니 index % 2 == 1로 보고 판단. 홀수는 반대
index == 0 홀수
index == 1 짝수

공백이 1개 이상인 경우를 생각안해줬다. split() -> split(' ')변경으로 해결
'''
def convertWord(word):
    s = list(word)
    for i in range(len(s)):
        # 짝수인 경우, 소문자 -> 대문자로
        if i % 2 == 0 and s[i] >= 'a' and s[i] <= 'z':
                s[i] = chr(ord(s[i]) - 32)
        # 홀수인 경우, 소문자로
        elif i % 2 == 1 and s[i] >= 'A' and s[i] <= 'Z':
                s[i] = chr(ord(s[i]) + 32)
    return ''.join(s)

def solution(s):
    answer = []
    words = s.split(" ")
    
    for word in words:
        answer.append(convertWord(word))
    
    return ' '.join(answer)