# 약수(1037)
# https://www.acmicpc.net/problem/1037
# 해결 / 10분 소요 / 21.12.10 (성능 108ms)

'''
접근 방법:
오름 차순으로 정렬 하고나서, 
첫 번째 요소 와 마지막 요소의 곱을 하면 N이 나온다.
'''

n = int(input())
list = sorted(list(map(int, input().split())))
print(list[0] * list[-1])