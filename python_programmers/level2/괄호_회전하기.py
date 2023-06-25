from collections import deque

def solution(s):
    size = len(s)
    queue = deque(list(s))
    answer = 0
    i = 0
    # 한바퀴 돌리는 for문
    while i <= size - 1:
        if i != 0:
            queue.append(queue.popleft())
        stackA = [*queue]
        stackB = []
        isPass = True
        for q in queue:
            top = stackA.pop()
            if top == ')' or top == '}' or top == ']':
                stackB.append(top)
            else:
                if not stackB:
                    isPass = False
                    break
                elif top == '(' and stackB[-1] == ')':
                    stackB.pop()
                elif top == '{' and stackB[-1] == '}':
                    stackB.pop()
                elif top == '[' and stackB[-1] == ']':
                    stackB.pop()
                else:
                    isPass = False
                    break
        if isPass and not stackB:
            answer += 1
        i += 1

    return answer

print(solution("}}}"))