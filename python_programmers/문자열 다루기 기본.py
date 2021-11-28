def solution(s):
    size = len(s)
    if size != 6 and size != 4:
        return False
    
    for i in s:
        if i >= '0' and i <= '9':
            pass
        else:
            return False
    return True
