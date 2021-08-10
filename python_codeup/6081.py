def changing(a):
    if a == 'A':
        return 10
    elif a == 'B':
        return 11
    elif a == 'C':
        return 12
    elif a == 'D':
        return 13
    elif a == 'E':
        return 14
    else:
        return 15
    
    
num = input()
decimal = changing(num)
for i in range(1,16):
    print('%X'%decimal, '*%X'%i, '=%X'%(decimal*i), sep='')
