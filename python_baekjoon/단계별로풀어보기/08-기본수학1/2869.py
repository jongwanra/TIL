# 달팽이는 올라가고 싶다(2869)
# https://www.acmicpc.net/problem/2869
# 해결 / 26분 소요 / 21.12.07
a, b, v = map(int, input().split())

day = a - b
value =  v- a
if value % day == 0:
    print(value // day  + 1)    
else:
    print(value // day  + 2)


# 달팽이는 올라가고 싶다(2869)
# https://www.acmicpc.net/problem/2869

up, down, target = list(map(int, input().split()))

'''
달팽이가 정상에 도달하기 전 마지막 up을 미리 빼두었다.
그런 다음에 나머지를 구했고 나머지가 0이라면 
+ 1을 해주었고, 나머지가 있다는 건 2번을 나눠서 가야한다는 생각으로 +2를 해주었다.
'''
value = target - up
if value % (up - down) >= 1:
    print(value // (up-down) + 2)
else:
    print(value // (up-down) + 1)

