def solution(s):
    size = len(s)
    # even
    if size % 2 == 0:
        return s[size // 2 - 1] + s[size // 2]
    return s[size//2]