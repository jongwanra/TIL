def solution(participant, completion):
    participant_set = set(participant)
    completion_set = set(completion)
    result = list(participant_set - completion_set)
    print(result)
    return result[0]