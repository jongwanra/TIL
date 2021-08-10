score = int(input())

if 90 <= score <= 100:
    answer = "A"
elif 70 <= score <= 89:
    answer = 'B'
elif 40 <= score <= 69:
    answer = "C"
else:
    answer = "D"
print(answer)
