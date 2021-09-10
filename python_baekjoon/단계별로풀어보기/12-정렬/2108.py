# 통계학(2108)
# https://www.acmicpc.net/problem/2108
    
from sys import stdin

# 최빈값 반환(가장 많이 나타나는 값이 중복일 경우, 두 번째로 작은 값 출력)
def min_func(dic):
    sorted_dic = sorted(dic.items(), key= lambda x: x[0]) # key값 기준으로 오름차순
    sorted_dic = sorted(sorted_dic, key=lambda x:x[1], reverse=True) # 중복값 기준으로 내림차순
    if sorted_dic[0][1] != sorted_dic[1][1]:
        return sorted_dic[0][0]
    return sorted_dic[1][0]


n = int(stdin.readline())

sum = 0
datas = []
dic = {}
for _ in range(n):
    tmp = int(stdin.readline())
    sum += tmp
    datas.append(tmp)    
    try:
        dic[tmp] += 1
    except:
        dic[tmp] = 1

datas.sort()
print(round(sum/n)) # 산술평균
print(datas[len(datas)//2]) # 중앙값

# 최빈값
if len(datas) == 1:
    print(datas[0])
else:
    print(min_func(dic))
print(abs(datas[0] - datas[len(datas) - 1])) # 범위