# 영화감독 숌(1436)
# https://www.acmicpc.net/problem/1436
# 해결 / 19분 소요 / 21.12.11 (536ms)
'''
6이 3개이상 연속으로 들어가는 수
666, 1666, 2666, 3666, 4666, ... 

-입력
1 <= n <= 10000

- 접근 방법
for문을 한 번 돌면서 6이 연속으로 3개 나온 수는 순차적으로 
리스트 answer에 추가하고 출력
'''
def checkNum(string):
    datas = list(string)
    for i in range(len(datas) - 2):
        if datas[i] == '6' and datas[i+1] == '6' and datas[i+2] == '6':
            return True
    return False            
    
n = int(input())
answer = []
cnt = 666
while len(answer) < n:
    if checkNum(str(cnt)):
        answer.append(cnt)
    cnt += 1
print(answer[n-1])
exit()


# 영화감독 숌(1436)
# https://www.acmicpc.net/problem/1436

n = int(input())

res = []
count = 0
data = 1
while count < n:
    if str(data).count('666') >= 1:
        res.append(data)
        count += 1
    data += 1

print(res[-1])
