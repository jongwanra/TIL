# 그룹단어체커(1316)
# https://www.acmicpc.net/problem/1316

n = int(input())

total = 0
for _ in range(n):
    word = input()
    dic = dict()

    # 각 단어들을 사전형에 갯수만큼 카운트 시킴.
    '''
    ex) word -> happy:
    {'h': 1, 'a': 1, 'p': 2, 'y': 1}
    '''
    for w in word:
        try:
            dic[w] += 1
        except:
            dic[w] = 1
    flag = 0
    for i in range(len(word)):
        '''
        각 단어들을 돌면서, 각 소문자 카운팅을 하나씩 뺀다.
        그러면서 전 단어와 다르면서 카운팅이 남아있을 경우 연속적인 것이 아닌 것으로 판단.
        flag 를 1로 만들어준다.
        '''
        if i >= 1:
            if word[i] != word[i-1]:
                if dic[word[i-1]] >= 1:
                    flag = 1
                    break
        dic[word[i]] -= 1   

    if flag == 0:
        total += 1
print(total)