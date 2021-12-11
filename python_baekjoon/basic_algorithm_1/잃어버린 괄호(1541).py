# 잃어버린 괄호(1541)
# https://www.acmicpc.net/problem/1541
# 해결 / 45분 소요 / 21.12.11
'''

- 접근방법1 
    -가 붙어 있는 곳 부터 전부 괄호로 묶어주면 최솟값(실패)
- 접근방법2
    -처음과 끝을 괄호로 묶어주고, -가 존재한다면 괄호를 열어서 다 묶어주고
     또 다른 - 가 나올 경우 다시 닫고 다시 여는 접근으로 가보자. (성공)
- 접근 방법3
    그렇다면 어차피  (50)-(30+20)-(20+40) 이와 같이 - 로 나오는걸 기준으로 split()을 사용해서 묶는다면 훨씬 베스트 성능을 낼 수 있지 않을까
    내가 너무 어렵게 생각한거 같다.
    
숫자 앞에 0이 붙어 있는 경우 제거

'''

# 접근방법 2
# 괄호를 삽입하는 함수
# 50-30+20-20+40  -> (50)-(30+20)-(20+40)

def insertVPS(sentence):
    sentence = '(' + sentence + ')' # 처음과 끝을 일단 묶어준다.
    sentence = sentence.replace('-', ')-(') # -가 존재한다면, 전부 저 형태로 바꿔준다.
    return sentence

# 전체 문자열 앞 0 제거 하기
# 리스트로 받은 문장 중에 -, + 를 제외한 숫자 관련 문자열에 전부 0제거하는 내장함수를 사용
def deleteZeroOfFrontOfNumber(sentence_list):
    for i in range(len(sentence_list)):
        if sentence_list[i] == '-' or sentence_list[i] == '+':
            continue
        sentence_list[i] = sentence_list[i].lstrip("0")
    # 문자열로 내보낸다.
    return ''.join(sentence_list)

# 문자열을 -, + 로 기준으로 리스트로 반환 시키는 함수
# 예시) "30+20-30' ->  ['30', '+', '20', '-', '30']
def splitSentence(sentence):
    splited_sentence = []
    i = 0
    while sentence and len(sentence) > i:
        if sentence[i] == '-' or sentence[i] == '+':
            splited_sentence.append(sentence[:i])
            splited_sentence.append(sentence[i])
            sentence = sentence[i+1:]
            i = 0
        else:
            i+= 1
    # 나머지 남은 문장까지 넣어줌.
    splited_sentence.append(sentence)
    return splited_sentence

splited_sentence = splitSentence(input()) # 입력 받은 식을 숫자, -, + 로 쪼개서 리스트로 만든다
sentence = deleteZeroOfFrontOfNumber(splited_sentence) # 숫자 앞에 0이 붙어있는 경우, 0을 제거하고 다시 문자열로 받는다.
print(eval(insertVPS(sentence))) # 괄호를 추가해서 값이 최소가 되도록하고 해당 문자열을 eval 함수를 통해 실행후 출력
