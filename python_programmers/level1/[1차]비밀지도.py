
def solution(n, arr1, arr2):
    answer = []
    for idx in range(n):
        data = bin(arr1[idx] | arr2[idx])[2:]
        data = data.zfill(n)
        tmp = ""
        for d in data:
            if d == '1':
                tmp += '#'
            else:
                tmp += ' '
        answer.append(tmp)
    return answer


n = 6
arr1 = [46, 33, 33, 22, 31, 50]
arr2 = [27, 56, 19, 14, 14, 10]

print(solution(n, arr1, arr2))