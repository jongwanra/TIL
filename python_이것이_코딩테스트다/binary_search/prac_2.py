# 부품 찾기(197p)
# 내 풀이
from sys import stdin

def binary_search(lst, target, start, end):
    if start >= end:
        return "no"
    
    mid = (start + end) // 2
    if target == lst[mid]:
        return "yes"

    elif target > lst[mid]:
        return binary_search(lst, target, mid+1, end)
    else:
        return binary_search(lst, target, start, mid-1)
    

    
n = int(stdin.readline().rstrip())
n_lst = list(map(int, stdin.readline().rstrip().split()))
n_lst.sort()

m = int(stdin.readline().rstrip())
m_lst = list(map(int, stdin.readline().rstrip().split()))


for i in range(m):
    print(binary_search(n_lst, m_lst[i], 0, n-1), end=" ")
    

