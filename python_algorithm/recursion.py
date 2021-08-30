# 재귀(Recursion)

# 1. Definition
#  자기 자신을 다시 호출하는 함수

# 2. Example 1
def recur_print(n):
    if n == 10:
        return
    print(f"{n}번째 호출하였습니다.")
    recur_print(n+1)


recur_print(1)

# 3. Example 2


def sum()
