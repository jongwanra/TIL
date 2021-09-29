# 괄호(9012)
# https://www.acmicpc.net/problem/9012
# 품(21.09.10) / 7분 이내

# 괄호의 갯수를 '('이면 1추가, ')' 이면 -1 해서 판단 여부를 반환
def check_ps(datas):
    cnt = 0
    for data in datas:
        # "())(()" 이런 경우를 생각해봐서 cnt == -1 이면 함수 종료 시킴.
        if cnt == -1:
            return "NO"
        if data == '(':
            cnt += 1
        else:
            cnt -= 1
    if cnt == 0:
        return "YES"
    return "NO"

if __name__ == "__main__":
    N = int(input())
    
    for _ in range(N):
        print(check_ps(input()))