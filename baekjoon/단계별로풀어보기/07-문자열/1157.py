# 단어 공부(1157)
# https://www.acmicpc.net/problem/1157

s = input().lower()

word = [0] * 26
for i in s:
    word[ord(i)-97] += 1

if word.count(max(word)) >= 2:
    print("?")
else:
    print(chr(word.index(max(word))+ 97).upper())