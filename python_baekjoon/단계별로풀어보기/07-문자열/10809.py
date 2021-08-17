# 알파벳 찾기(10809)
# https://www.acmicpc.net/problem/10809


# 'a' -> 97
arr = [-1] * 26

s = input()
for i, v in enumerate(s):
    if arr[ord(v) - 97] == -1:
        arr[ord(v)-97] = i
print(" ".join(list(map(str, arr))))