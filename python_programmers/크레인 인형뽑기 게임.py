# 크레인 인형뽑기 게임
# 해결 / 1시간 소요 / 21.12.10

'''
1시간 걸렸던 이유..
문제에서 출력 값을 *2가 아닌 1개로 생각했고 
출력값이 잘못된지를 인지를 못했다.
결국 내가 문제를 제대로 읽지 않은 탓이였다.
'''


# 전부 출력해 보기 위한 함수
def printAll(board, move, stack):
    size = len(board[0])
    print("move: ", move+1)
    for i in range(size):
        for j in range(size):
            print(board[i][j], end=' ')
        print()
    print("stack:", stack)

def solution(board, moves):
    cnt = 0
    stack = []
    size = len(board[0])
    # 인형을 뽑을 위치
    for move in moves:
        move = move - 1
        
        # 4 -> 0 순서로 반복
        for i in range(size):
            if board[i][move] == 0:
                continue
            # 1 이상인 경우
            else:
                # stack이 비어있는 경우
                if len(stack) == 0:
                    stack.append(board[i][move])
                # stack 안에 1개 이상 존재하는 경우
                else:
                    # stack 가장 위와 들어오는 수가 같은 경우
                    if stack[-1] == board[i][move]:
                        stack.pop()
                        cnt += 2
                    # 수가 다른 경우 추가만 해준다
                    else:
                        stack.append(board[i][move])
            board[i][move] = 0
            # printAll(board, move, stack)
            break
    return cnt

board = [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]
moves = [1,5,3,5,1,2,1,4]
print(solution(board, moves))