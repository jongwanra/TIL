

# 50분 넘게 소요
# 효율성에서 떨어짐
def failedSolution(people, limit):

    memory = [0] * 241

    for person in people:
        memory[person] += 1

    print('::memory::', memory)
    usedCount = 0
    stack = sorted(people, reverse=True)

    while stack:
        print("stack::", stack)
        usedCount += 1
        restLimit = limit
        top = stack.pop()
        memory[top] -= 1
        restLimit -= top

        for weight in range(restLimit, 39, -1):
            print(":: weight::", weight)
            if memory[weight] > 0:
                memory[weight] -= 1
                print("deleted weight:", weight)
                stack.remove(weight)
                break
    return usedCount


# Other Success Solution

def solution(people, limit):
    people.sort()
    leftIdx = 0
    rightIdx = len(people) - 1

    answer = 0
    while leftIdx <= rightIdx:
        answer += 1
        if people[leftIdx] + people[rightIdx] > limit:
            rightIdx -= 1
        else:
            leftIdx += 1
            rightIdx -= 1

    return answer
