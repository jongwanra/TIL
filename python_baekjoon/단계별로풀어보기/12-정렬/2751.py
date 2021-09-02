# 수 정렬하기 2(2751)
# https://www.acmicpc.net/problem/2751

from sys import stdin
a = input()
def merge_sort(array):
    # Termination condition
    if len(array) <= 1:
        return array

    mid = len(array) // 2
    left = merge_sort(array[:mid])
    right = merge_sort(array[mid:])

    l_size, r_size = len(left), len(right)
    l_idx, r_idx, arr_idx = 0, 0, 0
    
    while l_idx < l_size and r_idx < r_size:
        if left[l_idx] < right[r_idx]:
            array[arr_idx] = left[l_idx]
            l_idx += 1
        else:
            array[arr_idx] = right[r_idx]
            r_idx += 1

        arr_idx += 1

        
    while l_idx < l_size:
        array[arr_idx] = left[l_idx]
        l_idx += 1
        arr_idx += 1
    
    while r_idx < r_size:
        array[arr_idx] = right[r_idx]
        r_idx += 1
        arr_idx += 1
    
    return array


n = int(input())
num = []

for _ in range(n):
    num.append(int(stdin.readline()))

num = merge_sort(num)

for i in num:
    print(i)