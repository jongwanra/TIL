# 좌표 압축(18870)
# https://www.acmicpc.net/problem/18870

from sys import stdin

def binary_search(sorted_datas, target):    
    left = 0
    right = len(sorted_datas) - 1

    while left <= right:
        mid = (left+right) // 2
        # print(f"sorted_datas: ${sorted_datas} sorted_datas[${mid}]: {sorted_datas[mid]}, target: ${target}")
        if sorted_datas[mid] == target:
            return mid
        elif sorted_datas[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    return "not found"
    

#  target 보다 작은 갯수를 구한다.    
n = int(input())
datas = list(map(int, stdin.readline().split()))
sorted_datas = sorted(list(set(datas))) # 중복값 제거

for data in datas:
    print(binary_search(sorted_datas, data), end=" ")
