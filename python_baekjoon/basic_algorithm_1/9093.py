# 단어 뒤집기(9093)
# https://www.acmicpc.net/problem/9093
# 품(21.09.10) / 5분 이내
if __name__ == "__main__":
    N = int(input())
    
    for _ in range(N):
        sentence = input().split()
        for word in sentence:
            print(word[::-1], end=" ")
        print()
            
            