# 손익분기점(1712)
# https://www.acmicpc.net/problem/1712

# fixed_cost, changed_cost, notebook_cost
fixed, changed, notebook = list(map(int, input().split()))

try:
    point = fixed //(notebook - changed)
    if point < 0:
        print(-1)
    else:
        print(point + 1)
except:
    # notebook - changed == 0 인 경우,
    print(-1)