# ACM 호텔(10250)
# https://www.acmicpc.net/problem/10250
# 18분 소요(21.12.06)
 
n = int(input()) 
for _ in range(n):
    # 호텔의 높이, 너비, 몇번째 손님인지 입력
    h, w, n = map(int, input().split()) 
    if n % h == 0:
        dong = h
        hosu = n // h
    else:
        dong = n % h
        hosu = n // h + 1
    print(f"{dong}{str(hosu).zfill(2)}")



# ACM 호텔(10250)
# https://www.acmicpc.net/problem/10250

n = int(input())
for _ in range(n):
    # 높이 h, 너비 w, 몇 번째 사람 p 입력
    h, w, p = list(map(int, input().split()))
    
    if p % h >= 1:
        ho_su = p // h + 1 
        floor =  p % h
    else:
        ho_su = p // h
        floor = h

    floor = str(floor)
    ho_su = str(ho_su).zfill(2) # 0 포함 2자리 만들기
    print(floor + ho_su)
    
            