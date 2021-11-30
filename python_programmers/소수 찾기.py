# def solution(n):
#     cnt = 0    
#     for i in range(2, n+1):
#         flag = 0
#         for j in range(2, i //2 + 1):
#             if i % j == 0:
#                 flag = 1
#                 break
#         if flag == 0:
#             cnt += 1 
#     return cnt

def solution(n):
    data = [True] * (n + 1)
    for i in range(2, n // 2 + 1):
        if data[i] is True:
            for j in range(i*2, n+1, i):
                data[j] = False
    cnt = 0
    for i in data:
        if i is True:
            cnt += 1
    return cnt -2

n = 5
print(solution(n))