# 21.11.17
# 6분 걸림

def solution(arr, divisor):
    answer = []
    for i in range(len(arr)):
        if arr[i] % divisor == 0:
            answer.append(arr[i])

    if len(answer) == 0:
        return [-1]    
    return sorted(answer)

arr = [3, 2, 6]
divisor = 10
print(solution(arr, divisor))