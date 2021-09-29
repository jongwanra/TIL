# 직각삼각형(4153)
# https://www.acmicpc.net/problem/4153

def check_triangle(lst):
    '''
    직각 삼각형 여부를 반환하는 함수
    
    3개 중 가장 큰 수를 lst[2]로 옮겨서 계산한다.
    '''
    max_idx = lst.index(max(lst))

    # 가장 큰 수가 해당 위치에 없는 경우, 해당 위치로 옮겨 준다.
    if lst[2] != lst[max_idx]:
        lst[max_idx], lst[2] = lst[2], lst[max_idx]

    if lst[0] ** 2 + lst[1] ** 2 == lst[2] ** 2:
        return "right"
    return "wrong"

while True:
    lst =list(map(int, input().split()))
    # 종료 조건
    if lst[0] == 0 and lst[1] == 0 and lst[2] == 0:
        break
    print(check_triangle(lst))
