# 폰켓몬
# https://programmers.co.kr/learn/courses/30/lessons/1845
# 해결 / 15분 소요 / 21.12.19
'''
최대한 많은 종류의 폰켓몬 갯수 구하기

1. 조합을 구하기
2. 조합 요소들의 중복을 제거 후 
3. 종류를 제일 많이 가지고 있는 요소 찾은 후 최댓값 반환

- 시간 초과
def solution(nums):
    lst = list(combinations(nums, len(nums) // 2))
    max = -999
    for l in lst:
        if max < len(set(l)):
            max = len(set(l))
    return max
'''
# 2번째 접근
def solution(nums):
    r = len(nums) // 2
    lst = list(set(nums))
    
    # 선택의 갯수 보다 작거나 같은 경우
    if len(lst) <= r:
        return len(lst)
    return r