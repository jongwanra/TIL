def solution(numbers, target):
    q = [0]
    for n in numbers:
        s = []
        while q:
            tmp = q.pop()
            s.append(tmp + n)
            s.append(tmp + (-n))
        q = s.copy()
    return q.count(target)