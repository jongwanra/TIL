# 균형잡힌 세상(4949)
# https://www.acmicpc.net/problem/4949
# 미해결 / 30분 초과 / 21.12.09
from sys import stdin

while True:
    sentence = stdin.readline().rstrip()
    if sentence  == '.':
        break
    stack = []
    flag = False
    for s in sentence:
        if s == '[':
            stack.append('[')
        if s == '(':
            stack.append('(')
        if s == ']':
            if stack != [] and stack[-1] == '[':
                stack.pop()
            else:
                flag = True
                break
        if s == ')':
            if stack != [] and stack[-1] == '(':
                stack.pop()
            else:
                flag = True
                break
    if flag or stack != []:
        print('no')
    else:
        print('yes')