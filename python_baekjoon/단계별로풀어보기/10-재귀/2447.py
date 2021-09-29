# 별 찍기 - 10(2447)
# https://www.acmicpc.net/problem/2447
# 못 품(21.08.29)

# def draw_star(n, matrix):
#     if n == 3:
#         matrix[0][:3] = matrix[2][:3] = [1] * 3
#         matrix[1][:3] = [1, 0, 1]
#         return
#     a = n // 3
#     draw_star(n//3, matrix)
#     for i in range(3):
#         for j in range(3):
#             if i == 1 and j == 1:
#                 continue
#             for k in range(a):
#                 matrix[a * i + k][a*j:a*(j+1)] = matrix[k][:a]


# n = int(input())

# matrix = [[0] * n for _ in range(n)]

# draw_star(n, matrix)

# for i in matrix:
#     for j in i:
#         if j:
#             print('*', end="")
#         else:
#             print(' ', end="")
#     print()


def star(x):
    if x == 1:
        return ['*']
    x = x // 3
    a = star(x)
    topbottom = [i * 3 for i in a]
    middle = [i + ' ' * x + i for i in a]
    return topbottom + middle + topbottom


n = int(input())
mystar = '\n'.join(star(n))
print(mystar)
