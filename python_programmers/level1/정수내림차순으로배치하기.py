def solution(n):
    lst = list(str(n))
    lst.sort(reverse=True)
    
    answer = ""
    for w in lst:
        answer += w
    answer = int(answer)
    return answer