'''
입력된 아이디와 유사하면서 규칙에 맞는 아이디 추천 프로그램 개발
- 조건
3< = 아이디 길이 <= 15
알파벳 소문자, -, _ , . 만 사용 가능
단, .은 처음 끝에 사용 불가, 연속 사용 불가
'''

# 대문자 -> 소문자 치환
def exec_level_1(s):
    s = list(s)
    for i in range(len(s)):
        if s[i] >= 'A' and s[i] <= 'Z':
            s[i] = chr(ord(s[i]) + 32)
    return ''.join(s)
        
# 알파벳 소문자, 숫자, 뺴기, 밑줄, 마침표를 제외한 모든 문자 제거
def exec_level_2(s):
    s = list(s)
    new_s = []
    for i in s:
        if i >= 'a' and i <= 'z':
            new_s.append(i)
        elif i == '-' or i == '_' or i == '.':
            new_s.append(i)
        elif i >= '0' and i <= '9':
            new_s.append(i)
            
    return ''.join(new_s)

# .. -> .
def exec_level_3(s):
    while '..' in s:
        s = s.replace('..', '.')
    return s

# 처음 과 끝이 .이면 제거
def exec_level_4(string):
    string = string.lstrip('.')
    string = string.rstrip('.')
    return string
    

# new_id == '' => 'a'
def exec_level_5(s):
    if s == '':
        return 'a'
    return s
# 길이가 16자 이상일 경우, 15자 제외한 문자 전부 제
def exec_level_6(s):
    if len(s) >= 16:
        s = s[:15]
        s = s.rstrip('.')
    return s

# new_id 길이가 2자 이하라면, 마지막 문자 3이 될때까지 붙히기
def exec_level_7(s):
    if len(s) == 1:
        s = s[0] * 3
    elif len(s) == 2:
        s += s[-1]
    return s
    
def solution(new_id):
    new_id = exec_level_1(new_id)
    new_id = exec_level_2(new_id)
    new_id = exec_level_3(new_id)
    new_id = exec_level_4(new_id)
    new_id = exec_level_5(new_id)
    new_id = exec_level_6(new_id)
    new_id = exec_level_7(new_id)
    return new_id