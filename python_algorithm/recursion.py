# 재귀(Recursion)

# 1. Definition
# 자기 자신을 다시 호출하는 함수
# recursion으로 모든 loop문을 표현 가능, 그 역도 가능하다.

# 2. 재귀를 사용하는 이유
# 일반적으로 반복문보다 느리다.
# 반복문을 쓰면 코드가 개판이 되는데 재귀로 적으면 깔끔해 지는 코드를 쓰는데 활용된다.

# 3. Example
# def recur_print(n):
#     if n == 10:
#         return
#     print(f"{n}번째 호출하였습니다.")
#     recur_print(n+1)


# recur_print(1)


# 4. 재귀의 구성요소
# 종료조건!!
# 문제의 정의를 정확히 표기한다.


# 3. Example 2

# loop
# 1 ~ 10 까지의 수를 더한 값 출력하기


# def loop_sum(n):
#     sum = 0
#     for i in range(n+1):
#         sum += i
#     return sum


# print(loop_sum(10))

# recursion
# def recur_sum(n):
#     print(f" 현재 n은? {n}")
#     # 종료 조건
#     if n == 1:
#         return 1
#     return recur_sum(n-1) + n


# print(recur_sum(5))


# 3! -> 1 * 2 * 3
# 4! -> 1 * 2 * 3 * 4
# n! -> 1 * 2 * 3 ... * n
# n! -> (n-1)! * n

# def factorial(n):  # 1
#     # 종료조건
#     if n == 1:
#         return 1
#     return 1 * n


# def factorial(n):  # 2
#     # 종료조건
#     if n == 1:
#         return 1
#     return 1 * n


# def factorial(n):  # 3
#     # 종료조건
#     if n == 1:
#         return 1
#     return 2 * n


# def factorial(n):  # 4
#     # 종료조건
#     if n == 1:
#         return 1
#     return factorial(n-1) * n


# print(factorial(4))
