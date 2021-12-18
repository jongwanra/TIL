# 두 개 뽑아서 더하기
# https://programmers.co.kr/learn/courses/30/lessons/68644
# 해결 / 8분 소요 / 21.12.18
from itertools import combinations

def solution(numbers):
    new_answer = []
    # 조합 라이브러리를 사용하여 서로 다른 인덱스를 가지고 있는 리스트를 만든다.
    answer = list(combinations(numbers, 2)) 
    # 반복문을 통해서 더한 값들을 가진 리스트를 만든 후
    new_answer = [(ans[0] + ans[1]) for ans in answer]
    # set 자료형을 이용해 중복 값을 제거 하고, 오름차순 정렬한다.
    return sorted(list(set(new_answer)))