m = int(input())

m = m % 12
if 0 <= m <= 2:
    print("winter")
elif 3 <= m <= 5:
    print("spring")
elif 6 <= m <= 8:
    print("summer")
else:
    print("fall")
    
