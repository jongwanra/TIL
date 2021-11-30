# x가 하샤드 수인지 아닌지 True or False 로 반환
# 8분 소요

def solution(x):
    origin_x, sum = x, 0
    while x > 0:
        sum += x % 10
        x = x // 10
        
    if origin_x % sum == 0:
        return True
    return False

print(solution(10))
print(solution(12))
print(solution(11))
print(solution(13))

