# https://school.programmers.co.kr/learn/courses/30/lessons/12945
# f(n) = f(n - 1) + f(n - 2)
def solution(n):
    memory = [0 for i in range(0, n + 1)]

    memory[1] = 1
    memory[2] = 1
    for i in range(3, n + 1):
        memory[i] = memory[i - 1] + memory[i - 2]

    return memory[n] % 1234567