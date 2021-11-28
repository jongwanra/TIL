def solution(s):
    answer = ''
    lower = ''
    bigger = ''
    
    for i in s:
        if i >= 'a' and i <= 'z':
            lower += i
        else:
            bigger += i
    
    lower = sorted(lower, reverse=True)
    bigger = sorted(bigger, reverse=True)
    answer = lower + bigger
    res = ''
    for i in answer:
        res += i
    return res