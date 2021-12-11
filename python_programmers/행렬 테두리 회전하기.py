# 행렬 테두리 회전하기
# https://programmers.co.kr/learn/courses/30/lessons/77485
# 미해결 / 40분 소요 / 21.12.11

'''
한개를 tmp에 담아두고 하나씩 옮긴 다음에 한칸 앞에 넣어주면 될 것 같다.
그리고 그 사이에 해당 옮긴 것들 사이에서 최솟값을 받아 두면 될 것 같다.
'''

# 영역 안에 있는 지 확인 하는 함수
def checkArea(r1, c1, r2, c2, target_row, target_col):
    if target_row < min(r1, r2) or target_row > max(r1, r2):
        return False
    if target_col < min(c1, c2) or target_col > max(c1, c2):
        return False
    return True

# 방향 바꾸는 함수
def changeDirection(i):
    if i == 3:
        return 0
    return i+1

def solution(rows, columns, queries):
    answer = []
    cnt = 1
    matrix = []
    
    # 리스트 초기화
    for r in range(rows):
        tmp = []
        for c in range(columns):
            tmp.append(cnt)
            cnt += 1
        matrix.append(tmp)

    for query in queries:
        # bottom, right, up, left
        d_row = [1, 0, -1, 0]
        d_col = [0, 1, 0, -1]

        # 행렬의 위치를 인덱스 기준으로 맞추기
        for i in range(4):
            query[i] -= 1
        r1, c1, r2, c2 = query
        
        # 시계 방향으로 돌리기 위해서 빼두기(왼쪽 모서리 부분)
        tmp = matrix[r1][c1]
        cur_row, cur_col = r1, c1
        i = 0
        min = matrix[cur_row][cur_col]
        
        while True:
            # 종료 조건
            if r1 == cur_row and c1 + 1 == cur_col:
                break
            if checkArea(r1, c1, r2, c2, cur_row + d_row[i], cur_col + d_col[i]):
                matrix[cur_row][cur_col] = matrix[cur_row + d_row[i]][cur_col + d_col[i]]
                cur_row += d_row[i]
                cur_col += d_col[i]
            else:
                i = changeDirection(i)
                matrix[cur_row][cur_col] = matrix[cur_row + d_row[i]][cur_col + d_col[i]]
                cur_row += d_row[i]
                cur_col += d_col[i]
                
            if min > matrix[cur_row][cur_col]:
                min = matrix[cur_row][cur_col]
                
        # 마지막 넣어 주기
        matrix[cur_row][cur_col] = tmp
            
        answer.append(min)
    return answer