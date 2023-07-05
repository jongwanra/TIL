
# 땅따먹기
# https://school.programmers.co.kr/learn/courses/30/lessons/12913

# 같은 열을 연속해서 밟을 수 없다
# 행의 개수: 10만 *열의 개수 4 => 40만
# 이문제는 큰수를 골라가면서 해야하는 문제가 아니라
# 전체의 경우의 수를 전부 찾되, 연속되는 행이 없는 경우의수로 찾아야하는 문제로 보인다.
# 해결방법 -> bfs!!?



# Fact
# 못품.. DFS로 접근을 했는데, 런타임에러로 실패

# Lesson
# 이 문제 유형은 BFS 혹은 DP이다.
# 반복문을 통해서 순서대로 MAX를 구하고 누적값을 채워 나간 후에, 풀었어야 했다.

def dfs(land, height, maxHeight, prevSelectedIdx, acc):
    global maxAnswer
    if maxHeight == height:
        maxAnswer = max(maxAnswer, acc)
        return
    for i in range(0, 4):
        if prevSelectedIdx == i:
            continue
        dfs(land, height + 1, maxHeight, i, acc + land[height][i])

def solution(land):
    global maxAnswer
    maxAnswer = -1
    dfs(land, 0, len(land), -1, 0)
    return maxAnswer