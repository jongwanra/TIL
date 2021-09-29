# 수 정렬하기(2750)
# https://www.acmicpc.net/problem/2750

def merge(left, right):
    res = []
    while len(left) >= 1 or len(right) >= 1:
        if len(left) >=1 and len(right) >= 1:
            if left[0] >= right[0]:
                res.append(right[0])
                right = right[1:]
            else:
                res.append(left[0])
                left = left[1:]
        elif len(left) >= 1:
            res.append(left[0])
            left = left[1:]
        else:
            res.append(right[0])
            right = right[1:]
    return res
                
    
def merge_sort(array):
    if len(array) <= 1:
        return array
    
    mid = len(array) // 2
    left_arr = merge_sort(array[:mid])
    right_arr = merge_sort(array[mid:])
    return merge(left_arr, right_arr)

n = int(input())
array = []
for i in range(n):
    array.append(int(input()))

lst = merge_sort(array)
for i in lst:
    print(i)