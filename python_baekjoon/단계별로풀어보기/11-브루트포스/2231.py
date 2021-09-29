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
