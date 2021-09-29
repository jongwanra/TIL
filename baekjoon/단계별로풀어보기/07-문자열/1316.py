# 그룹 단어 체커(1316)
# https://www.acmicpc.net/problem/1316

def check(s, dic):
    '''
    전 단어를 기억해두며, 전에 단어와 비교했을 때 다를 경우,
    dic에 카운팅을 확인한다.
    1이상이면 그룹단어가 아닌 것으로 판단하고 0을 반환
    '''
    before = s[0]
    for w in s:
        dic[w] -= 1
        if before != w and dic[before] >= 1:
            return 0            
        before = w
    return 1


n = int(input())
res = 0
for _ in range(n):
    s = input() # 단어 입력
    dic = {}
    # 중복 단어 갯수 카운팅
    for w in s:
        try:
            dic[w] += 1
        except:
            dic[w] = 1
    # 그룹단어 여부 체크 함수 호출
    res += check(s, dic)

print(res)