# 요세푸스 문제(1158)
# https://www.acmicpc.net/problem/1158
# 품(21.09.12) / 38:01

from collections import deque
if __name__ == "__main__":    
    N, K = map(int, input().split())
    q_main = deque([i for i in range(1, N + 1)])
    q_sub = deque()
    res = 0
    cnt = 1
    print("<", end="")
    while res < N:
        while q_main:
            if cnt % K == 0:
                res += 1
                # last output 
                if res == N:
                    print(f"{q_main.popleft()}", end="")    
                else:
                    print(f"{q_main.popleft()}", end=", ")    
                
            else:
                q_sub.append(q_main.popleft())
            cnt += 1

        while q_sub:
            q_main.append(q_sub.popleft())
    print(">")