# 부등호(2529)
# https://www.acmicpc.net/problem/2529
# 못품(21.09.04)

# def check_true(datas, signs, k):
#     for i in range(k):
#         if eval(f"{int(datas[i])} {signs[i]} {int(datas[i+1])}") == False:
#             return False
#     return True

# def permutation(arr, k, res):
#     for i in range(k+1):
#         for j in range(k + 1):
#             if arr[i] == arr[j]:
#                 continue
#             for w in range(k + 1):
#                 if arr[i] == arr[w] or arr[j] == arr[w]:
#                     continue
#                 print(arr[i], arr[j], arr[w])
#                 if check_true([arr[i], arr[j], arr[w]], signs, k):
#                     res.append(int("".join([arr[i], arr[j], arr[w]])))
#                     # break
#     return res

# k = int(input())
# arr = [str(i) for i in range(0, 10)]
# signs = input().split()
# res = []

# res = permutation(arr, k, res)
# arr = [str(i) for i in range(9, -1, -1)]
# res = permutation(arr, k, res)

# print(str(res[0]).zfill(k+1))
# print(str(res[1]).zfill(k+1))


def possible(item1, item2, symbol):
    if symbol == '<':
        return item1 < item2
    if symbol == '>':
        return item1 > item2


def backtracking(idx, string):
    global min_value
    global visited
    global max_value
    if idx == n + 1:
        if not len(min_value):
            min_value = string
        else:
            max_value = string
        return
    for i in range(10):
        if visited[i]:
            continue
        if idx == 0 or possible(string[-1], str(i), stack[idx - 1]):
            visited[i] = True
            backtracking(idx + 1, string + str(i))
            visited[i] = False


if __name__ == '__main__':
    n = int(input())
    stack = list(input().split())
    max_value = ''
    min_value = ''
    visited = [False] * 10
    backtracking(0, '')
    print(max_value)
    print(min_value)