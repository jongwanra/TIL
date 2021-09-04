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
