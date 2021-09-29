# 단어 뒤집기 2(17413)
# https://www.acmicpc.net/problem/17413
# 품 (21.09.20) / 22분
from sys import stdin
if __name__ == "__main__":
    input = stdin.readline
    string = input().rstrip()
    
    flag = 0 # flag로 현재가 태그 안에 있을 때와 아닐때를 구분
    
    buffer = ""
    for word in string:
        if word == '<':
            if buffer:
                ans = buffer.split()
                size = len(ans)
                for data in ans:
                    if size == 1:
                        print(data[::-1], end="")
                    else:
                        print(data[::-1], end=" ")
                    size -= 1
                buffer = ""
            flag = 1
            print(word, end="")
            continue
        if word == '>':
            flag = 0
            print(word, end="")
            continue

        # 태그 범위가 X
        if flag == 0:
            buffer += word
        # 태그 범위일 떄,
        elif flag == 1:
            print(word, end="")
    if buffer:
        ans = buffer.split()
        size = len(ans)
        for data in ans:
            if size == 1:
                print(data[::-1], end="")
            else:
                print(data[::-1], end=" ")
            size -= 1

    