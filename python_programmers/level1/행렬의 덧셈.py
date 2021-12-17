# 5분 소요

def solution(arr1, arr2):
    col, row = len(arr1[0]), len(arr1)
    answer = []
    for r in range(row):
        tmp = []
        for c in range(col):
            tmp.append(arr1[r][c] + arr2[r][c])
        answer.append(tmp)
    return answer
arr1 = [[1,2],[2,3]]
arr2 = [[3,4],[5,6]]
print(solution(arr1, arr2))