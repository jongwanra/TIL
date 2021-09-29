# 체스판 다시 칠하기(1018)
# https://www.acmicpc.net/problem/1018

# 체스 판 변경 갯수 반환 함수
def check_num_of_chessboard(board, origin_board):
    count = 0
    for row in range(8):
        for col in range(8):
            if board[row][col] != origin_board[row][col]:
                count += 1
    return count


#  W 로시작하는 보드판
origin_board_1 = [
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
]

# B로 시작하는 보드판
origin_board_2 = [
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
    ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'],
    ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'],
]

r, c = map(int, input().split())

board = []
min_num = int(1e9)


# 입력 받기
for _ in range(r):
    board.append(list(input()))

for row in range(len(board)):
    for col in range(len(board[0])):
        # 범위 밖을 안 벗어나면,
        if row + 7 < len(board) and col + 7 < len(board[0]):
            # 8*8 보드판 추출
            tmp = [b[col:col+8] for b in board[row:row+8]]
            min_num = min(min_num, check_num_of_chessboard(
                tmp, origin_board_1))
            min_num = min(min_num, check_num_of_chessboard(
                tmp, origin_board_2))

print(min_num)
