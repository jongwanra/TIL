# 경로 찾기(11403)
# https://www.acmicpc.net/problem/11403

from sys import stdin

if __name__ == "__main__":
    input = stdin.readline
    N = int(input())  # 정점의 개수
    INF = int(1e9)

    matrix = []
    for _ in range(N):
        matrix.append(list(map(int, input().split())))

    for k in range(N):
        for a in range(N):
            for b in range(N):
                # 이미 갈 수 있는 경로인 경우, 패스
                if matrix[a][b] == 1:
                    continue
                # 거쳐서 가는 거리가 둘 다 갈 수 있는 경우, 갱신
                if matrix[a][k] == 1 and matrix[k][b] == 1:
                    matrix[a][b] = 1

    for i in range(N):
        for j in range(N):
            print(matrix[i][j], end=" ")
        print()
