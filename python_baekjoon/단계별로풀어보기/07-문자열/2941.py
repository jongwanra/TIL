# 크로아티아 알파벳(2941)
# https://www.acmicpc.net/problem/2941

w = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

s = input()
for value in w:
    s = s.replace(value, "@")
print(len(s))
