def solution(n,a,b):
    round = 0
    arr = [0] * (n + 1)
    arr[a] = 1
    arr[b] = 1


    while len(arr) >= 1:
        round += 1
        temp = arr[:]
        arr = [0]

        for i in range(1, len(temp) - 1, 2):
            # 둘이 붙었을 경우
            if temp[i] == 1 and temp[i + 1] == 1:
                return round

            if temp[i] == 1:
                arr.append(1)
            elif temp[i + 1] == 1:
                arr.append(1)
            else:
                arr.append(0)