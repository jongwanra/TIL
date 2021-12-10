# 분해합(2231)
# https://www.acmicpc.net/problem/2231
# 해결/ 20분 소요 / 21.12.10(340ms)
'''
- 접근방법
입력값(100만) 만큼 리스트를 할당하고
한 번 돌면서 생성자를 넣어준다.
'''

# 피생성자 만드는 함수
def createConstructor(n):
    res = n
    while n > 0:
        res += n % 10
        n = n // 10
    return res
    
# 100만개의 리스트
dp = [[] for i in range(1000054)]

n = int(input())

# 리스트 안에 생성자들을 다 넣어줌
for c in range(1, 1000001):
    dp[createConstructor(c)].append(c)
print(dp)
# 생성자가 없을 경우 0 출력,
# 있을 경우 최솟값 출력
print(0) if dp[n] == [] else print(min(dp[n]))



# 분해합(2231)
# https://www.acmicpc.net/problem/2231

# 결국에는, 생성자를 구하는 프로그램은 범위가 주어진 예제 입력 까지이다.
# 시간 제한이 2초이다. 따라서, O(n)에 푸는 것이 바람직 하다.

def check_constructor(i, n):
    sum = i
    while i > 0:
        sum += i % 10
        i = i // 10

    if sum == n:
        return True
    return False


n = int(input())
res = 0
for i in range(n+1):
    if check_constructor(i, n) == True:
        res = i
        break

print(res)
