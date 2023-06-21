def solution(s):
    numberList = list(map(int, s.split(" ")))
    return f'{min(numberList)} {max(numberList)}'
